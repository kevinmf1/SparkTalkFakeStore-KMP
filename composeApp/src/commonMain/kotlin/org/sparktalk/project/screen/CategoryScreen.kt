package org.sparktalk.project.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.sparktalk.project.Greeting
import org.sparktalk.project.styles.AppTextStyles

@Composable
fun CategoryScreen() {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        CustomTopBar(
            title = "Category",
            showBackButton = false,
            showCartIcon = false
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Take the rest of the space
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Category Screen",
                style = AppTextStyles.poppinsBold16()
            )
        }
    }
}