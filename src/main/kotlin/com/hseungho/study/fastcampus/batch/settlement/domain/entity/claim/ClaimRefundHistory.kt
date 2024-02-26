package com.hseungho.study.fastcampus.batch.settlement.domain.entity.claim

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity(name = "claim_refund_history")
data class ClaimRefundHistory(
    @Id @Column(name = "claim_refund_no")
    val id: Long,
    val claimReceiptNo: Long,

    val refundedAt: ZonedDateTime? = null,

    val sellerNo: Long,
    val refundCashAmount: BigDecimal = BigDecimal.ZERO,
    val couponSaleAmount: BigDecimal = BigDecimal.ZERO,
    val refundMileageAmount: BigDecimal = BigDecimal.ZERO,
    val subtractDeliveryAmount: BigDecimal = BigDecimal.ZERO,
    val refundDeliveryAmount: BigDecimal = BigDecimal.ZERO
): BaseEntity()
