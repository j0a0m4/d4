package xyz.j0a0m4.adapter.api

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import xyz.j0a0m4.adapter.api.model.Action
import xyz.j0a0m4.adapter.api.model.Payload

object Home {
    fun Application.configureHomeRouting() {
        routing {
            get("/") {
                Payload(
                    data = setOf(
                        "Welcome to D4 API!",
                        "See the actions property on this payload to find more about the APIs capabilities"
                    ),
                    actions = Action(
                        name = "Go to Planner",
                        href = "/planner",
                        description = "The planner allows you to build and explore your character"
                    ).run(::setOf)
                ).let { payload ->
                    call.respond(payload)
                }
            }
        }
    }
}
