package com.forms.shared.usecase

import com.forms.shared.usecase.dto.FormInfoInputDTO
import com.forms.shared.usecase.dto.FormRequestInputDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FormUseCase {
    fun findAvailableFormToAnsewer(userId: Long, pageable: Pageable) : Page<FormInfoInputDTO>
    fun createForm(form: FormRequestInputDTO, userId: Long)
}