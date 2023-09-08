package com.forms.shared.repository.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity(name = "tb_user")
data class User (
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		val id: Long? = null,
		@Column(name = "email", nullable = false)
		val email: String,
		@Column(name = "ranking", nullable = false)
		val ranking: String,
		@OneToMany(mappedBy="user")
		@JoinColumn(name="user_id", nullable=false, updatable=false)
		val  forms: List<Form>

	) {

	constructor() : this(
			id = Long.MAX_VALUE,
			email = "",
			ranking = "",
			forms = emptyList<Form>()

	)
}