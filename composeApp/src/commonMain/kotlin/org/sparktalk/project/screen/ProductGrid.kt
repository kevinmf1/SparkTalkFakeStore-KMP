package org.sparktalk.project.screen

// ProductGrid.kt
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sparktalk.project.data.network.Product
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import com.diamondedge.logging.logging
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Star
import org.sparktalk.project.styles.AppTextStyles

@Composable
fun ProductCard(
    product: Product, onClick: () -> Unit, isLeftColumn: Boolean = false
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .then(
                if (isLeftColumn) {
                    Modifier.padding(start = 16.dp, top = 15.dp, end = 8.dp, bottom = 1.dp)
                } else {
                    Modifier.padding(start = 8.dp, top = 15.dp, end = 16.dp, bottom = 1.dp)
                }
            ),
//            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                ProductImage(imageUrl = product.image)
                ProductTitle(title = product.title)
                ProductPrice(price = product.price)
                ProductRating(rate = product.rating.rate, count = product.rating.count)
            }
        }
    }
}

@Composable
fun ProductImage(imageUrl: String) {
    val logger = logging("ProductImage")
    logger.info { "Image URL: $imageUrl" }

    Box(
        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier,
            placeholder = ColorPainter(Color.LightGray),
            error = ColorPainter(Color.Red),
            onError = { state: AsyncImagePainter.State.Error ->
                // Log the error or show a message
                logger.info { "Image load error: ${state.result.throwable}" }
            }
        )
    }
}

@Composable
fun ProductTitle(title: String) {
    Text(
        text = title,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        style = AppTextStyles.poppinsRegular16(),
        modifier = Modifier.padding(8.dp),
    )
}

@Composable
fun ProductPrice(price: Double) {
    Text(
        text = "\$${price}",
        style = AppTextStyles.poppinsBold18(),
        color = Color.Black,
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}

@Composable
fun ProductRating(rate: Double, count: Int) {
    Row(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.Star,
            contentDescription = null,
            tint = Color(0xFFFFC107),
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "$rate ($count)",
            style = AppTextStyles.poppinsLight16(),
        )
    }
}