package com.forms.shared.repository

import com.forms.shared.repository.dto.FormInfoOutputDTO
import com.forms.shared.repository.dto.FormOutputDTO
import com.forms.shared.repository.dto.ResponseOutputDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ResponseRepository {
    fun save(response: ResponseOutputDTO)

}