package xyz.j0a0m4.adapter.config

import io.ktor.server.application.*
import io.ktor.server.resources.*
import xyz.j0a0m4.adapter.api.Home.configureHomeRouting
import xyz.j0a0m4.adapter.api.planner.PlannerRouting.configurePlannerRouting

fun Application.configureRouting() {
    install(Resources)
    configureHomeRouting()
    configurePlannerRouting()
}

//@Serializable
//@Resource("/articles")
//class Articles(val sort: String? = "new")
