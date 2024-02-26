package com.hseungho.study.fastcampus.batch.settlement.domain.entity.claim

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.BaseEntity
import com.hseungho.study.fastcampus.batch.settlement.domain.enums.ClaimStatus
import com.hseungho.study.fastcampus.batch.settlement.domain.enums.ClaimStatusConverter
import jakarta.persistence.Column
import jakarta.persistence.Convert
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
    @Convert(converter = ClaimStatusConverter::class)
    val claimStatus: ClaimStatus,
    val extraFeePayer: Int,
    val claimReason: Int // TODO ENUM으로
): BaseEntity()
