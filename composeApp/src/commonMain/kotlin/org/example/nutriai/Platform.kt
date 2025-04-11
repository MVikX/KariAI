package org.example.nutriai

interface Platform {
    val name: String
}


expect fun getPlatform(): Platform