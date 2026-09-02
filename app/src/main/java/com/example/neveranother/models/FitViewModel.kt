package com.example.neveranother.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FitViewModel : ViewModel() {
    // Det er en string type, men
    var upperValue by mutableStateOf("")
    var lowerValue by mutableStateOf("")
    var spanValue by mutableStateOf("")
    var heightValue by mutableStateOf("")
}
