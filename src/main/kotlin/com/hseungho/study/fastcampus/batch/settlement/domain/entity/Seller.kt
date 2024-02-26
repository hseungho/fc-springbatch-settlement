package com.hseungho.study.fastcampus.batch.settlement.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "seller")
data class Seller (
    @Id @Column(name = "seller_no")
    val id: Long,
    val sellerName: String,
    val businessNo: Int? = 0,
    @Column(columnDefinition = "char")
    val sellType: String,
    val bankType: String? = null,
    val accountNo: Int? = null,
    val accountOwnerName: String? = null,
    var isActive: Boolean = true,
    var defaultDeliveryAmount: Int? = 3000,
    var commission: Int? = 0
): BaseEntity()
