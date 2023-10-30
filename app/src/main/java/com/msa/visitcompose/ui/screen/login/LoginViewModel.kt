package com.msa.visitcompose.ui.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msa.visitcompose.domain.usecases.app_entry.ReadAppEntry
import com.msa.visitcompose.domain.usecases.app_entry.SaveAppEntry
import com.msa.visitcompose.ui.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val saveAppEntry: SaveAppEntry
):ViewModel() {

    fun onEvent(event: LoginEvent){
        when(event){
            is LoginEvent.SaveAppEntry ->{
                saveUserEntry()
            }
        }

    }


    private fun saveUserEntry() {
        viewModelScope.launch {
            saveAppEntry()
        }
    }
}