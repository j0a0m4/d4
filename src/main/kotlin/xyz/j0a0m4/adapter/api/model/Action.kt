package xyz.j0a0m4.adapter.api.model

import io.ktor.http.*

data class Action(
    val name: String,
    val href: String,
    val method: String = HttpMethod.Get.value,
    val description: String? = null,
) {
    constructor(name: String, href: String, method: HttpMethod, description: String? = null) : this(
        name,
        href,
        method.value,
        description
    )
}
