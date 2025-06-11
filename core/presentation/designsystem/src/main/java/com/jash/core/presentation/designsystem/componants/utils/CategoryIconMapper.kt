package com.jash.core.presentation.designsystem.componants.utils

fun mapCategoryToIcon(category: String): Int {

    return when (category.lowercase()) {
        "shopping" -> com.pennie.core.presentation.designsystem.R.drawable.shopping_bag
        "entertainment" -> com.pennie.core.presentation.designsystem.R.drawable.gamepad_2
        "food" -> com.pennie.core.presentation.designsystem.R.drawable.utensils
        "transport" -> com.pennie.core.presentation.designsystem.R.drawable.car_front
        "housing" -> com.pennie.core.presentation.designsystem.R.drawable.house
        "health" -> com.pennie.core.presentation.designsystem.R.drawable.heart_pulse
        "education" -> com.pennie.core.presentation.designsystem.R.drawable.graduation_cap
        "travel" -> com.pennie.core.presentation.designsystem.R.drawable.plane
        "personal care" -> com.pennie.core.presentation.designsystem.R.drawable.shower_head
        "gift" -> com.pennie.core.presentation.designsystem.R.drawable.gift
        "other" -> com.pennie.core.presentation.designsystem.R.drawable.tag
        "utilities" -> com.pennie.core.presentation.designsystem.R.drawable.lightbulb


        else -> com.pennie.core.presentation.designsystem.R.drawable.tag
    }
}