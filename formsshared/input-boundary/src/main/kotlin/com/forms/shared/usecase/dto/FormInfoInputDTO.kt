package com.forms.shared.usecase.dto

data class FormInfoInputDTO(
    val id: Long? = null,
    val url: String,
    val title: String,
    val fillTime: Long,
)
