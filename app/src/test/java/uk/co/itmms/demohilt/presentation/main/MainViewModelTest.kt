package uk.co.itmms.demohilt.presentation.main

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import uk.co.itmms.demohilt.BaseTest
import uk.co.itmms.demohilt.services.IDatabaseService
import uk.co.itmms.demohilt.services.ILoggerService
import java.lang.RuntimeException

class MainViewModelTest : BaseTest() {

    @MockK
    private lateinit var mockLoggerService: ILoggerService

    @MockK
    private lateinit var mockDatabaseService: IDatabaseService

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        mainViewModel = MainViewModel(
            mockLoggerService, mockDatabaseService,
        )
    }

    @Test
    fun `WHEN doSomething is invoked THEN the logger is called`() {
        every { mockDatabaseService.listUsers() } returns listOf("Diego", "Stefano")

        mainViewModel.doSomething()

        verify(exactly = 1) {
            mockLoggerService.logMessage("do something", ILoggerService.Destination.All)
            mockLoggerService.logMessage("utente = Diego", ILoggerService.Destination.All)
            mockLoggerService.logMessage("utente = Stefano", ILoggerService.Destination.All)
        }
        confirmVerified(mockLoggerService)
    }

    @Test
    fun `WHEN doSomething is invoked AND the database fails THEN `() {
        every { mockDatabaseService.listUsers() } throws RuntimeException("errore !!!!")

        mainViewModel.doSomething()
    }
}