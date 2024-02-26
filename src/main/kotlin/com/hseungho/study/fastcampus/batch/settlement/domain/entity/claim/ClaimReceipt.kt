package com.hseungho.study.fastcampus.batch.settlement.domain.entity.claim

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.ZonedDateTime

@Entity(name = "claim_receipt")
data class ClaimReceipt(
    @Id @Column(name = "claim_receipt_no")
    val id: Long,
    val orderNo: Long,

    val completedAt: ZonedDateTime? = null,

    val requestType: String,
    val claimStatus: Int,
    val extraFeePayer: Int,
    val claimReason: Int // TODO ENUM으로
): BaseEntity()
