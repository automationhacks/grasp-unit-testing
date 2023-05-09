package io.automationhacks.ecommerce

class Order(private val product: String, private val quantity: Int) {
    private lateinit var warehouse: Warehouse
    private var isFilled: Boolean = false

    fun fill(warehouse: Warehouse) {
        this.warehouse = warehouse
        isFilled = this.warehouse.remove(product, quantity)
    }

    fun isFilled(): Boolean {
        return isFilled
    }
}