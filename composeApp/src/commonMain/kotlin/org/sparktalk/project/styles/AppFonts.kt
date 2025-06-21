package org.sparktalk.project.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import sparktalkfakestore_kmp.composeapp.generated.resources.Res
import sparktalkfakestore_kmp.composeapp.generated.resources.poppins_black
import sparktalkfakestore_kmp.composeapp.generated.resources.poppins_bold
import sparktalkfakestore_kmp.composeapp.generated.resources.poppins_light
import sparktalkfakestore_kmp.composeapp.generated.resources.poppins_medium
import sparktalkfakestore_kmp.composeapp.generated.resources.poppins_regular

@OptIn(ExperimentalResourceApi::class)
object AppFonts {
    @Composable
    fun poppinsFamily() = FontFamily(
        Font(
            resource = Res.font.poppins_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.poppins_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.poppins_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.poppins_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.poppins_black,
            weight = FontWeight.Black,
            style = FontStyle.Normal
        )
    )
}


object AppTextStyles {
    @Composable
    fun poppinsBold16() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsBold18() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsBold24() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsMedium16() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsMedium18() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsMedium24() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsRegular16() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsRegular18() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsRegular24() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsLight16() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsLight18() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Light,
        fontSize = 18.sp,
        color = Color.Black
    )

    @Composable
    fun poppinsLight24() = TextStyle(
        fontFamily = AppFonts.poppinsFamily(),
        fontWeight = FontWeight.Light,
        fontSize = 24.sp,
        color = Color.Black
    )
}