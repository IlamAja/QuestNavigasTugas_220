package com.example.praktikumnavigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikumnavigasi.DataUiState
import com.example.praktikumnavigasi.R
import com.example.praktikumnavigasi.ui.theme.PraktikumNavigasiTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    dataUiState: DataUiState,
    onBackToBerandaClick: () -> Unit,
    onBackToFormClick:() -> Unit
){
    val lightPurple = Color(0xFFF3E5F5)
    val darkPurple = Color(0xFF8E44AD)

    Scaffold (
        topBar = {
            TopAppBar(
                title = {Text(text = "List Daftar Peserta", color = Color.White)},
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = darkPurple)
            )
        },
        containerColor = lightPurple
    ){     paddingValues->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DetailItem(label = stringResource(id = R.string.nama_lengkap), value = dataUiState.nama)
            Spacer(modifier = Modifier.height(16.dp))
            DetailItem(label = stringResource(id = R.string.jenis_kelamin), value = dataUiState.jenisKelamin)
            Spacer(modifier = Modifier.height(16.dp))
            DetailItem(label = "STATUS PERKAWINAN", value = dataUiState.status)
            Spacer(modifier = Modifier.height(16.dp))
            DetailItem(label = stringResource(id = R.string.alamat), value = dataUiState.alamat)

            Spacer(modifier = Modifier.weight(1f))
