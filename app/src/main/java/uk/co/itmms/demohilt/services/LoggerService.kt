package uk.co.itmms.demohilt.services

import javax.inject.Inject

interface ILoggerService {

    enum class Destination {
        All, Console, Firebase
    }

    fun logError(error: String, destination: Destination = Destination.All)
    fun logMessage(message: String, destination: Destination = Destination.All)
}

class LoggerService @Inject constructor(): ILoggerService {

    override fun logError(error: String, destination: ILoggerService.Destination) {
        when (destination) {
            ILoggerService.Destination.All -> {
                println("********** error: $error")
                // firebase
            }
            ILoggerService.Destination.Console -> println("********** error: $error")
            ILoggerService.Destination.Firebase -> Unit // Firebase
        }
    }

    override fun logMessage(message: String, destination: ILoggerService.Destination) {
        when (destination) {
            ILoggerService.Destination.All -> {
                println("********** message: $message")
                // Firebase
            }
            ILoggerService.Destination.Console -> println("********** message: $message")
            ILoggerService.Destination.Firebase -> Unit // Firebase
        }
    }
}