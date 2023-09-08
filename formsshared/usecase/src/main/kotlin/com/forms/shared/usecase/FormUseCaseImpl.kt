package com.forms.shared.usecase

import com.forms.shared.repository.FormRepository
import com.forms.shared.repository.dto.FormOutputDTO
import com.forms.shared.repository.dto.UserOutputDTO
import com.forms.shared.usecase.dto.FormInfoInputDTO
import com.forms.shared.usecase.dto.FormRequestInputDTO
import com.forms.shared.usecase.util.toInput
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FormUseCaseImpl(
    private val formRepository: FormRepository
) : FormUseCase{
    override fun findAvailableFormToAnsewer(userId: Long, pageable: Pageable): Page<FormInfoInputDTO> {
        return formRepository.findAvailableFormToAnsewer(userId, pageable).toInput()
    }

    override fun createForm(form: FormRequestInputDTO, userId: Long) {
        val formEntityDto = FormOutputDTO(
            title = form.title,
            url = form.url,
            fillTime = form.fillTime,
            user = UserOutputDTO(id = userId),
            extFormId = extractExtIdFromUrl(form.url)
        )

        formRepository.save(formEntityDto)
    }

    private fun extractExtIdFromUrl(url: String) : String {
        return url.substringAfter("forms/d/e/").substringBefore("/")
    }
}