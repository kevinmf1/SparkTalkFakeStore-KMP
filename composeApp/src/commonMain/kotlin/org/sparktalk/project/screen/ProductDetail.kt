package org.sparktalk.project.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import sparktalkfakestore_kmp.composeapp.generated.resources.Res
import sparktalkfakestore_kmp.composeapp.generated.resources.compose_multiplatform
import sparktalkfakestore_kmp.composeapp.generated.resources.ss
import sparktalkfakestore_kmp.composeapp.generated.resources.ss1

// feature/homepage

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
            Image(
                painter = painterResource(Res.drawable.ss1),
                contentDescription = "sadasda",
                modifier = Modifier
            )
        }
    }
}