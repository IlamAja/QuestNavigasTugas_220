package com.example.praktikumnavigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.praktikumnavigasi.R
import com.example.praktikumnavigasi.ui.theme.PraktikumNavigasiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    onSubmitBtnClick: (String, String, String, String) -> Unit,
    onBackBtnClick: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val lightPurple = Color(0xFFF3E5F5)
    val darkPurple = Color(0xFF8E44AD)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.home), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = darkPurple)
            )
        },
        containerColor = lightPurple
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text(stringResource(id = R.string.nama_lengkap)) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text(stringResource(id = R.string.alamat)) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.jenis_kelamin), color = Color.Black)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = jenisKelamin == "Laki-laki", onClick = { jenisKelamin = "Laki-laki" })
                    Text(text = "Laki-laki", color = Color.Black)
                    RadioButton(selected = jenisKelamin == "Perempuan", onClick = { jenisKelamin = "Perempuan" })
                    Text(text = "Perempuan", color = Color.Black)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.status_kawin), color = Color.Black)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = status == "Lajang", onClick = { status = "Lajang" })
                    Text(text = "Lajang", color = Color.Black)
                    RadioButton(selected = status == "Menikah", onClick = { status = "Menikah" })
                    Text(text = "Menikah", color = Color.Black)
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Button(onClick = onBackBtnClick, colors = ButtonDefaults.buttonColors(containerColor = darkPurple)) {
                    Text("Back", color = Color.White)
                }
                Button(onClick = { onSubmitBtnClick(nama, alamat, jenisKelamin, status) }, colors = ButtonDefaults.buttonColors(containerColor = darkPurple)) {
                    Text("Submit", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormIsianPreview() {
    PraktikumNavigasiTheme {
        FormIsian(onSubmitBtnClick = { _, _, _, _ -> }, onBackBtnClick = {})
    }
}
