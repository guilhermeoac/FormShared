package com.forms.shared.repository.interfaces

import com.forms.shared.repository.model.Response
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResponseJpaRepository : JpaRepository<Response, Long>