package com.forms.shared.repository.model

import com.forms.shared.repository.dto.UserOutputDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "tb_user")
data class User (
		@Id
		@SequenceGenerator(name = "tb_user_id_seq", sequenceName = "tb_user_id_seq")
		@GeneratedValue(strategy = GenerationType.AUTO)
		val id: Long? = null,
		@Column(name = "email", nullable = false)
		val email: String? = null,
		@Column(name = "ranking", nullable = false)
		val ranking: Long? = null,
		@OneToMany(mappedBy="user")
		val  forms: List<Form>? = null

	) {

	constructor() : this(
			id = Long.MAX_VALUE,
			email = "",
			ranking = Long.MAX_VALUE,
			forms = emptyList<Form>()

	)
	fun UserOutputDTO.toEntity() : User = User(
		id = this.id,
		email = this.email,
		ranking = this.ranking
	)
}
