package org.sparktalk.project.utils

import android.util.Base64
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

actual fun urlEncode(value: String): String = URLEncoder.encode(value, "UTF-8")
actual fun urlDecode(value: String): String = URLDecoder.decode(value, "UTF-8")

actual fun base64Encode(value: String): String {
    return Base64.encodeToString(value.toByteArray(StandardCharsets.UTF_8), Base64.NO_WRAP)
}

actual fun base64Decode(value: String): String {
    return String(Base64.decode(value, Base64.NO_WRAP), StandardCharsets.UTF_8)
}