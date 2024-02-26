package com.hseungho.study.fastcampus.batch.settlement.interfaces.controller

import com.hseungho.study.fastcampus.batch.settlement.application.ClaimCompleteFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/claim")
class ClaimController(
    private val claimCompleteFacade: ClaimCompleteFacade
) {

    @GetMapping("/complete/{id}")
    fun complete(@PathVariable id: Long): ResponseEntity.HeadersBuilder<*> {
        claimCompleteFacade.receiptComplete(id)
        return ResponseEntity.noContent()
    }
}
