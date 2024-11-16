package com.example.arsitekturmvvm



import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.arsitekturmvvm.ui.view.FormulirView
import com.example.arsitekturmvvm.ui.view.TampilMahasiswaView
import com.example.arsitekturmvvm.model.DataJK
import com.example.arsitekturmvvm.viewmodel.MahasiswaViewModel

enum class Halaman{
    Form,
    Data
}

@Composable
fun Navigasi(

    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){

    Scaffold { isipadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost,
            startDestination = Halaman.Form.name
        ) {
            composable(route = Halaman.Form.name)
            {
                val konteks = LocalContext.current

                FormulirView (
                    pilihanJk = DataJK.isiJK.map { isi ->
                        konteks.resources.getString(isi)
                    },
                    onClickButton = {
                        viewModel.savedatamahawasiswa(it)
                        navHost.navigate(route = Halaman.Data.name)
                    }

                )
            }

            composable(route = Halaman.Data.name){
                TampilMahasiswaView(
                    mhs = uiState
                )
            }

        }
    }
}

