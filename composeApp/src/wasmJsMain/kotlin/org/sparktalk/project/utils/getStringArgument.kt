package org.sparktalk.project.utils

actual fun getStringArgument(arguments: Any?, key: String): String? {
    return (arguments as? Map<*, *>)?.get(key) as? String
}