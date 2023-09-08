
plugins {
    id("java")
}

group = "com.forms.shared"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}