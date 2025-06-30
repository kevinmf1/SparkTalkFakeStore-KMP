package org.sparktalk.project.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import sparktalkfakestore_kmp.composeapp.generated.resources.Res
import sparktalkfakestore_kmp.composeapp.generated.resources.tas
import sparktalkfakestore_kmp.composeapp.generated.resources.tas2
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import org.sparktalk.project.styles.AppFonts

@Composable
fun ProductDetail() {
    Scaffold(modifier = Modifier.safeContentPadding()) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
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
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    ProductContent()
                }

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .heightIn(min = 56.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2962FF))
                ) {
                    Text(
                        text = "Add to Cart",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontFamily = FontFamily.Serif
                    )
                }
                 }
               }
            }
        }
    }
}

@Composable
fun ProductContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Isi Ukuran Gambar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.LightGray),  // Menambahkan background abu-abu
            contentAlignment = Alignment.Center


        ) {
        // Isi Gambar
            Image(
                painter = painterResource(Res.drawable.tas2),
                contentDescription = "Product Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
                    .wrapContentSize()


            )
        }
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFFE3EEFF))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
            {
//            Kategori
                Text(
                    text = "Fashion",
                    color = Color(0xFF2962FF),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = AppFonts.poppinsFamily()
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
//        Nama Produk

            Text(
                text = "Fjallraven - Foldsack No. 1, Fits 15 Laptops",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = AppFonts.poppinsFamily()
            )

            Spacer(modifier = Modifier.height(8.dp))
//        Ratting Produk

            Row(verticalAlignment = Alignment.CenterVertically) {
                // Custom Rating Bar dengan Star icon
                var rating by remember { mutableFloatStateOf(3.9f) }


                Spacer(modifier = Modifier.width(8.dp))

                // Review count
                Text(
                    text = "${rating} (120 Reviews)",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontFamily = AppFonts.poppinsFamily()
                )
            }
            Text(
                text = "$109.95",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = AppFonts.poppinsFamily()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Description",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = AppFonts.poppinsFamily()

            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                fontSize = 12.sp,
                color = Color.Gray,
                fontFamily = AppFonts.poppinsFamily(),
                textAlign = TextAlign.Justify,
                modifier = Modifier.fillMaxWidth(),

            )
        }

    }
}


