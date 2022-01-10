package uk.co.itmms.demohilt

import io.mockk.MockKAnnotations
import org.junit.Before

open class BaseTest {

    @Before
    fun mockSetUp() = MockKAnnotations.init(this, relaxUnitFun = true)
}