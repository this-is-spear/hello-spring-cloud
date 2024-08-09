package tis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class HelloEurekaApplication

fun main(args: Array<String>) {
    runApplication<HelloEurekaApplication>(*args)
}
