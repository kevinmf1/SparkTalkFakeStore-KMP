package org.sparktalk.project.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sparktalk.project.styles.AppTextStyles

@Composable
fun PromoCard(
    onShopNowClick: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFF3C81F6), Color(0xFF4F47E5))
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PromoText(
                        modifier = Modifier.weight(1f)
                    )
                    ShopNowButton(
                        onClick = onShopNowClick
                    )
                }
            }
        }
    }
}

@Composable
fun PromoText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Summer Sale!",
            style = AppTextStyles.poppinsBold18().copy(
                color = Color.White,
                fontSize = 20.sp
            )
        )
        Text(
            text = "Up to 50% off selected items.",
            style = AppTextStyles.poppinsRegular16().copy(
                color = Color.White,
                fontSize = 14.sp
            )
        )
    }
}

@Composable
fun ShopNowButton(onClick: (() -> Unit)?) {
    Button(
        onClick = { onClick?.invoke() },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color(0xFF3C81F6)
        ),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Shop Now",
            style = AppTextStyles.poppinsBold16().copy(
                fontSize = androidx.compose.ui.unit.TextUnit.Unspecified,
                color = Color(0xFF3C81F6)
            )
        )
    }
}