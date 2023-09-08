package com.forms.shared.controller

import com.forms.shared.usecase.FormUseCase
import java.net.URI
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("users")
class UserController(
    private val formUseCase: FormUseCase
) {
    @PutMapping("/ranking")
    fun updateRanking(
        @RequestHeader("userId") userId: Long,
        @RequestHeader("formId") formId: Long
    ) : ResponseEntity<Void> {
        formUseCase.updateRankingPointsAnsewered(formId, userId)
        return ResponseEntity.created(URI.create("/users/ranking")).build()
    }
}