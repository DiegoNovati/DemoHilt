package uk.co.itmms.demohilt.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uk.co.itmms.demohilt.services.DatabaseService
import uk.co.itmms.demohilt.services.IDatabaseService
import uk.co.itmms.demohilt.services.ILoggerService
import uk.co.itmms.demohilt.services.LoggerService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

    @Binds
    @Singleton
    abstract fun bindsLogger(logger: LoggerService): ILoggerService

    @Binds
    @Singleton
    abstract fun bindsDatabaseService(databaseService: DatabaseService): IDatabaseService
}

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideDatabaseService(
        @ApplicationContext context: Context,
    ): DatabaseService =
        DatabaseService(context, "userTable")
}