package com.example.praktikum8.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum8.R
import com.example.praktikum8.data.MataKuliah
import com.example.praktikum8.data.RuangKelas
import com.example.praktikum8.model.Mahasiswa
import com.example.praktikum8.ui.widget.DynamicSelectedField

@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
){
    var chosenDropdown by remember { mutableStateOf(" ") }
    var checked by remember { mutableStateOf(false) }
    var pilihanKelas by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(chosenDropdown, pilihanKelas)

    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.primary))
    ){
       Row (modifier = Modifier
           .fillMaxWidth()
           .padding(16.dp), verticalAlignment = Alignment.CenterVertically
       ){
           Image(
               painter = painterResource(id = R.drawable.umy),
               contentDescription = "",
               modifier = Modifier
                   .clip(shape = CircleShape)
                   .size(50.dp)
           )
           Spacer(modifier = Modifier.padding(start = 16.dp))
           Column (modifier = Modifier.weight(1f)){
               Text(
                   text = mahasiswa.nama,
                   fontWeight = FontWeight.Bold,
                   fontSize = 15.sp,
                   color = Color.White
               )
               Text(
                   text = mahasiswa.nim,
                   fontWeight = FontWeight.Light,
                   fontSize = 12.sp,
                   color = Color.White
               )
           }
           Box{
               Icon(
                   imageVector = Icons.Filled.Notifications,
                   contentDescription = "",
                   tint = Color.White
               )
           }
       }
        Box(
            modifier = Modifier.background(
                color = Color.White,
                shape = RoundedCornerShape(
                    topEnd = 15.dp,
                    topStart = 15.dp
                )
            )
                .fillMaxSize(),
        )
    }
}