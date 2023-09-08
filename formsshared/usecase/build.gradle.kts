plugins {
    id("java")
}

group = "com.forms.shared"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    implementation(project(mapOf("path" to ":input-boundary")))
    implementation(project(mapOf("path" to ":output-boundary")))
}

tasks.test {
    useJUnitPlatform()
}