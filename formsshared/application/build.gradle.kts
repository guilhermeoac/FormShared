import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("org.springframework.boot") version "3.1.3"
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":input-boundary"))
    implementation(project(":output-boundary"))
    implementation(project(":web"))
    implementation(project(":usecase"))
    implementation(project(":repository"))
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-autoconfigure:3.1.3")
}

tasks.test {
    useJUnitPlatform()
}

springBoot {
    this.mainClass = "com.forms.shared.formsshared.FormssharedApplication"
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "17"
}