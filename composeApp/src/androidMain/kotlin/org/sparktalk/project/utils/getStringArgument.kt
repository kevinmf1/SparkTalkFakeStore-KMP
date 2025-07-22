package org.sparktalk.project.utils

actual fun getStringArgument(arguments: Any?, key: String): String? {
    return (arguments as? android.os.Bundle)?.getString(key)
}