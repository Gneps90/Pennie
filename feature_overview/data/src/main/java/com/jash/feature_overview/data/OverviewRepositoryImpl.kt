package com.jash.feature_overview.data


import com.jash.core.database.dao.AccountDao
import com.jash.core.database.dao.TransactionDao
import com.jash.core.database.mappers.toTransaction
import com.jash.core.domain.Transaction
import com.jash.feature_overview.domain.OverviewRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class OverviewRepositoryImpl(
    private val transactionDao: TransactionDao,
    private val accountDao: AccountDao
) : OverviewRepository {

    override fun getRecentTransactions(): Flow<List<Transaction>> {
        return transactionDao.getTransactionsFlow().map { entities ->
            entities.map { it.toTransaction() }
        }
    }

    override fun getTotalBalance(): Flow<Double> {
        val totalAccountBalance = accountDao.getAccountsFlow().map { accounts ->
            accounts.sumOf { it.initialBalance }
        }
        val totalTransactionAmount = transactionDao.getTransactionsFlow().map { transactions ->
            transactions.sumOf {
                if (it.type == "INCOME") it.amount else -it.amount
            }
        }

        return combine(totalAccountBalance, totalTransactionAmount) { accountBalance, transactionSum ->
            accountBalance + transactionSum
        }
    }

    override fun getTotalIncome(): Flow<Double> {
        return transactionDao.getTransactionsFlow().map { transactions ->
            transactions
                .filter { it.type == "INCOME" }
                .sumOf { it.amount }
        }
    }

    override fun getTotalExpenses(): Flow<Double> {
        return transactionDao.getTransactionsFlow().map { transactions ->
            transactions
                .filter { it.type == "EXPENSE" }
                .sumOf { it.amount }
        }
    }
}