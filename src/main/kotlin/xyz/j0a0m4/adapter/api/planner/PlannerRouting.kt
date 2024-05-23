package xyz.j0a0m4.adapter.api.planner

import io.ktor.server.application.*

object PlannerRouting {
    fun Application.configurePlannerRouting() {
        getPlannerRouting()
        createPlannerRouting()
    }
}
