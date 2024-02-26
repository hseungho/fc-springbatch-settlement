package com.hseungho.study.fastcampus.batch.settlement.infrastructure.database.repository

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.claim.ClaimReceipt
import org.springframework.data.jpa.repository.JpaRepository

interface ClaimReceiptRepository : JpaRepository<ClaimReceipt, Long> {
}
