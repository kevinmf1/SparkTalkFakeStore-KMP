package org.sparktalk.project.utils

import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSCharacterSet
import platform.Foundation.NSData
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.URLQueryAllowedCharacterSet
import platform.Foundation.base64EncodedStringWithOptions
import platform.Foundation.create
import platform.Foundation.dataUsingEncoding
import platform.Foundation.stringByAddingPercentEncodingWithAllowedCharacters
import platform.Foundation.stringByRemovingPercentEncoding

@Suppress("CAST_NEVER_SUCCEEDS")
actual fun urlEncode(value: String): String = (value as NSString).stringByAddingPercentEncodingWithAllowedCharacters(NSCharacterSet.URLQueryAllowedCharacterSet) ?: value

actual fun urlDecode(value: String): String = (value as NSString).stringByRemovingPercentEncoding ?: value

@OptIn(ExperimentalForeignApi::class)
actual fun base64Encode(value: String): String {
    val nsString = NSString.create(string = value)
    val data = nsString.dataUsingEncoding(NSUTF8StringEncoding)
    return data?.base64EncodedStringWithOptions(0u) ?: ""
}

@OptIn(ExperimentalForeignApi::class)
actual fun base64Decode(value: String): String {
    val nsString = NSString.create(string = value)
    val data = nsString.dataUsingEncoding(NSUTF8StringEncoding)
    val decodedData = data?.let { NSData.create(base64EncodedString = value, options = 0u) }
    return decodedData?.let {
        NSString.create(data = it, encoding = NSUTF8StringEncoding) as String
    } ?: ""
}