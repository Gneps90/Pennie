package com.jash.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.jash.core.database.entity.AccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Upsert
    suspend fun upsertAccount(account: AccountEntity)

    @Query("SELECT * FROM accounts ORDER BY name ASC")
    fun getAccountsFlow(): Flow<List<AccountEntity>>

    @Query("DELETE FROM accounts WHERE id = :id")
    suspend fun deleteAccount(id: String)
}