import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.google.osdetector") version "1.7.1"
    id("maven-publish")
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.allopen") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
    kotlin("plugin.jpa") version "1.9.23"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("io.spring.dependency-management")
        plugin("org.springframework.boot")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("com.google.osdetector")
        plugin("maven-publish")
    }

    group = "tis"
    version = "1.0-SNAPSHOT"

    kotlin {
        jvmToolchain(17)
    }

    extra["springCloudVersion"] = "2023.0.1"

    dependencies {
        // https://mvnrepository.com/artifact/io.netty/netty-resolver-dns-native-macos
        if (osdetector.classifier == "osx-aarch_64") {
            runtimeOnly("io.netty:netty-resolver-dns-native-macos:4.1.77.Final:${osdetector.classifier}")
        }
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.mockk:mockk:1.13.9")
        testImplementation("io.kotest", "kotest-runner-junit5", "5.4.0")
        testImplementation("io.kotest", "kotest-property", "5.4.0")
        testImplementation("com.ninja-squad:springmockk:4.0.2")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        }
    }


    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.test {
        useJUnitPlatform()
    }
}
