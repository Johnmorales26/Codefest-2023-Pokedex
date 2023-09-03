package com.johndev.pokedex.ui.screens.homeModule

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.johndev.pokedex.R
import com.johndev.pokedex.common.utils.PokemonEntityList
import com.johndev.pokedex.ui.screens.homeModule.components.PokemonList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { Header() },
        content = { paddingValues -> Body(paddingValues) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Header() {
    CenterAlignedTopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) })
}

@Composable
private fun Body(paddingValues: PaddingValues) {
    val pokemonList = PokemonEntityList
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        PokemonList(pokemonList = pokemonList, paddingValues = paddingValues)
    }
}

