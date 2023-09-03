package com.johndev.pokedex.common.entities

data class PokemonEntity(
    val id: Int,
    val name: String,
    val types: List<String>,
    val imageUrl: String
)

fun PokemonEntity.formatId(): String {
    return String.format("#%03d", this.id)
}