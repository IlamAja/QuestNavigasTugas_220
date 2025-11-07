package com.example.praktikumnavigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikumnavigasi.view.FormIsian
import com.example.praktikumnavigasi.view.HalamanBeranda
import com.example.praktikumnavigasi.view.TampilData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DataUiState(
    val nama: String = "",
    val alamat: String = "",
    val jenisKelamin: String = "",
    val status: String = ""
)

class DataViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DataUiState())
    val uiState: StateFlow<DataUiState> = _uiState.asStateFlow()

    fun setData(nama: String, alamat: String, jenisKelamin: String, status: String) {
        _uiState.update {
            it.copy(
                nama = nama,
                alamat = alamat,
                jenisKelamin = jenisKelamin,
                status = status
            )
        }
    }
}

enum class Navigasi {
    Beranda,
    Formulir,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    dataViewModel: DataViewModel = viewModel(),
    modifier: Modifier = Modifier
){
    val uiState by dataViewModel.uiState.collectAsState()

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
                    onSubmitBtnClick = { nama, alamat, jenisKelamin, status ->
                        dataViewModel.setData(nama, alamat, jenisKelamin, status)
                        navController.navigate(Navigasi.Detail.name)
                    },
                    onBackBtnClick = { cancelAndBackToHome(navController) }
                )
            }
