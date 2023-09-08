package com.forms.shared.repository.util

import com.forms.shared.repository.dto.FormOutputDTO
import com.forms.shared.repository.dto.UserOutputDTO
import com.forms.shared.repository.model.Form
import com.forms.shared.repository.model.User


fun UserOutputDTO.toEntity() : User = User(
    id = this.id,
    email = this.email,
    ranking = this.ranking
)
fun FormOutputDTO.toEntity() : Form = Form(
    id = this.id,
    title = this.title,
    fillTime = this.fillTime,
    url = this.url,
    extFormId = this.extFormId,
    user = this.user.toEntity()
)