package com.jash.core.domain

data class Account(
    val id: String,
    val name: String,
    val initialBalance: Double,
    val currency: String,
    val color: Int,
    val icon: String
)