package com.forms.shared.repository.impl

import com.forms.shared.repository.UserRepository
import com.forms.shared.repository.dto.UserOutputDTO
import com.forms.shared.repository.interfaces.UserJpaRepository
import com.forms.shared.repository.util.toDto
import com.forms.shared.repository.util.toEntity
import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service

@Service
class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {
    override fun findById(userId: Long): UserOutputDTO? {
       return userJpaRepository.findById(userId).getOrNull()?.toDto()
    }

    override fun save(user: UserOutputDTO) {
        userJpaRepository.save(user.toEntity())
    }
}