package tis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloWebApplication

fun main(args: Array<String>) {
    runApplication<HelloWebApplication>(*args)
}
