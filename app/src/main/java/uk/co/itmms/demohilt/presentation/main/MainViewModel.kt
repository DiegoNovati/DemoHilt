package uk.co.itmms.demohilt.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uk.co.itmms.demohilt.services.IDatabaseService
import uk.co.itmms.demohilt.services.ILoggerService
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loggerService: ILoggerService,
    private val databaseService: IDatabaseService,
): ViewModel() {

    sealed class State {
        data class Error(val message: String): State()
    }

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    fun doSomething() {
        try {
            loggerService.logMessage("do something")
            databaseService.listUsers().forEach {
                loggerService.logMessage("utente = $it")
            }
        } catch (e: Exception) {
            //loggerService.logError(e)
            notifyError("Database corrotto")
        }
    }

    private fun notifyError(message: String) {
        _state.value = State.Error(message)
    }
}