package app.kariai.storage.nutrition

data class NutritionStats(
    val caloriesSpent: Int = 0,
    val caloriesBurned: Int = 0,
    val carbs: Int = 0,
    val proteins: Int = 0,
    val fats: Int = 0,

    val distanceKm: Double = 0.0,
    val activityKcal: Double = 0.0,

    val goalsMain: Int = 0,
)