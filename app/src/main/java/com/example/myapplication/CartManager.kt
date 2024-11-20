package com.example.myapplication

object CartManager {
    val cartItems = mutableListOf<CartItem>()

    data class CartItem(val name: String, val price: Double, var quantity: Int)

    fun addToCart(name: String, price: Double) {
        val existingItem = cartItems.find { it.name == name }
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            cartItems.add(CartItem(name, price, 1))
        }
    }

    fun calculateTotalPrice(): Double {
        return cartItems.sumOf { it.price * it.quantity }
    }
}
