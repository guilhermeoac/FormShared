package com.forms.shared.usecase

import com.forms.shared.repository.FormRepository
import com.forms.shared.repository.ResponseRepository
import com.forms.shared.repository.dto.FormOutputDTO
import com.forms.shared.repository.dto.ResponseOutputDTO
import com.forms.shared.repository.dto.UserOutputDTO
import com.forms.shared.usecase.dto.FormInfoInputDTO
import com.forms.shared.usecase.dto.FormRequestInputDTO
import com.forms.shared.usecase.util.toInput
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ResponseUseCaseImpl(
    private val responseRepository: ResponseRepository
) : ResponseUseCase{
    override fun registerReponse(userId: Long, formId: Long) {
        responseRepository.save(ResponseOutputDTO(
            userId = userId,
            formId = formId
        ))
    }
}