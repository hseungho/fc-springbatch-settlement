package com.hseungho.study.fastcampus.batch.settlement.domain.entity

import com.hseungho.study.fastcampus.batch.settlement.configurer.persistence.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity(name = "product")
data class Product(
    @Id @Column(name = "product_no")
    val id: Long,
    val productName: String,
    val sellerNo: Long,
    val category: Int,
    val taxType: String? = "TAX",
    val sellPrice: BigDecimal? = BigDecimal.ZERO,
    val supplyPrice: BigDecimal? = BigDecimal.ZERO,
    val isActive: Boolean = true
): BaseEntity()
