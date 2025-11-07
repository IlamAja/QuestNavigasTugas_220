package com.example.praktikumnavigasi.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.praktikumnavigasi.R
import com.example.praktikumnavigasi.ui.theme.PraktikumNavigasiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanBeranda(
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val lightPurple = Color(0xFFF3E5F5)
    val darkPurple = Color(0xFF8E44AD)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.selamat_datang), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = darkPurple)
            )
        },
        containerColor = lightPurple
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.muka_gue),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(64.dp))
            Text(
                text = "Muhammad Islam",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Text(
                text = "20230140220",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )
