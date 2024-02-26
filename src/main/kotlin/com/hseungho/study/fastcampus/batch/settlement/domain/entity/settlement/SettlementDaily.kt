package com.hseungho.study.fastcampus.batch.settlement.domain.entity.settlement

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDate

@Entity(name = "settlement_daily")
data class SettlementDaily(
    @Id @Column(name = "settlement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(nullable = false)
    val settlementDate: LocalDate,
    @Column(nullable = false)
    val orderNo: Long,
    @Column(nullable = false)
    val claimReceiptNo: Long,
    @Column(nullable = false)
    val sellerNo: Long,
    @Column(nullable = false)
    val sellerName: String,
    val sellerBusinessNumber: String?,
    val taxType: String? = "TAX",
    val sellType: String? = "CONSIGNMENT",
    @Column(nullable = false)
    val pgSalesAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val couponDiscountAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val mileageUsageAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val shippingFeeAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val claimShippingFeeAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val commissionAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val taxAmount: BigDecimal? = BigDecimal.ZERO
): BaseEntity()
