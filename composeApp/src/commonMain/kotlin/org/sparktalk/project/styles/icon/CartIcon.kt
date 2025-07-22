package org.sparktalk.project.styles.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object CustomIcons {
    val CartIcon: ImageVector
        get() {
            if (_cartIcon != null) return _cartIcon!!

            _cartIcon = ImageVector.Builder(
                name = "CartIcon",
                defaultWidth = 32.dp,
                defaultHeight = 32.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).apply {
                group {
                    path(
                        fill = SolidColor(Color(0xFF000000))
                    ) {
                        moveTo(2.08416f, 2.7512f)
                        curveTo(2.22155f, 2.36044f, 2.6497f, 2.15503f, 3.04047f, 2.29242f)
                        lineTo(3.34187f, 2.39838f)
                        curveTo(3.95839f, 2.61511f, 4.48203f, 2.79919f, 4.89411f, 3.00139f)
                        curveTo(5.33474f, 3.21759f, 5.71259f, 3.48393f, 5.99677f, 3.89979f)
                        curveTo(6.27875f, 4.31243f, 6.39517f, 4.76515f, 6.4489f, 5.26153f)
                        curveTo(6.47295f, 5.48373f, 6.48564f, 5.72967f, 6.49233f, 6f)
                        horizontalLineTo(17.1305f)
                        curveTo(18.8155f, 6f, 20.3323f, 6f, 20.7762f, 6.57708f)
                        curveTo(21.2202f, 7.15417f, 21.0466f, 8.02369f, 20.6995f, 9.76275f)
                        lineTo(20.1997f, 12.1875f)
                        curveTo(19.8846f, 13.7164f, 19.727f, 14.4808f, 19.1753f, 14.9304f)
                        curveTo(18.6236f, 15.38f, 17.8431f, 15.38f, 16.2821f, 15.38f)
                        horizontalLineTo(10.9792f)
                        curveTo(8.19028f, 15.38f, 6.79583f, 15.38f, 5.92943f, 14.4662f)
                        curveTo(5.06302f, 13.5523f, 4.99979f, 12.5816f, 4.99979f, 9.64f)
                        lineTo(4.99979f, 7.03832f)
                        curveTo(4.99979f, 6.29837f, 4.99877f, 5.80316f, 4.95761f, 5.42295f)
                        curveTo(4.91828f, 5.0596f, 4.84858f, 4.87818f, 4.75832f, 4.74609f)
                        curveTo(4.67026f, 4.61723f, 4.53659f, 4.4968f, 4.23336f, 4.34802f)
                        curveTo(3.91052f, 4.18961f, 3.47177f, 4.03406f, 2.80416f, 3.79934f)
                        lineTo(2.54295f, 3.7075f)
                        curveTo(2.15218f, 3.57012f, 1.94678f, 3.14197f, 2.08416f, 2.7512f)
                        close()
                    }
                }
                group {
                    path(
                        fill = SolidColor(Color(0xFF000000))
                    ) {
                        moveTo(7.5f, 18f)
                        curveTo(8.32843f, 18f, 9f, 18.6716f, 9f, 19.5f)
                        curveTo(9f, 20.3284f, 8.32843f, 21f, 7.5f, 21f)
                        curveTo(6.67157f, 21f, 6f, 20.3284f, 6f, 19.5f)
                        curveTo(6f, 18.6716f, 6.67157f, 18f, 7.5f, 18f)
                        close()
                    }
                }
                group {
                    path(
                        fill = SolidColor(Color(0xFF000000))
                    ) {
                        moveTo(16.5f, 18.0001f)
                        curveTo(17.3284f, 18.0001f, 18f, 18.6716f, 18f, 19.5001f)
                        curveTo(18f, 20.3285f, 17.3284f, 21.0001f, 16.5f, 21.0001f)
                        curveTo(15.6716f, 21.0001f, 15f, 20.3285f, 15f, 19.5001f)
                        curveTo(15f, 18.6716f, 15.6716f, 18.0001f, 16.5f, 18.0001f)
                        close()
                    }
                }
            }.build()

            return _cartIcon!!
        }

    private var _cartIcon: ImageVector? = null

    val icCategory: ImageVector
        get() {
            if (_icCategory != null) return _icCategory!!

            _icCategory = ImageVector.Builder(
                name = "icCategory",
                defaultWidth = 800.dp,
                defaultHeight = 800.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).apply {
                group {
                    path(
                        fill = SolidColor(Color(0xFF000000))
                    ) {
                        moveTo(7.24f, 2f)
                        horizontalLineTo(5.34f)
                        curveTo(3.15f, 2f, 2f, 3.15f, 2f, 5.33f)
                        verticalLineTo(7.23f)
                        curveTo(2f, 9.41f, 3.15f, 10.56f, 5.33f, 10.56f)
                        horizontalLineTo(7.23f)
                        curveTo(9.41f, 10.56f, 10.56f, 9.41f, 10.56f, 7.23f)
                        verticalLineTo(5.33f)
                        curveTo(10.57f, 3.15f, 9.42f, 2f, 7.24f, 2f)
                        close()
                    }
                }
                group {
                    path(
                        fill = SolidColor(Color(0xFF000000))
                    ) {
                        moveTo(18.6695f, 2f)
                        horizontalLineTo(16.7695f)
                        curveTo(14.5895f, 2f, 13.4395f, 3.15f, 13.4395f, 5.33f)
                        verticalLineTo(7.23f)
                        curveTo(13.4395f, 9.41f, 14.5895f, 10.56f, 16.7695f, 10.56f)
                        horizontalLineTo(18.6695f)
                        curveTo(20.8495f, 10.56f, 21.9995f, 9.41f, 21.9995f, 7.23f)
                        verticalLineTo(5.33f)
                        curveTo(21.9995f, 3.15f, 20.8495f, 2f, 18.6695f, 2f)
                        close()
                    }
                }
                group {
                    path(
                        fill = SolidColor(Color(0xFF000000))
                    ) {
                        moveTo(18.6695f, 13.4297f)
                        horizontalLineTo(16.7695f)
                        curveTo(14.5895f, 13.4297f, 13.4395f, 14.5797f, 13.4395f, 16.7597f)
                        verticalLineTo(18.6597f)
                        curveTo(13.4395f, 20.8397f, 14.5895f, 21.9897f, 16.7695f, 21.9897f)
                        horizontalLineTo(18.6695f)
                        curveTo(20.8495f, 21.9897f, 21.9995f, 20.8397f, 21.9995f, 18.6597f)
                        verticalLineTo(16.7597f)
                        curveTo(21.9995f, 14.5797f, 20.8495f, 13.4297f, 18.6695f, 13.4297f)
                        close()
                    }
                }
                group {
                    path(
                        fill = SolidColor(Color(0xFF000000))
                    ) {
                        moveTo(7.24f, 13.4297f)
                        horizontalLineTo(5.34f)
                        curveTo(3.15f, 13.4297f, 2f, 14.5797f, 2f, 16.7597f)
                        verticalLineTo(18.6597f)
                        curveTo(2f, 20.8497f, 3.15f, 21.9997f, 5.33f, 21.9997f)
                        horizontalLineTo(7.23f)
                        curveTo(9.41f, 21.9997f, 10.56f, 20.8497f, 10.56f, 18.6697f)
                        verticalLineTo(16.7697f)
                        curveTo(10.57f, 14.5797f, 9.42f, 13.4297f, 7.24f, 13.4297f)
                        close()
                    }
                }
            }.build()

            return _icCategory!!
        }

    private var _icCategory: ImageVector? = null

    val icProfile: ImageVector
        get() {
            if (_icProfile != null) return _icProfile!!

            _icProfile = ImageVector.Builder(
                name = "icProfile",
                defaultWidth = 800.dp,
                defaultHeight = 800.dp,
                viewportWidth = 16f,
                viewportHeight = 16f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFF000000))
                ) {
                    moveTo(8f, 7f)
                    curveTo(9.65685f, 7f, 11f, 5.65685f, 11f, 4f)
                    curveTo(11f, 2.34315f, 9.65685f, 1f, 8f, 1f)
                    curveTo(6.34315f, 1f, 5f, 2.34315f, 5f, 4f)
                    curveTo(5f, 5.65685f, 6.34315f, 7f, 8f, 7f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000))
                ) {
                    moveTo(14f, 12f)
                    curveTo(14f, 10.3431f, 12.6569f, 9f, 11f, 9f)
                    horizontalLineTo(5f)
                    curveTo(3.34315f, 9f, 2f, 10.3431f, 2f, 12f)
                    verticalLineTo(15f)
                    horizontalLineTo(14f)
                    verticalLineTo(12f)
                    close()
                }
            }.build()

            return _icProfile!!
        }

    private var _icProfile: ImageVector? = null

    val icHome: ImageVector
        get() {
            if (_icHome != null) return _icHome!!

            _icHome = ImageVector.Builder(
                name = "icHome",
                defaultWidth = 800.dp,
                defaultHeight = 800.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFF000000))
                ) {
                    moveTo(3.012f, 10.981f)
                    lineTo(3f, 11f)
                    horizontalLineTo(5f)
                    verticalLineToRelative(9f)
                    arcToRelative(1f, 1f, 0f, false, false, 1f, 1f)
                    horizontalLineTo(18f)
                    arcToRelative(1f, 1f, 0f, false, false, 1f, -1f)
                    verticalLineTo(11f)
                    horizontalLineToRelative(2f)
                    arcToRelative(1f, 1f, 0f, false, false, 0.555f, -1.832f)
                    lineToRelative(-9f, -6f)
                    arcToRelative(1f, 1f, 0f, false, false, -1.11f, 0f)
                    lineToRelative(-9f, 6f)
                    arcToRelative(1f, 1f, 0f, false, false, -0.277f, 1.387f)
                    arcTo(0.98f, 0.98f, 0f, false, false, 3.012f, 10.981f)
                    close()
                    moveTo(10f, 14f)
                    arcToRelative(1f, 1f, 0f, false, true, 1f, -1f)
                    horizontalLineToRelative(2f)
                    arcToRelative(1f, 1f, 0f, false, true, 1f, 1f)
                    verticalLineToRelative(5f)
                    horizontalLineTo(10f)
                    close()
                }
            }.build()

            return _icHome!!
        }

    private var _icHome: ImageVector? = null
}