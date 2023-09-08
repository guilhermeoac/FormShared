package com.forms.shared.repository

import com.forms.shared.repository.dto.UserOutputDTO

interface UserRepository {
    fun findById(userId: Long) : UserOutputDTO?

    fun save(user: UserOutputDTO)

}