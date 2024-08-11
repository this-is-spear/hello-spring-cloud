package tis

import java.util.UUID
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    val log: Logger = LoggerFactory.getLogger(HelloController::class.java)

    @GetMapping
    fun hello(): String {
        log.info("hello world {}", UUID.randomUUID())
        return "Hello, World!"
    }
}
