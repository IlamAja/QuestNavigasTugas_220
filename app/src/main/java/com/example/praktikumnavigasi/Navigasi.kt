package com.example.praktikumnavigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikumnavigasi.view.FormIsian
import com.example.praktikumnavigasi.view.HalamanBeranda
import com.example.praktikumnavigasi.view.TampilData

enum class Navigasi {
    Beranda,
    Formulir,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Beranda.name,
            modifier = modifier.padding(paddingValues = isiRuang)
        ){
            composable(route = Navigasi.Beranda.name) {
                HalamanBeranda(
                    onNextButtonClicked = {
                        navController.navigate(Navigasi.Formulir.name)
                    }
                )
            }
            composable(route = Navigasi.Formulir.name){
                FormIsian (
                    onSubmitBtnClick = {
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name){
                TampilData(
                    onBackBtnClick = {cancelAndBackToFormulir(navController)}
                )
            }
        }
    }
}
private fun cancelAndBackToFormulir(
    navController: NavHostController
){
    navController.popBackStack(Navigasi.Formulir.name, inclusive = false)
}