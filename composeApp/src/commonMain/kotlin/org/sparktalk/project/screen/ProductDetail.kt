package org.sparktalk.project.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProductDetail() {
    Scaffold(modifier = Modifier.safeContentPadding()) {
        Column {
            CustomTopBar(
                title = "Product Detail",
                showBackButton = true,
                showCartIcon = true,
            )
            Text("Hello world")
        }
    }
}