package com.forms.shared.repository

import com.forms.shared.repository.dto.FormInputDTO
import org.springframework.data.domain.Page

interface FormRepository {
    fun findAvailableFormToAnsewer(userId: Long) : Page<FormInputDTO>

}