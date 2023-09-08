
plugins {
    id("java")
}

group = "com.forms.shared"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.3")
    runtimeOnly("org.postgresql:postgresql:42.6.0")
    implementation("org.springframework.boot:spring-boot-starter-jdbc:3.1.3")
}

tasks.test {
    useJUnitPlatform()
}