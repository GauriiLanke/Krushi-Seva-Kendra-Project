package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
    private val cartItems: MutableList<CartManager.CartItem>,
    private val onQuantityChange: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    // ViewHolder class
    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.itemName)
        val itemQuantity: TextView = itemView.findViewById(R.id.itemQuantity)
        val itemPrice: TextView = itemView.findViewById(R.id.itemPrice)
        val btnIncrease: Button = itemView.findViewById(R.id.btnIncrease)
        val btnDecrease: Button = itemView.findViewById(R.id.btnDecrease)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]

        // Set the data for each cart item
        holder.itemName.text = cartItem.name
        holder.itemQuantity.text = cartItem.quantity.toString()
        holder.itemPrice.text = "₹${cartItem.price * cartItem.quantity}"

        // Increase quantity
        holder.btnIncrease.setOnClickListener {
            cartItem.quantity++
            holder.itemQuantity.text = cartItem.quantity.toString()
            holder.itemPrice.text = "₹${cartItem.price * cartItem.quantity}"
            onQuantityChange() // Notify to update total price
        }

        // Decrease quantity
        holder.btnDecrease.setOnClickListener {
            if (cartItem.quantity > 1) {
                cartItem.quantity--
                holder.itemQuantity.text = cartItem.quantity.toString()
                holder.itemPrice.text = "₹${cartItem.price * cartItem.quantity}"
                onQuantityChange() // Notify to update total price
            }
        }
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }
}
