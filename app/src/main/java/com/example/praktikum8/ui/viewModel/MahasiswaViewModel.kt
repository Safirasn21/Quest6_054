package com.example.praktikum8.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.praktikum8.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {

    //request atau event
    private val mahasiswaStateUI =
        MutableStateFlow(Mahasiswa())

    //response atau state
    val mahasiswaState:
            StateFlow<Mahasiswa> =
        mahasiswaStateUI.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>){
        mahasiswaStateUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[0],
                email = ls[0],
            )
        }
    }
}