package com.forms.shared.controller

import com.forms.shared.repository.FormRepository
import com.forms.shared.repository.dto.FormInputDTO
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("lote")
class LoteController(
    private val formRepository: FormRepository
) {

    @GetMapping()
    fun buscaTodos(
        @RequestParam("userId") userId: Long
    ) : Page<FormInputDTO> {
        return formRepository.findAvailableFormToAnsewer(userId)
    }
}