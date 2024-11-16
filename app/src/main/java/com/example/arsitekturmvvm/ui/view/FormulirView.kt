package com.example.arsitekturmvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun FormulirView(
    modifier: Modifier = Modifier,
    pilihanJk: List<String>,
    onClickButton: (MutableList<String>) -> Unit
) {

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var JenisKelamin by remember { mutableStateOf("") }

    val listdata: MutableList<String> = mutableListOf(nama,nim,JenisKelamin,email,alamat)
    Column (modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(10.dp))




        TextField(
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("nama")
            },
            placeholder = {
                Text("Masukan nama Anda")
            }

        )
        TextField(
            value = nim,
            onValueChange = {nim = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("NIM")
            },
            placeholder = {
                Text("Masukan NIM Anda")
            }
        )

        Row {
            pilihanJk.forEach() { selectedJK ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = JenisKelamin == selectedJK, onClick = {
                        JenisKelamin = selectedJK

                    })
                    Text(selectedJK)


                }
            }
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("Masukan Email Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

        )
        TextField(
            value = alamat,
            onValueChange = {alamat= it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("alamat")
            },
            placeholder = {
                Text("Masukan alamat Anda")
            }

        )


        Button( onClick =  {
            onClickButton(listdata)
        },
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Text("save")

        }

    }

}

@Composable

fun TampilData(
    Judul: String,
    Isinya: String
){
    Row (modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(Judul, modifier = Modifier.weight(0.8f))
        Text(";", modifier = Modifier.weight(0.2f))
        Text(Isinya, modifier = Modifier.weight(2f))
    }
}







