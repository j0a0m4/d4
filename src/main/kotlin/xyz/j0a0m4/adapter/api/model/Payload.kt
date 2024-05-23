package xyz.j0a0m4.adapter.api.model

data class Payload<D>(
    val actions: Set<Action>,
    val data: D?
)
