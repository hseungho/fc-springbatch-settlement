package com.hseungho.study.fastcampus.batch.settlement.core.job.purchaseconfirmed

import com.hseungho.study.fastcampus.batch.settlement.domain.entity.order.OrderItem
import com.hseungho.study.fastcampus.batch.settlement.infrastructure.repository.OrderItemRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

/**
 * 구매확정을 위한 Batch Job
 *
 * 5.0 이하 버전에서는 JobBuilderFactory, StepBuilderFactory 를 사용하지만,
 * 5 버전 부터는 Deprectaed 되었다.
 *
 * 대신 JobRepository, transactionManager 명시해서 사용한다.
 *
 * [https://github.com/spring-projects/spring-batch/issues/4188](https://github.com/spring-projects/spring-batch/issues/4188)
 */
@Configuration
@EnableBatchProcessing
class PurchaseConfirmedJobConfiguration(
    private val jobRepository: JobRepository,
    private val transactionManager: PlatformTransactionManager,
    @Qualifier(value = "deliveryCompletedJpaItemReader") private val deliveryCompletedJpaItemReader: JpaPagingItemReader<OrderItem>,
    private val orderItemRepository: OrderItemRepository
) {

    private companion object {
        private const val JOB_NAME: String = "purchaseConfirmedJob"
    }

    private val chunkSize: Int = 500

    @Bean
    fun purchaseConfirmedJob(): Job {
        return JobBuilder(JOB_NAME, jobRepository)
            .start(purchaseConfirmedJobStep())
            .build()
    }

    @Bean
    @JobScope
    fun purchaseConfirmedJobStep(): Step {
        return StepBuilder(JOB_NAME+"_step", jobRepository)
            .chunk<OrderItem, OrderItem>(chunkSize, transactionManager)
            .reader(deliveryCompletedJpaItemReader)
            .writer(purchaseConfirmedItemWriter())
            .build()
    }

    @Bean
    fun purchaseConfirmedItemWriter(): PurchaseConfirmedWriter {
        return PurchaseConfirmedWriter(orderItemRepository)
    }
}
