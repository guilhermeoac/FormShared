package com.forms.shared.repository

import com.forms.shared.repository.dto.FormInfoOutputDTO
import com.forms.shared.repository.dto.FormOutputDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FormRepository {
    fun findAvailableFormToAnsewer(userId: Long, pageable: Pageable) : Page<FormInfoOutputDTO>

    fun save(form: FormOutputDTO)

}