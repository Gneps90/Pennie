package com.jash.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jash.core.database.dao.AccountDao
import com.jash.core.database.dao.BudgetDao
import com.jash.core.database.dao.CategoryDao
import com.jash.core.database.dao.TransactionDao
import com.jash.core.database.entity.AccountEntity
import com.jash.core.database.entity.BudgetEntity
import com.jash.core.database.entity.CategoryEntity
import com.jash.core.database.entity.TransactionEntity
import com.jash.core.database.entity.ZonedDateTimeConverter

@Database(
    entities = [
        TransactionEntity::class,
        AccountEntity:: class,
        CategoryEntity::class,
        BudgetEntity::class,

    ],
    version = 1
)
@TypeConverters(
    ZonedDateTimeConverter::class
)
abstract class PennieDatabase : RoomDatabase() {
    abstract val transactionDao: TransactionDao
    abstract val accountDao: AccountDao
    abstract val categoryDao: CategoryDao
    abstract val budgetDao: BudgetDao
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE budgets ADD COLUMN isPrimary INTEGER NOT NULL DEFAULT 0")
    }
}
