package io.automationhacks.ecommerce

class Warehouse {
    private val warehouse: HashMap<String, Int> = hashMapOf()
    fun add(product: String, quantity: Int) {
        warehouse[product] = quantity
    }

    fun remove(product: String, quantity: Int) {
        if (warehouse.contains(product).not()) {
            throw Exception("Product not found in warehouse")
        }

        if (warehouse[product] == 0) {
            throw Exception("No items for this product in the warehouse")
        }

        if (warehouse[product]!! < quantity) {
            throw Exception("Not enough items in the warehouse")
        }

        val currentQty = warehouse[product]
        val newQty = currentQty!!.minus(quantity)
        warehouse[product] = newQty
    }

    fun getInventory(product: String): Int? {
        return warehouse.get(product)
    }
}