package xyz.j0a0m4

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import xyz.j0a0m4.adapter.config.configureRouting
import xyz.j0a0m4.adapter.config.configureSerialization

fun main() {
    embeddedServer(
        factory = Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
