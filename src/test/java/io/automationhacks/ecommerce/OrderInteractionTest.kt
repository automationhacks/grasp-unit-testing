package io.automationhacks.ecommerce

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class OrderInteractionTest {
    private val LAPTOP = "Macbook"

    @Test
    fun `test warehouse capacity is reduced on fulfilling order`() {
        val order = Order(LAPTOP, 50)
        val warehouseMock = mock(Warehouse::class.java)

        `when`(warehouseMock.getInventory(LAPTOP)).thenReturn(0)
        `when`(warehouseMock.remove(LAPTOP, 50)).thenReturn(true)

        order.fill(warehouseMock)
        assertTrue(order.isFilled())
        assertEquals(0, warehouseMock.getInventory(LAPTOP))
    }

    @Test
    fun `test warehouse capacity is not reduced when order cannot be fulfilled`() {
       val order = Order(LAPTOP, 51)
        val warehouseMock = mock(Warehouse::class.java)
        `when`(warehouseMock.getInventory(LAPTOP)).thenReturn(50)
        `when`(warehouseMock.remove(LAPTOP, 50)).thenReturn(false)

        order.fill(warehouseMock)
        assertFalse(order.isFilled())
        assertEquals(50, warehouseMock.getInventory(LAPTOP))
    }
}