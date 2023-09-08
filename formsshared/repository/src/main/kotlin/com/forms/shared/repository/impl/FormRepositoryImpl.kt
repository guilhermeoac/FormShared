package com.forms.shared.repository.impl

import com.forms.shared.repository.FormRepository
import com.forms.shared.repository.dto.FormInfoOutputDTO
import com.forms.shared.repository.dto.FormOutputDTO
import com.forms.shared.repository.interfaces.FormJpaRepository
import com.forms.shared.repository.util.toEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FormRepositoryImpl(
    private val formJpaRepository: FormJpaRepository
) : FormRepository {
    override fun findAvailableFormToAnsewer(userId: Long, pageable: Pageable): Page<FormInfoOutputDTO> {
        return formJpaRepository.findAvailableFormToAnsewer(userId, pageable)
    }

    override fun save(form: FormOutputDTO) {
        formJpaRepository.save(form.toEntity())
    }
}