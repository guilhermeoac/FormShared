package com.forms.shared.repository.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity()
@Table(name = "tb_form")
data class Form (
		@Id
		@SequenceGenerator(name = "tb_form_id_seq", sequenceName = "tb_form_id_seq", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_form_id_seq")
		val id: Long? = null,
		@ManyToOne()
		val user: User? = null,
		@Column(name = "ext_form_id", nullable = false)
		val extFormId: String? = null,
		@Column(name = "url", nullable = false)
		val url: String? = null,
		@Column(name = "title", nullable = false)
		val title: String? = null,
		@Column(name = "fill_time", nullable = false)
		val fillTime: Long? = null,
		@JdbcTypeCode(SqlTypes.ARRAY)
		@Column(name = "users_filled",columnDefinition = "int4[]", nullable = true)
		val usersFilled: List<Int>? = null
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