package com.hseungho.study.fastcampus.batch.settlement.infrastructure.database

import com.hseungho.study.fastcampus.batch.settlement.domain.ClaimCompleteExecutor
import com.hseungho.study.fastcampus.batch.settlement.domain.entity.claim.ClaimReceipt
import com.hseungho.study.fastcampus.batch.settlement.domain.enums.ClaimStatus
import com.hseungho.study.fastcampus.batch.settlement.infrastructure.database.repository.ClaimReceiptRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
class ClaimCompleteJpaExecutor(
    private val claimReceiptRepository: ClaimReceiptRepository
): ClaimCompleteExecutor {
    override fun updateCompletedAt(claimId: Long) {
        val receipt = claimReceiptRepository.findByIdOrNull(claimId)
            ?: throw EntityNotFoundException("Claim Receipt Not found")
        val updateReceipt = getUpdateReceipt(receipt)

        claimReceiptRepository.save(updateReceipt)
    }

    private fun getUpdateReceipt(receipt: ClaimReceipt): ClaimReceipt {
        return receipt.copy(
            id = receipt.id,
            completedAt = ZonedDateTime.now(),
            claimStatus = ClaimStatus.COMPLETED
        )
    }
}
