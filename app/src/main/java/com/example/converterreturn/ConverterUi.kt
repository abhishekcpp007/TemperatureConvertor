package com.example.converterreturn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.converterreturn.ui.MyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConverterApp(    vm: MyViewModel = viewModel()) {
    val uiState =vm.uiState.collectAsState()
    Scaffold {
        contentPadding->
        Column( verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
            ) {
            Text(text = "My Converter",
                style=MaterialTheme.typography.headlineLarge,


            )
            OutlinedTextField(
                value = uiState.value.userData,
                onValueChange ={vm.onTextChange(it) },
                placeholder = { Text(text = "Enter a Temperature")},

                )
               Row(
                   verticalAlignment = Alignment.CenterVertically,

               ){
                   Text(text = if(uiState.value.isFahrenheit)"Fahrenheit" else "Celsius")
                   Switch(checked = uiState.value.isFahrenheit, onCheckedChange = {vm.updateSwithchState(it)},

                       )
               }
            Button(onClick = { vm.onSubmit()}) {
                Text(text = "Convert")

                
            }
            Text(text = uiState.value.result,
                style = MaterialTheme.typography.headlineLarge)

        }
    }




}