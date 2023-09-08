package com.forms.shared.controller

import com.forms.shared.usecase.FormUseCase
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
@RequestMapping("forms")
class FormsController(
    private val formUseCase: FormUseCase
) {

    @GetMapping("/available-forms")
    fun findAvailableFormToAnsewer(
        @RequestHeader("userId") userId: Long,
        @RequestParam("pageNumber") pageNumber: Int,
        @RequestParam("pageSize") pageSize: Int
    ) : ResponseEntity<Page<FormInfoInputDTO>> {
        return ResponseEntity.ok(formUseCase.findAvailableFormToAnsewer(userId, PageRequest.of(pageNumber, pageSize)))
    }
    @PostMapping(produces = ["application/json"], consumes = ["application/json"])
    fun save(
        @RequestHeader("userId") userId: Long,
        @RequestBody(required = true) request: FormRequestInputDTO
    ) : ResponseEntity<Void> {
        formUseCase.createForm(request, userId)
        return ResponseEntity.created(URI.create("/forms")).build()
    }
}