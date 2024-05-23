package xyz.j0a0m4.adapter.api.planner

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import xyz.j0a0m4.adapter.api.model.Action
import xyz.j0a0m4.adapter.api.model.Payload

fun Application.getPlannerRouting() {
    routing {
        get("/planner") {
            Payload(
                data = setOf(
                    "The planner allows you to build and explore your character!",
                    "See the actions property on this payload to find more about the endpoint available"
                ),
                actions = setOf(
                    Action(
                        name = "Create new planner for a given class",
                        href = "/planner/:class",
                        description = "Creating a planner allows you to build your class",
                        method = HttpMethod.Post
                    ),
                    Action(
                        name = "Access your Planner",
                        href = "/planner/:id",
                        description = "See how you've build your character this far"
                    ),
                    Action(
                        name = "Delete your Planner",
                        href = "/planner/:id",
                        description = "Don't want to know about this build anymore? Delete here for good.",
                        method = HttpMethod.Delete
                    )
                )
            ).let { payload ->
                call.respond(payload)
            }
        }
    }
}
