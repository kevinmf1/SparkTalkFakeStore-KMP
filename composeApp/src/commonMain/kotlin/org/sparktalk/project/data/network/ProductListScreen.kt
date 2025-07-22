package org.sparktalk.project.data.network

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.Serializable
import org.sparktalk.project.utils.DoubleAsNumberSerializer
import org.sparktalk.project.utils.getHttpClient

@Serializable
data class Product(
    val id: Int,
    val title: String,
    @Serializable(with = DoubleAsNumberSerializer::class)
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)

@Serializable
data class Rating(
    @Serializable(with = DoubleAsNumberSerializer::class)
    val rate: Double,
    val count: Int
)

suspend fun fetchProducts(): List<Product> {
    val client = getHttpClient()
    return try {
        client.get("https://fakestoreapi.com/products").body<List<Product>>()
    } catch (e: Exception) {
        println("Error fetching products: ${e.message}")
        emptyList()
    } finally {
        client.close()
    }
}

suspend fun fetchProductDetail(productId: Int): Product? {
    val client = getHttpClient()
    return try {
        client.get("https://fakestoreapi.com/products/$productId").body<Product>()
    } catch (e: Exception) {
        println("Error fetching product detail: ${e.message}")
        null
    } finally {
        client.close()
    }
}