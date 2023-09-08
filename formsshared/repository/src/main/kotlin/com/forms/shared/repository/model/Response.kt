package com.forms.shared.repository.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity(name = "tb_response")
data class Response (
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		val id: Long? = null,
		@ManyToOne()
		@JoinColumn(name="id", nullable=false, updatable=false)
		val user: User,
		@ManyToOne()
		@JoinColumn(name="id", nullable=false, updatable=false)
		val form: Form,
		@Column(name = "date", nullable = false, updatable=false)
		val date: LocalDateTime,
	) {

	constructor() : this(
			id = Long.MAX_VALUE,
			user = User(),
			form = Form(),
			date = LocalDateTime.now()

	)
}