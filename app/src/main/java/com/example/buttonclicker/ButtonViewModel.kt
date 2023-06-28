package com.example.buttonclicker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

const val CLICK_INCREASE = 1

class ButtonViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(ButtonUiState())
    val uiState: StateFlow<ButtonUiState> = _uiState.asStateFlow()

    fun increment(){
        val tempScore = _uiState.value.clicks.plus(CLICK_INCREASE)
        updateState(tempScore)
    }

    fun updateState(newClicks: Int){
        _uiState.update{
            it.copy(clicks = newClicks)
        }
    }
}

