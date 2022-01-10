package uk.co.itmms.demohilt.services

import android.content.Context
import javax.inject.Inject

interface IDatabaseService {

    fun listUsers(): List<String>
}

class DatabaseService @Inject constructor(
    context: Context,
    tableName: String,
) : IDatabaseService {
    override fun listUsers(): List<String> =
        //listOf("User 1", "User 2")
        throw RuntimeException("PIRLA !")

    init {
        println("********** DatabaseService: context = $context, tableName = $tableName")
    }
}