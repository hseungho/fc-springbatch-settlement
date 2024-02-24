package com.hseungho.study.fastcampus.batch.settlement.domain.entity.order

import com.hseungho.study.fastcampus.batch.settlement.configurer.persistence.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.ZonedDateTime

@Entity(name = "order_item")
data class OrderItem(
    @Id @Column(name = "order_item_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderNo: Long,
    @Column(name = "order_item_snapshot_no")
    val orderItemSnapshotNo: Long,

    val orderCount: Int? = 1,
    val itemDeliveryStatus: Int? = 0,

    val purchaseConfirmedAt: ZonedDateTime? = null,
    val shippedCompletedAt: ZonedDateTime? = null,
): BaseEntity()
