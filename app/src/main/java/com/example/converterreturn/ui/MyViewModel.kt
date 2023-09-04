package com.example.converterreturn.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// step 3
data class  ConvertorState(
    val userData: String="",
    val result:String="",
    val isFahrenheit: Boolean =false
)

//step 2
class MyViewModel: ViewModel() {
    private  val _uiState= MutableStateFlow(ConvertorState())
    val uiState: StateFlow<ConvertorState> = _uiState

  // step 5

   private fun converterTemperature(){
        // step 6
        val number = _uiState.value.userData.toInt()

       var  result = if(_uiState.value.isFahrenheit){
            // convert ot celsius
            "${(number-32)*5/9}\u2103"

        }else{// convert ot farenhite
            "${(number *9/5)+32}\u2109"
        }
        _uiState.value =_uiState.value.copy(result = result)
    }
    fun updateSwithchState(isFahrenheit:Boolean){
        _uiState.value= _uiState.value.copy(isFahrenheit=isFahrenheit)
    }
  fun onUserSubmit(userData: String){
      _uiState.value = _uiState.value.copy(userData = userData)
  }

     fun onSubmit(){
         converterTemperature()
     }
    fun onTextChange(userData: String){
        _uiState.value = _uiState.value.copy(userData=userData)
    }
}