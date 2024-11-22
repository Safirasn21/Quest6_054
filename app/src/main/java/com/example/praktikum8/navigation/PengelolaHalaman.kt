package com.example.praktikum8.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.core.app.NavUtils
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum8.ui.screen.MahasiswaFormView
import com.example.praktikum8.ui.screen.RencanaStudyView
import com.example.praktikum8.ui.screen.SplashView
import com.example.praktikum8.ui.viewModel.MahasiswaViewModel
import com.example.praktikum8.ui.viewModel.RencanaStudyViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    MataKuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController : NavHostController = rememberNavController()
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaState.collectAsState().value
    NavHost(
        navController = navController,
        startDestination =  Halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(route = Halaman.Splash.name){
            SplashView(
                onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.MataKuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                },
        }
        composable(route = Halaman.MataKuliah.name){
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = { krsViewModel.saveDataKRS(it)},
                onBackButtonClicked = { navController.popBackStack()}
            )
        }
    }
}