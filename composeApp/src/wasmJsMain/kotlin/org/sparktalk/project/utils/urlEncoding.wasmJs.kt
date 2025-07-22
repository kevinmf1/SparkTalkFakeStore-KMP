package org.sparktalk.project.utils

private val encodeURIComponent: (String) -> String = js("encodeURIComponent")
private val decodeURIComponent: (String) -> String = js("decodeURIComponent")
//private val encodeURIComponent: (String) -> String = js("encodeURIComponent")
//private val decodeURIComponent: (String) -> String = js("decodeURIComponent")
private val btoa: (String) -> String = js("btoa")
private val atob: (String) -> String = js("atob")
private val unescape: (String) -> String = js("unescape")
private val escape: (String) -> String = js("escape")

actual fun urlEncode(value: String): String = encodeURIComponent(value)
actual fun urlDecode(value: String): String = decodeURIComponent(value)

actual fun base64Encode(value: String): String {
    val encoded = encodeURIComponent(value)
    val unescaped = unescape(encoded)
    return btoa(unescaped)
}

actual fun base64Decode(value: String): String {
    val decoded = atob(value)
    val escaped = escape(decoded)
    return decodeURIComponent(escaped)
}