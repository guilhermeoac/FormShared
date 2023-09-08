package com.forms.shared.repository.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity()
@Table(name = "tb_form")
data class Form (
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		val id: Long? = null,
		@ManyToOne()
		val user: User,
		@Column(name = "ext_form_id", nullable = false)
		val extFormId: String,
		@Column(name = "url", nullable = false)
		val url: String,
		@Column(name = "title", nullable = false)
		val title: String,
		@Column(name = "fill_time", nullable = false)
		val fillTime: Long,
		@JdbcTypeCode(SqlTypes.ARRAY)
		@Column(name = "users_filled",columnDefinition = "int4[]", nullable = true)
		val usersFilled: List<Int>
	) {

	constructor() : this(
			id = Long.MAX_VALUE,
			user = User(),
			extFormId = "",
			url = "",
			title = "",
			fillTime = Long.MAX_VALUE,
			usersFilled = emptyList<Int>()

	)
}