package com.forms.shared.usecase.util

import com.forms.shared.repository.dto.FormInfoOutputDTO
import com.forms.shared.usecase.dto.FormInfoInputDTO
import org.springframework.data.domain.Page

fun Page<FormInfoOutputDTO>.toInput() : Page<FormInfoInputDTO> = map {
    FormInfoInputDTO(
        id = it.id,
        fillTime = it.fillTime,
        url = it.url,
        title = it.title
    )
}