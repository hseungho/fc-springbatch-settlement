package com.hseungho.study.fastcampus.batch.settlement.domain

import org.springframework.stereotype.Service

@Service
class ClaimCompleteService(
    private val claimCompleteExecutor: ClaimCompleteExecutor
) {
    fun complete(claimId: Long) {
        claimCompleteExecutor.updateCompletedAt(claimId)
    }
}
