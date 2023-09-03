package com.johndev.pokedex.ui.screens.homeModule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.johndev.pokedex.common.entities.PokemonEntity
import com.johndev.pokedex.common.entities.formatId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonCard(pokemonEntity: PokemonEntity) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color.Transparent
    ) {
        PokemonCardContent(pokemonEntity = pokemonEntity)
    }
}

@Composable
private fun PokemonCardContent(pokemonEntity: PokemonEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        PokemonInfo(pokemonEntity = pokemonEntity, modifier = Modifier.fillMaxHeight()
            .weight(1f))
        PokemonImage(pokemonEntity = pokemonEntity)
    }
}

@Composable
private fun PokemonInfo(pokemonEntity: PokemonEntity, modifier: Modifier) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = pokemonEntity.formatId(),
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
            )
            Text(
                text = pokemonEntity.name,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
        }
        PokemonTypes(types = pokemonEntity.types, modifier = Modifier.fillMaxWidth().weight(1f))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PokemonTypes(types: List<String>, modifier: Modifier) {
    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(types.size) {
            AssistChip(
                onClick = { },
                label = { Text(text = types[it]) }
            )
        }
    }
}

@Composable
private fun PokemonImage(pokemonEntity: PokemonEntity) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(120.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color(0xffF0F0F0),
                    shape = RoundedCornerShape(
                        topEnd = 16.dp,
                        bottomEnd = 16.dp,
                        topStart = 64.dp,
                        bottomStart = 64.dp
                    )
                )
        )
        AsyncImage(
            modifier = Modifier
                .height(45.dp)
                .width(75.dp)
                .align(Alignment.Center),
            model = pokemonEntity.imageUrl,
            contentDescription = null
        )
    }
}
