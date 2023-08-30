package com.todo.demotodo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoToDoApplication

fun main(args: Array<String>) {
    runApplication<DemoToDoApplication>(*args)
}
