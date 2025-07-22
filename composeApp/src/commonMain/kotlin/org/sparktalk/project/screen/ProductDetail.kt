package org.sparktalk.project.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Star
import kotlinx.coroutines.launch
import org.sparktalk.project.data.local.CartManager
import org.sparktalk.project.data.network.Product
import org.sparktalk.project.styles.AppTextStyles
import org.sparktalk.project.utils.capitalizeEachFirstWord
import org.sparktalk.project.utils.conditionalSafeGesturesBottomPadding
import org.sparktalk.project.utils.getCategoryBadgeStyle

@Composable
fun ProductDetail(
    product: Product,
    onBack: () -> Unit,
    navController: NavController? = null
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var showSnackbar by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.statusBarsPadding().conditionalSafeGesturesBottomPadding(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CustomTopBar(
                    title = "Product Detail",
                    showBackButton = true,
                    showCartIcon = true,
                    onBack = onBack,
                    onCartClick = { navController?.navigate("cart") }
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    ProductContent(product)
                }

                Button(
                    onClick = {
                        if (CartManager.isProductInCart(product.title)) {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Product already in cart")
                            }
                        } else {
                            val productMap = mapOf(
                                "title" to product.title,
                                "price" to product.price,
                                "description" to product.description,
                                "category" to product.category,
                                "image" to product.image,
                                "quantity" to 1
                            )
                            CartManager.addToCart(productMap)
                            showSnackbar = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .heightIn(min = 48.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
                ) {
                    Text(
                        text = "Add to Cart",
                        style = AppTextStyles.poppinsBold18().copy(
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    )
                }
            }

            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 80.dp)
            )
        }
    }

    if (showSnackbar) {
        LaunchedEffect(Unit) {
            coroutineScope.launch {
                snackbarHostState.showSnackbar("successfully added to cart")
                showSnackbar = false
            }
        }
    }
}

@Composable
fun ProductContent(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color(0xFFE5E7EB)),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = "Product Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(getCategoryBadgeStyle(product.category).first)
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            )
            {
                Text(
                    text = product.category.capitalizeEachFirstWord(),
                    style = AppTextStyles.poppinsRegular16().copy(
                        color = getCategoryBadgeStyle(product.category).second,
                        fontSize = 12.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.title,
                style = AppTextStyles.poppinsBold24().copy(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFC107),
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "${product.rating.rate} (${product.rating.count} Reviews)",
                    style = AppTextStyles.poppinsRegular16().copy(
                        color = Color.Black
                    )
                )
            }

            Text(
                modifier = Modifier.padding(top = 12.dp),
                text = "$${product.price}",
                style = AppTextStyles.poppinsBold18().copy(
                    fontSize = 28.sp,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Description",
                style = AppTextStyles.poppinsBold18().copy(
                    color = Color(0xFF1F2937)
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.description,
                style = AppTextStyles.poppinsLight16().copy(
                    color = Color(0xFF4B5563)
                )
            )
        }
    }
}