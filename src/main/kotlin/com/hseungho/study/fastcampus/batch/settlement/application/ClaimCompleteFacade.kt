package com.hseungho.study.fastcampus.batch.settlement.application

import com.hseungho.study.fastcampus.batch.settlement.domain.ClaimCompleteService
import org.springframework.stereotype.Service

@Service
class ClaimCompleteFacade(
    private val claimCompleteService: ClaimCompleteService
) {
    fun receiptComplete(claimId: Long) {
        claimCompleteService.complete(claimId)
    }
}
