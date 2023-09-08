package com.forms.shared.repository.interfaces

import com.forms.shared.repository.dto.FormInputDTO
import com.forms.shared.repository.model.Form
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface FormJpaRepository : JpaRepository<Form, Long> {
    @Query("select new com.forms.shared.repository.dto.FormInputDTO(f.id, f.url, f.title, f.fillTime) from Form f " +
            "inner join f.user u " +
            "left join Response r on (r.user.id = :userId and f.id = r.form.id) " +
            "where u.id <> :userId " +
            "and r.id is null " +
            "order by u.ranking asc")
    fun findAvailableFormToAnsewer(@Param("userId") userId: Long, pageable: Pageable): Page<FormInputDTO>
}