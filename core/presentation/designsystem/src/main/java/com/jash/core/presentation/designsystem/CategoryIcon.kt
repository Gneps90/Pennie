package com.jash.core.presentation.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CategoryIcon(category: String): ImageVector {
    return when (category.lowercase()) {
        "education" -> EducationIcon
        "health" -> HealthIcon
        "transport" -> TransportIcon
        "travel" -> TravelIcon
        "food" -> FoodIcon
        "housing" -> HousingIcon
        "utilities" -> UtilsIcon
        "shopping" -> ShoppingIcon
        "entertainment" -> EntertainmentIcon
        "personal care" -> PersonalCareIcon
        "gift" -> GiftIcon
        "salary" -> TrendingUpIcon

        else -> OtherIcon
    }
}