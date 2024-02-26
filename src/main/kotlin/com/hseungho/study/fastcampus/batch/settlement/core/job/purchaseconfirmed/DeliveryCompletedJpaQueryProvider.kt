package com.hseungho.study.fastcampus.batch.settlement.core.job.purchaseconfirmed

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.order.OrderItem
import jakarta.persistence.Query
import jakarta.persistence.TypedQuery
import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider
import java.time.ZonedDateTime

class DeliveryCompletedJpaQueryProvider(
    private val startDateTime: ZonedDateTime,
    private val endDateTime: ZonedDateTime
) : AbstractJpaQueryProvider() {

    override fun createQuery(): Query {
        val query: TypedQuery<OrderItem> = this.entityManager
            .createQuery(
                """
                    select oi from order_item oi
                    left outer join claim_receipt cr on oi.orderNo = cr.orderNo
                    where oi.shippedCompleteAt between :from and :to
                    and oi.purchaseConfirmedAt is null
                    and (cr.orderNo is null or cr.completedAt is not null)
                """.trimIndent(),
                OrderItem::class.java
            )
        query.setParameter("from", startDateTime)
        query.setParameter("to", endDateTime)

        return query
    }

    // 빈을 초기화하고, 초기화 시 검증하는 로직
    override fun afterPropertiesSet() {
    }
}
