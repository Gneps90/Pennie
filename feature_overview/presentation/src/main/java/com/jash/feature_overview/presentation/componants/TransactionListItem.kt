package com.jash.feature_overview.presentation.componants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jash.core.presentation.designsystem.PennieCoral
import com.jash.core.presentation.designsystem.PennieGreen
import com.jash.core.presentation.designsystem.PenniePurple
import com.jash.core.presentation.designsystem.PennieTheme
import com.jash.feature_overview.presentation.TransactionUiModel

@Composable
fun TransactionListItem(
    transaction: TransactionUiModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // TODO: Replace with actual category icon
                Icon(
                    imageVector = if (transaction.amount.startsWith("+"))
                        Icons.Default.KeyboardArrowUp else
                            Icons.Default.KeyboardArrowDown,
                    contentDescription = transaction.category,
                    modifier = Modifier.size(32.dp),
                    tint = if (transaction.amount.startsWith("+"))
                        PennieGreen else PennieCoral
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.padding(start = 12.dp)) {
                    Text(text = transaction.description, fontWeight =
                        FontWeight.Medium, style =
                        MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onPrimary)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = transaction.category,
                        style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onBackground)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = transaction.category, style =
                        MaterialTheme.typography.bodySmall)
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = transaction.amount,
                    fontWeight = FontWeight.Bold,
                    color = if (transaction.amount.startsWith("+"))
                        PennieGreen else MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = transaction.date,
                    style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview(showBackground = true, name = "Transaction List Items")
@Composable
private fun TransactionListItemPreview() {
    PennieTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Preview for an Expense transaction
            TransactionListItem(
                transaction = TransactionUiModel(
                    id = "1",
                    description = "Spotify Premium",
                    amount = "-£9.99",
                    category = "Subscriptions",
                    date = "10 Jun",
                    icon = Icons.Default.Warning // Placeholder icon
                )
            )

            // Preview for an Income transaction
            TransactionListItem(
                transaction = TransactionUiModel(
                    id = "2",
                    description = "June Salary",
                    amount = "+£2,100.00",
                    category = "Salary",
                    date = "09 Jun",
                    icon = Icons.Default.Warning // Placeholder icon
                )
            )
        }
    }
}