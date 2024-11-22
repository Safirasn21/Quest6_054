package com.example.praktikum8.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns
import com.example.praktikum8.R

@Preview(showBackground = true)
@Composable
fun SplashView(onMulaiButton: () -> Unit // Menambahkan parameter fungsi
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background
                (
                color = colorResource(
                    R.color.primary
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.umy),
            contentDescription = "",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = {}
        ) {
            Text("Mulai")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashViewPreview() {
    SplashView(onMulaiButton = {})
}