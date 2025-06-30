package org.sparktalk.project.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import org.sparktalk.project.network.Product
import org.sparktalk.project.network.fetchProducts
import org.sparktalk.project.styles.AppTextStyles

val nested = object : NestedScrollConnection {
    override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
        return super.onPostFling(consumed, available)
    }

    override fun onPostScroll(
        consumed: Offset,
        available: Offset,
        source: NestedScrollSource
    ): Offset {
        return super.onPostScroll(consumed, available, source)
    }

    override suspend fun onPreFling(available: Velocity): Velocity {
        return super.onPreFling(available)
    }

    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        return super.onPreScroll(available, source)
    }
}

@Composable
fun HomeScreen() {
    val productsState = produceState<List<Product>?>(initialValue = null) {
        value = try {
            fetchProducts()
        } catch (_: Exception) {
            emptyList()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomTopBar("Awesome Store", showBackButton = false, showCartIcon = true)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier,
            contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }, key = "promo_card") {
                PromoCard()
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
//            item(
//                span = { GridItemSpan(maxLineSpan) },
//                key = "promo_card"
//            ) {
//                PromoCard()
//                HorizontalDivider(
//                    color = Color(0xFFE5E7EB),
//                    modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
//                )
//                Text(
//                    "All Products",
//                    style = AppTextStyles.poppinsBold18().copy(color = Color(0xFF333446)),
//                    modifier = Modifier.fillMaxWidth().align(Alignment.Start)
//                        .padding(start = 16.dp, top = 16.dp)
//                )
//            }

            when (val products = productsState.value) {
                null -> {
                    item {
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator()
                        }
                    }
                }

                else -> {
                    itemsIndexed(products) { index, current ->
                        val isLeftColumn = index % 2 == 0
                        ProductCard(
                            product = current,
                            onClick = { /* Handle product click */ },
                            isLeftColumn = isLeftColumn
                        )
                    }
                }
            }
        }
    }

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        CustomTopBar("Awesome Store", showBackButton = false, showCartIcon = true),
//        Column(
//            modifier = Modifier.nestedScroll(nested)
//        ){
//            PromoCard()
//            HorizontalDivider(
//                color = Color(0xFFE5E7EB),
//                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
//            )
//            Text(
//                "All Products",
//                style = AppTextStyles.poppinsBold18().copy(color = Color(0xFF333446)),
//                modifier = Modifier.fillMaxWidth().align(Alignment.Start).padding(start = 16.dp, top = 16.dp)
//            )
//            ProductListScreen()
//        }
//
//    }

}