package me.kochoru.typing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TypingApplication

fun main(args: Array<String>) {
    runApplication<TypingApplication>(*args)
}
