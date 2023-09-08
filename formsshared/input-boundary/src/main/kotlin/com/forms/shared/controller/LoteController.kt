package com.forms.shared.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("lote")
class LoteController(
) {

    @GetMapping()
    fun buscaTodos() : String {
        return ""
    }
}