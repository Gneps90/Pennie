@file:OptIn(ExperimentalMaterial3Api::class)

package com.jash.feature_overview.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jash.core.presentation.designsystem.AnalyticsIcon
import com.jash.core.presentation.designsystem.LogoIcon
import com.jash.core.presentation.designsystem.PennieTheme
import com.jash.core.presentation.designsystem.componants.PennieScaffold
import com.jash.core.presentation.designsystem.componants.PennieToolbar
import com.jash.core.presentation.designsystem.componants.utils.DropDownItem
import com.jash.feature_overview.presentation.componants.BudgetTracker
import com.jash.feature_overview.presentation.componants.TotalBalanceCard
import com.pennie.feature_overview.presentation.R


@Composable
fun OverviewScreen(
    state: OverviewState
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )

    PennieScaffold(
        topAppbar = {
            PennieToolbar(
                showBackButton = false,
                title = stringResource(id = R.string.dashboard),
                scrollBehavior = scrollBehavior,
                menuItems = listOf(
                    DropDownItem(
                        icon = AnalyticsIcon,
                        title = stringResource(id = R.string.analytics)
                    ),
                ),
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        },

    ) {

        if(state.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(top = 64.dp, bottom = 16.dp)
            )

            {

                item {
                    TotalBalanceCard(
                        modifier = Modifier .fillMaxWidth(),
                        totalBalance = state.formattedBalance,
                        income = state.formattedIncome,
                        expenses = state.formattedExpenses,
                        onViewAllClick = { /* TODO */ }
                    )
                }
                item {
                    BudgetTracker(
                        title = state.budgetTitle,
                        progress = state.budgetProgress,
                        percentageText = state.budgetPercentageText,
                        amountText = state.budgetAmountText
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun OverviewScreenPreview() {
    PennieTheme {
        val sampleState = OverviewState(
            formattedBalance = "£7,230.50",
            formattedIncome = "£1,234.80",
            formattedExpenses = "£256.30",
            recentTransactions = listOf(
                TransactionUiModel(
                    id = "1",
                    description = "Spotify Premium",
                    amount = "-£9.99",
                    category = "Subscriptions",
                    date = "Today",
                    icon = Icons.Default.Warning // Using a placeholder icon
                ),
                TransactionUiModel(
                    id = "2",
                    description = "Salary",
                    amount = "+£2,500.00",
                    category = "Income",
                    date = "Yesterday",
                    icon = Icons.Default.Warning // Using a placeholder icon
                )
            ),
            isLoading = false // Set to false to see the content, true to see the spinner
        )

        OverviewScreen(
            state = sampleState,

        )
    }
}