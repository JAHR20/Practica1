package com.jahr.practica1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModelJAHR: ViewModel() {
    var showBottomSheet by mutableStateOf(false)
    var showDialogFavoritos by mutableStateOf(false)
}