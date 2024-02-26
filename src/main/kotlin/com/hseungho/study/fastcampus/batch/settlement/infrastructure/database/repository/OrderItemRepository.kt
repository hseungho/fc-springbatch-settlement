package com.hseungho.study.fastcampus.batch.settlement.infrastructure.database.repository

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.order.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import java.time.ZonedDateTime

interface OrderItemRepository : JpaRepository<OrderItem, Long> {

    fun findByShippedCompleteAtBetween(from: ZonedDateTime, to: ZonedDateTime): List<OrderItem>

}
