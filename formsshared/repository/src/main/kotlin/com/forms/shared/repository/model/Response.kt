package com.forms.shared.repository.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import java.time.LocalDateTime
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "tb_response")
data class Response (
		@Id
		@SequenceGenerator(name = "tb_response_id_seq", sequenceName = "tb_response_id_seq")
		@GeneratedValue(strategy = GenerationType.AUTO)
		val id: Long? = null,
		@ManyToOne()
		val user: User,
		@ManyToOne()
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