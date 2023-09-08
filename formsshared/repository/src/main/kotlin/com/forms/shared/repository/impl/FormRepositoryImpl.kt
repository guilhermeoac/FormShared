package com.forms.shared.repository.impl

import com.forms.shared.repository.FormRepository
import com.forms.shared.repository.dto.FormInputDTO
import com.forms.shared.repository.interfaces.FormJpaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Service

@Service
class FormRepositoryImpl(
    private val formJpaRepository: FormJpaRepository
) : FormRepository {
    override fun findAvailableFormToAnsewer(userId: Long): Page<FormInputDTO> {
        return formJpaRepository.findAvailableFormToAnsewer(userId, Pageable.unpaged())
    }
}