package com.forms.shared.repository.impl

import com.forms.shared.repository.FormRepository
import com.forms.shared.repository.ResponseRepository
import com.forms.shared.repository.dto.FormInfoOutputDTO
import com.forms.shared.repository.dto.FormOutputDTO
import com.forms.shared.repository.dto.ResponseOutputDTO
import com.forms.shared.repository.interfaces.FormJpaRepository
import com.forms.shared.repository.interfaces.ResponseJpaRepository
import com.forms.shared.repository.model.Form
import com.forms.shared.repository.model.Response
import com.forms.shared.repository.model.User
import com.forms.shared.repository.util.toEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ResponseRepositoryImpl(
    private val responseJpaRepository: ResponseJpaRepository
) : ResponseRepository {
    override fun save(response: ResponseOutputDTO) {
        responseJpaRepository.save(
            Response(
                user = User(id = response.userId),
                form = Form(id = response.formId)
            )
        )
    }
}