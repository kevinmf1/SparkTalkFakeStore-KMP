package org.sparktalk.project.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.diamondedge.logging.logging
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.sparktalk.project.data.network.Product
import org.sparktalk.project.data.network.fetchProducts
import org.sparktalk.project.styles.AppTextStyles
import org.sparktalk.project.utils.base64Encode

@Composable
fun HomeScreen(navController: NavController) {
    val productsState = produceState<List<Product>?>(initialValue = null) {
        value = try {
            fetchProducts()
        } catch (_: Exception) {
            emptyList()
        }
    }
    val gridState = rememberLazyGridState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomTopBar(
            "Awesome Store",
            showBackButton = false,
            showCartIcon = true,
            onCartClick = { navController.navigate("cart") }
        )

        when (val products = productsState.value) {
            null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            else -> {
                LazyVerticalGrid(
                    state = gridState,
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item(span = { GridItemSpan(maxLineSpan) }, key = "promo_card") {
                        PromoCard(
                            onShopNowClick = {
                                coroutineScope.launch {
                                    gridState.animateScrollToItem(5)
                                }
                            }
                        )
                    }
                    item(span = { GridItemSpan(maxLineSpan) }, key = "divider") {
                        HorizontalDivider(
                            color = Color(0xFFE5E7EB),
                            modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
                        )
                    }
                    item(span = { GridItemSpan(maxLineSpan) }, key = "all_products_text") {
                        Text(
                            "All Products",
                            style = AppTextStyles.poppinsBold18().copy(color = Color(0xFF333446)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start)
                                .padding(top = 16.dp, start = 16.dp)
                        )
                    }

                    itemsIndexed(products) { index, current ->
                        val isLeftColumn = index % 2 == 0
//                        val productJson = urlEncode(Json.encodeToString(current))
                        val productJson =
                            base64Encode(Json.encodeToString(current)) // Ganti urlEncode dengan base64Encode

                        val logger = logging("productData")
                        logger.info { "dataProduct: $index" }

                        ProductCard(
                            product = current,
                            onClick = { navController.navigate("productDetail/$productJson") },
                            isLeftColumn = isLeftColumn
                        )
                    }
                }
            }
        }
    }

}