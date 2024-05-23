package xyz.j0a0m4.domain

enum class CharacterClass {
    Barbarian,
    Necromancer,
    Sorcerer,
    Rogue,
    Druid;

    companion object {
        operator fun get(value: String) = CharacterClass.entries
            .firstOrNull { it.toString().lowercase() == value.lowercase() }
    }
}
