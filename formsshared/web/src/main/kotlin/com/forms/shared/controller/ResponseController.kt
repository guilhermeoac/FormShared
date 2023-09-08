package com.forms.shared.controller

import com.forms.shared.usecase.FormUseCase
import com.forms.shared.usecase.ResponseUseCase
import com.forms.shared.usecase.dto.FormInfoInputDTO
import com.forms.shared.usecase.dto.FormRequestInputDTO
import java.net.URI
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("responses")
class ResponseController(
    private val responseUseCase: ResponseUseCase
) {

    @PostMapping
    fun save(
        @RequestHeader("userId") userId: Long,
        @RequestHeader("formId") formId: Long,
    ) : ResponseEntity<Void> {
        responseUseCase.registerReponse(userId,formId)
        return ResponseEntity.created(URI.create("/responses")).build()
    }
}