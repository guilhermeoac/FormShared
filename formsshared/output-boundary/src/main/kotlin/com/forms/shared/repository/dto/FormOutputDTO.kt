package com.forms.shared.repository.dto

data class FormOutputDTO(
    val id: Long? = null,
    val user: UserOutputDTO,
    val extFormId: String,
    val url: String,
    val title: String,
    val fillTime: Long
)
