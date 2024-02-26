package com.hseungho.study.fastcampus.batch.settlement.core.job.purchaseconfirmed

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.order.OrderItem
import com.hseungho.study.fastcampus.batch.settlement.infrastructure.repository.OrderItemRepository
import jakarta.persistence.EntityManager
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

@Configuration
class DeliveryCompletedItemReaderConfiguration(
    private val entityManager: EntityManager
) {

    val chunkSize = 500
    val startDateTime: ZonedDateTime = ZonedDateTime.of(
        LocalDate.now(),
        LocalTime.MIN,
        ZoneId.of("Asia/Seoul"))
    val endDateTime: ZonedDateTime = ZonedDateTime.of(
        LocalDate.now().plusDays(1),
        LocalTime.MIN,
        ZoneId.of("Asia/Seoul"))

    @Bean
    fun deliveryCompletedJpaItemReader(orderItemRepository: OrderItemRepository): JpaPagingItemReader<OrderItem> {

        val queryProvider = DeliveryCompletedJpaQueryProvider(startDateTime, endDateTime)

        return JpaPagingItemReaderBuilder<OrderItem>()
            .name("deliveryCompletedJpaItemReader")
            .entityManagerFactory(entityManager.entityManagerFactory)
            .queryProvider(queryProvider)
            .pageSize(chunkSize) // TODO : 주입 받는 파리미터로 분리
            .build()
    }
}