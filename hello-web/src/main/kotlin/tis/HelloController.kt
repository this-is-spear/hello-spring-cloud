package tis

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping
    fun hello(): String {
        println("hello world")
        return "Hello, World!"
    }
}
