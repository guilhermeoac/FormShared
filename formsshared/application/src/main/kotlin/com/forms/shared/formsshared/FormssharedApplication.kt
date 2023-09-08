package com.forms.shared.formsshared

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@ComponentScan("com.forms.shared")
@SpringBootApplication
@EnableJpaRepositories("com.forms.shared.repository.interfaces")
@EntityScan("com.forms.shared.repository.model")
open class FormssharedApplication {

	companion object{
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(FormssharedApplication::class.java, *args)
		}
	}
}
