package org.sparktalk.project.network

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String
)

suspend fun fetchProducts(): List<Product> {
    val client = HttpClient()
    return try {
        client.get("https://fakestoreapi.com/products").body()
    } finally {
        client.close()
    }
}

@Composable
fun ProductListScreen() {
    val productsState = produceState<List<Product>?>(initialValue = null) {
        value = try { fetchProducts() } catch (_: Exception) { emptyList() }
    }

    when (val products = productsState.value) {
        null -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        else -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                items(products) { product ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            Text(product.title, style = MaterialTheme.typography.titleMedium)
                            Text("Price: \$${product.price}", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}