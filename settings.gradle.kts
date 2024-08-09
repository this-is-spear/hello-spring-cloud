plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "hello-spring-cloud"
include("hello-gateway")
include("hello-gateway")
include("hello-web")
include("hello-eureka")
