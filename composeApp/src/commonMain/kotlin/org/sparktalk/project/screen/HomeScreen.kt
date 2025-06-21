package org.sparktalk.project.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sparktalk.project.network.ProductListScreen
import org.sparktalk.project.styles.AppTextStyles

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomTopBar("Awesome Store", showBackButton = false, showCartIcon = true)
        PromoCard()
        HorizontalDivider(
            color = Color(0xFFE5E7EB),
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
        )
        Text(
            "All Products",
            style = AppTextStyles.poppinsBold18().copy(color = Color(0xFF333446)),
            modifier = Modifier.fillMaxWidth().align(Alignment.Start).padding(start = 16.dp, top = 16.dp)
        )
        ProductListScreen()
    }

}