package io.automationhacks

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.opentest4j.AssertionFailedError
import kotlin.test.assertEquals

class CalculatorWithMockTest {
    @Test
    fun `test mock calculator add method returns mocked value`() {
        // Let's create a mock calculator
        val mockCalculator = mock(Calculator::class.java)
        // Override the default behavior
        `when`(mockCalculator.add(5, 5)).thenReturn(20)

        val actual = mockCalculator.add(5, 5)
        println("Actual result from mock: $actual")
        assertEquals(expected = 20, actual)
    }

    @Test
    fun `test mock calculator add method does not return a value for unhandled case`() {
        // Let's create a mock calculator
        val mockCalculator = mock(Calculator::class.java)
        // Override the default behavior
        `when`(mockCalculator.add(5, 5)).thenReturn(20)

        val actual = mockCalculator.add(5, 10)
        println("Actual result from mock: $actual")
        assertThrows<AssertionFailedError> { assertEquals(expected = 15, actual) }
    }
}