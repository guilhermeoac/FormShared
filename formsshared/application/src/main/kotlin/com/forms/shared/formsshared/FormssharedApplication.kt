package com.forms.shared.formsshared

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@ComponentScan("com.forms.shared")
@SpringBootApplication
open class FormssharedApplication {

	companion object{
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(FormssharedApplication::class.java, *args)
		}
	}
}
