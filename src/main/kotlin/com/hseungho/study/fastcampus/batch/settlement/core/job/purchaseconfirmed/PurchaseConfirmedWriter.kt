package com.hseungho.study.fastcampus.batch.settlement.core.job.purchaseconfirmed

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.order.OrderItem
import com.hseungho.study.fastcampus.batch.settlement.infrastructure.repository.OrderItemRepository
import org.springframework.batch.item.Chunk
import org.springframework.batch.item.ItemWriter
import org.springframework.lang.NonNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime

@Component
class PurchaseConfirmedWriter(
    private val orderItemRepository: OrderItemRepository
): ItemWriter<OrderItem> {

    @Transactional
    override fun write(@NonNull chunk: Chunk<out OrderItem>) {
        chunk.items.forEach { orderItem ->
            // Hidden Task : item PurchaseConfirmedAt 업데이트 작업
            val newItem = orderItem.copy(
                id = orderItem.id,
                purchaseConfirmedAt = ZonedDateTime.now()
            )

            // OrderItem DB 저장
            orderItemRepository.save(newItem)
        }
    }

}
