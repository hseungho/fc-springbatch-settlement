package com.hseungho.study.fastcampus.batch.settlement.domain.entity.order

import com.hseungho.study.fastcampus.batch.settlement.configurer.persistence.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity(name = "order_item_snapshot")
data class OrderItemSnapshot(
    @Id @Column(name = "order_item_snapshot_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val productNo: Long,
    val sellerNo: Long,

    val sellPrice: BigDecimal? = BigDecimal.ZERO,
    val supplyPrice: BigDecimal? = BigDecimal.ZERO,
    val promotionAmount: BigDecimal? = BigDecimal.ZERO,
    val defaultDeliveryAmount: BigDecimal? = BigDecimal.valueOf(3000),

    val itemCategory: Int? = 0,
    val taxRate: Int? = 3,
    val taxType: String = "TAX"
): BaseEntity()
