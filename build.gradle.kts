import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins {
    id("org.springframework.boot") version Versions.springBoot
    id("io.spring.dependency-management") version Versions.springDepManagement
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.spring") version Versions.kotlin
}

group = "com.davidcorrado"
version = "1.0.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    //JSON parsing
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}")

    //Spring Boot
    implementation("org.springframework.boot:spring-boot-starter:${Versions.springBoot}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:${Versions.springBoot}")

    //Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")

    //Database
    implementation("org.postgresql:postgresql:${Versions.postgres}")

    //Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test:${Versions.springBoot}")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
