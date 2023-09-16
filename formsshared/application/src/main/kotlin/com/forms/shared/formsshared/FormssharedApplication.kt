package com.forms.shared.formsshared

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


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
