package com.hseungho.study.fastcampus.batch.settlement.domain.entity.order

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity(name = "order_origin")
data class Order(
    @Id @Column(name = "order_no")
    val id: Long? = null,
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val paidConfirmedAt: ZonedDateTime? = null,

    val paidPgAmount: BigDecimal? = BigDecimal.ZERO,
    val usedMileageAmount: BigDecimal? = BigDecimal.ZERO,
    val couponDiscountAmount: BigDecimal? = BigDecimal.ZERO
): BaseEntity()
