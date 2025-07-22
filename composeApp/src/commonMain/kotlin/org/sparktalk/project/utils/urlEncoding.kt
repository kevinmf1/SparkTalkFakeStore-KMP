package org.sparktalk.project.utils

expect fun urlEncode(value: String): String
expect fun urlDecode(value: String): String

expect fun base64Encode(value: String): String
expect fun base64Decode(value: String): String