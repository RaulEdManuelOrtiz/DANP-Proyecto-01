package com.danp.proyecto_01.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.danp.proyecto_01.BottomBarScreen

const val maxLength = 6

fun navigateToDetails(navController: NavHostController, license: String, context: Context) {
    if (license.length == maxLength) {
        navController.navigate(BottomBarScreen.Details.route + "/$license")
    } else {
        Toast.makeText(context, "La matricula debe ser de 6 digitos", Toast.LENGTH_LONG).show()
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var license by remember {
            mutableStateOf("")
        }
        val pattern = remember { Regex("^[a-zA-Z0-9]*$") }
        val context = LocalContext.current
        Text(
            text = "EasyPlate",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        OutlinedTextField(
            value = license,
            placeholder = { Text(text = "Ingrese el código de la placa") },
            onValueChange = {
                if (it.matches(pattern) && it.length <= maxLength) license = it
            },
            label = { Text(text = "Placa") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { navigateToDetails(navController, license, context) }
            )
        )
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}