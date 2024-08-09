package tis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class HelloGatewayApplication

fun main(args: Array<String>) {
    runApplication<HelloGatewayApplication>(*args)
}
