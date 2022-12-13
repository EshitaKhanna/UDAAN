package com.example.udaan.screens.dashboard.students_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udaan.screens.registration.RegisterUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentViewModel: ViewModel() {
    //UI State
    private val _uiState = MutableStateFlow(StudentUiState())

    //Backing Property
    val uiState: StateFlow<StudentUiState> =  _uiState.asStateFlow()

    /*private val itemsList = MutableStateFlow(listOf<StudentUiState>())
    val items: StateFlow<List<StudentUiState>> get() = itemsList


    private fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                itemsList.emit(Data.items)
            }
        }
    }*/
}