package com.hseungho.study.fastcampus.batch.settlement.domain

interface ClaimCompleteExecutor {
    fun updateCompletedAt(claimId: Long)
}
