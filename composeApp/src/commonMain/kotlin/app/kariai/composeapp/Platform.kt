package app.kariai.composeapp

interface Platform {
    val name: String
}


expect fun getPlatform(): Platform