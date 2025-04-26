package org.example.kariai

interface Platform {
    val name: String
}


expect fun getPlatform(): Platform