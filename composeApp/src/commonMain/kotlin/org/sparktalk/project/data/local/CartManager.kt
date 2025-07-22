package org.sparktalk.project.data.local

import androidx.compose.runtime.mutableStateListOf

object CartManager {
    val cartItems = mutableStateListOf<MutableMap<String, Any>>()
    fun getCartItems(): List<Map<String, Any>> = cartItems

    fun isProductInCart(productTitle: String): Boolean {
        return cartItems.any { it["title"] == productTitle }
    }

    fun addToCart(product: Map<String, Any>) {
        val index = cartItems.indexOfFirst { it["title"] == product["title"] }
        if (index != -1) {
            val quantity = (cartItems[index]["quantity"] as? Int ?: 1) + 1
            cartItems[index]["quantity"] = quantity
        } else {
            val newProduct = product.toMutableMap()
            newProduct["quantity"] = (product["quantity"] as? Int) ?: 1
            cartItems.add(newProduct)
        }
    }

    fun incrementQuantity(productTitle: String) {
        val index = cartItems.indexOfFirst { it["title"] == productTitle }
        if (index != -1) {
            val quantity = (cartItems[index]["quantity"] as? Int ?: 1) + 1
            cartItems[index]["quantity"] = quantity
        }
    }

    fun removeFromCart(product: Map<String, Any>) {
        cartItems.removeAll { it["title"] == product["title"] }
    }

    fun updateQuantity(product: Map<String, Any>, quantity: Int) {
        val index = cartItems.indexOfFirst { it["title"] == product["title"] }
        if (index != -1) {
            val updatedProduct = cartItems[index].toMutableMap()
            updatedProduct["quantity"] = quantity
            cartItems[index] = updatedProduct
        }
    }
}