package org.sparktalk.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform