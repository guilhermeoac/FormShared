import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
	id("org.springframework.boot") version "3.1.3" apply false
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
	id("java")
}

group = "com.forms.shared"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

subprojects {
	repositories {
		mavenCentral()
	}
	apply(plugin = "org.jetbrains.kotlin.jvm")

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web:3.1.3")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")
		implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.22")
		testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.3")
		implementation("org.springframework.data:spring-data-commons:3.1.3")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.3")
	}

	apply {
		plugin("io.spring.dependency-management")
	}

}

allprojects {
	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs += "-Xjsr305=strict"
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

dependencyManagement {
	imports {
		mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
	}
}
