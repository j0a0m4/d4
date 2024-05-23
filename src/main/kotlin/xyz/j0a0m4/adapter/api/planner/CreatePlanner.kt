package xyz.j0a0m4.adapter.api.planner

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import xyz.j0a0m4.adapter.api.model.Action
import xyz.j0a0m4.adapter.api.model.Payload
import xyz.j0a0m4.domain.CharacterClass
import java.util.*

@Serializable
data class PlannerCreatedResponse(
    val charClass: CharacterClass,
    val id: String = UUID.randomUUID().toString()
)

private val createClassActions = CharacterClass.entries
    .map { it.toString() }
    .map {
        Action(
            name = "Create a planner for $it",
            href = "/planner/${it.lowercase()}",
            method = HttpMethod.Post
        )
    }.toSet()

private val missingPathParameter = Payload(
    data = "Can't create planner without a valid character class on path parameter",
    actions = createClassActions
)

fun Application.createPlannerRouting() {
    routing {
        post("/planner") {
            call.respond(missingPathParameter)
        }
        post("/planner/{class}") {
            val charClass = call.parameters["class"]
                ?.let { param -> CharacterClass[param] }
                ?: return@post call.respond(missingPathParameter)

            val response = PlannerCreatedResponse(charClass)

            Payload(
                data = response,
                actions = setOf(
                    Action(
                        name = "Access your Planner",
                        href = "/planner/${response.id}",
                        description = "Go to your newly created planner"
                    ),
                    Action(
                        name = "Delete your Planner",
                        href = "/planner/${response.id}",
                        description = "Choose the wrong class? Don't worry, it's okay to make mistakes",
                        method = HttpMethod.Delete
                    )
                )
            ).let { payload -> call.respond(payload) }
        }
    }
}

