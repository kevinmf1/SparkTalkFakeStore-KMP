package org.sparktalk.project.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch
import org.sparktalk.project.data.local.CartManager
import org.sparktalk.project.styles.AppTextStyles
import kotlin.math.roundToInt


@Composable
fun CartItem(
    product: Map<String, Any>,
    index: Int,
    onQuantityChanged: ((Int) -> Unit)? = null,
    onRemove: (() -> Unit)? = null
) {
    val quantity by remember(product) {
        derivedStateOf { (product["quantity"] as? Int) ?: 1 }
    }
    val isFirst = index == 0

    Card(
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFDDDDDD)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = if (isFirst) 16.dp else if (index % 2 == 0) 16.dp else 0.dp,
                horizontal = 16.dp
            )
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.Top
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFDDDDDD)),
                elevation = CardDefaults.cardElevation(0.dp),
                modifier = Modifier.size(80.dp)
            ) {
                AsyncImage(
                    model = product["image"] as? String ?: "",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = product["title"]?.toString() ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = AppTextStyles.poppinsRegular16()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = product["category"]?.toString()?.replaceFirstChar { it.uppercase() }
                        ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = AppTextStyles.poppinsLight16().copy(color = Color.Black)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$${product["price"]}",
                    style = AppTextStyles.poppinsBold18().copy(color = Color.Black)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IncrementDecrementButton(
                    initialValue = quantity,
                    onValueChange = {
                        onQuantityChanged?.invoke(it)
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Remove",
                    color = Color.Red,
                    style = AppTextStyles.poppinsRegular16(),
                    modifier = Modifier.clickable { onRemove?.invoke() }
                )
            }
        }
    }
}

@Composable
fun IncrementDecrementButton(
    initialValue: Int = 1,
    onValueChange: (Int) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.5.dp, Color(0xFFDDDDDD)),
        color = Color.White,
        modifier = Modifier.height(40.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 4.dp)
        ) {
            IconButton(
                icon = Icons.Default.Remove,
                enabled = initialValue > 1,
                onClick = {
                    onValueChange(initialValue - 1)
                }
            )

            VerticalDivider()
            PaddingValueText(initialValue)
            VerticalDivider()

            IconButton(
                icon = Icons.Default.Add,
                enabled = true,
                onClick = {
                    onValueChange(initialValue + 1)
                }
            )
        }
    }
}

@Composable
private fun IconButton(
    icon: ImageVector,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .size(18.dp)
            .clickable(
                enabled = enabled,
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (enabled) Color.Black else Color.Gray,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
private fun VerticalDivider() {
    Divider(
        color = Color(0xFFDDDDDD),
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 8.dp)
            .width(1.5.dp)
    )
}

@Composable
private fun PaddingValueText(value: Int) {
    Box(
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Text(
            text = value.toString(),
            fontSize = 16.sp,
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
fun CartScreen() {
    val cartItems = CartManager.cartItems
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            CustomTopBar(
                title = "Cart Page",
                showBackButton = false,
                showCartIcon = true
            )
        },
        bottomBar = {
            SubtotalItem(cartItems = cartItems, onCheckout = {
                scope.launch {
                    if (cartItems.isEmpty()) {
                        snackbarHostState.showSnackbar(
                            message = "Maaf, belum ada item yang ditambahkan",
                            duration = SnackbarDuration.Short
                        )
                    } else {
                        snackbarHostState.showSnackbar(
                            message = "Item berhasil dicheckout",
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            })
        },
    ) { innerPadding ->
        if (cartItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFF9FAFB)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Your cart is empty.",
                    style = AppTextStyles.poppinsBold18()
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFF9FAFB))
            ) {
                LazyColumn {
                    items(cartItems.size) { index ->
                        val item = cartItems[index]
                        CartItem(
                            product = item,
                            index = index,
                            onQuantityChanged = { newQuantity ->
                                CartManager.updateQuantity(item, newQuantity)
                            },
                            onRemove = {
                                CartManager.removeFromCart(item)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SubtotalItem(
    cartItems: SnapshotStateList<MutableMap<String, Any>>,
    onCheckout: () -> Unit
) {

    val subtotal by remember(cartItems) {
        derivedStateOf {
            cartItems.sumOf {
                (it["price"] as? Number)?.toDouble()?.times((it["quantity"] as? Int ?: 1)) ?: 0.0
            }
        }
    }

    val totalQuantity by remember(cartItems) {
        derivedStateOf {
            cartItems.sumOf { (it["quantity"] as? Int) ?: 1 }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .drawBehind {
                drawLine(
                    color = Color(0xFFE5E7EB),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 2f
                )
            }
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Subtotal ($totalQuantity items)",
                style = AppTextStyles.poppinsRegular16().copy(
                    color = Color.Black,
                    fontSize = 14.sp
                )
            )
            Text(
                text = "$${(subtotal * 100).roundToInt() / 100.0}",
                style = AppTextStyles.poppinsBold18().copy(
                    color = Color.Black,
                    fontSize = 16.sp
                )
            )
        }
        Button(
            onClick = onCheckout,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A))
        ) {
            Text("Proceed to Checkout")
        }
    }
}