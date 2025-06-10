package com.jash.core.database.mappers

import com.jash.core.database.entity.AccountEntity
import com.jash.core.database.entity.BudgetEntity
import com.jash.core.database.entity.CategoryEntity
import com.jash.core.database.entity.TransactionEntity
import com.jash.core.domain.Account
import com.jash.core.domain.Budget
import com.jash.core.domain.Category
import com.jash.core.domain.Transaction


// Transaction Mappers
fun TransactionEntity.toTransaction(): Transaction {
    return Transaction(
        id = id,
        amount = amount,
        type = type,
        category = category,
        description = description,
        date = date,
        accountId = accountId
    )
}

// Account Mappers
fun AccountEntity.toAccount(): Account {
    return Account(
        id = id,
        name = name,
        initialBalance = initialBalance,
        currency = currency,
        color = color,
        icon = icon
    )
}

// Category Mappers
fun CategoryEntity.toCategory(): Category {
    return Category(
        id = id,
        name = name,
        type = type,
        icon = icon
    )
}

// Budget Mappers
fun BudgetEntity.toBudget(): Budget {
    return Budget(
        id = id,
        name = name,
        amount = amount,
        categoryId = categoryId,
        period = period,
        startDate = startDate,
        recurring = recurring
    )
}