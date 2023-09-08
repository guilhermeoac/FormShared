package com.forms.shared.repository.dto

data class FormInputDTO(
    val id: Long? = null,
    val url: String,
    val title: String,
    val fillTime: Long,
)
