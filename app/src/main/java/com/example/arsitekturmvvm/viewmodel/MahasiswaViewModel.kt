package com.example.arsitekturmvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.arsitekturmvvm.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MahasiswaViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(Mahasiswa())
    val uiState: StateFlow<Mahasiswa> = _uiState.asStateFlow()

    fun savedatamahawasiswa(
        ls :MutableList<String>
    ){
        _uiState.update { data ->
            data.copy(
                nama = ls[0],
                nim = ls[1],
                gender = ls[2],
                email = ls[3],
                alamat = ls[4]
            )
        }
    }
}
