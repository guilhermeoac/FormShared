package com.forms.shared.repository.dto

data class FormInfoOutputDTO(
    val id: Long? = null,
    val url: String,
    val title: String,
    val fillTime: Long,
)
