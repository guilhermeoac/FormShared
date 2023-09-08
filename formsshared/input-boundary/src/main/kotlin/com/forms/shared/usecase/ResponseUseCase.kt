package com.forms.shared.usecase

interface ResponseUseCase {
    fun registerReponse(userId: Long, formId: Long)
}