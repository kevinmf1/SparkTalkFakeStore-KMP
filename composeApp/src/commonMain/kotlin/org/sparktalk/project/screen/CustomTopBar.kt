package org.sparktalk.project.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.ShoppingCart
import org.sparktalk.project.styles.AppTextStyles

@Composable
fun CustomTopBar(
    title: String,
    showBackButton: Boolean,
    onBack: (() -> Unit)? = null,
    showCartIcon: Boolean = false,
    onCartClick: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                // Top border
                drawLine(
                    color = Color(0xFFE5E7EB),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 2f
                )
                // Bottom border
                drawLine(
                    color = Color(0xFFE5E7EB),
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 2f
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (showBackButton) {
                IconButton(
                    onClick = { onBack?.invoke() },
                    modifier = Modifier.padding(start = 8.dp),
                    content = {
                        Icon(
                            imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                            contentDescription = "Back",
                            tint = Color(0xFF333446),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )
            } else {
                Spacer(modifier = Modifier.width(24.dp))
            }

            Text(
                text = title,
                style = AppTextStyles.poppinsBold18().copy(color = Color(0xFF333446)),
                maxLines = 1,
                modifier = Modifier
                    .weight(1f),
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            when {
                showCartIcon -> {
                    IconButton(
                        onClick = { onCartClick?.invoke() },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Icon(
                            imageVector = FontAwesomeIcons.Solid.ShoppingCart,
                            contentDescription = "Cart",
                            tint = Color(0xFF333446),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                else -> Spacer(modifier = Modifier.width(24.dp))
            }
        }
    }
}