package com.hseungho.study.fastcampus.batch.settlement.domain.entity.claim

import com.hseungho.study.fastcampus.batch.settlement.configurer.persistence.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "claim_item")
data class ClaimItem(
    @Id @Column(name = "claim_item_no")
    val id: Long,
    val claimReceiptNo: Long,

    val orderItemNo: Long,
    val claimCount: Int? = 1
): BaseEntity()
