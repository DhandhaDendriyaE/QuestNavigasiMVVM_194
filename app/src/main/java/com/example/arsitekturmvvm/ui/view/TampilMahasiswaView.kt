package com.example.arsitekturmvvm.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.arsitekturmvvm.model.Mahasiswa


@Composable

fun TampilMahasiswaView(
    mhs: Mahasiswa
){

    Column (modifier = Modifier.fillMaxSize()){
        TampilData(
            Judul = "Nama",
            Isinya = mhs.nama
        )
        TampilData(
            Judul = "NIM",
            Isinya = mhs.nim
        )
        TampilData(
            Judul = "Jenis Kelamin",
            Isinya = mhs.gender
        )
        TampilData(
            Judul = "Email",
            Isinya = mhs.email
        )
        TampilData(
            Judul = "Alamat",
            Isinya = mhs.alamat
        )
    }
}
