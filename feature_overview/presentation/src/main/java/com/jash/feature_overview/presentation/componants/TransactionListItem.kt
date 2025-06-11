package com.jash.feature_overview.presentation.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.jash.core.presentation.designsystem.CategoryIcon
import com.jash.core.presentation.designsystem.PennieCoral
import com.jash.core.presentation.designsystem.PennieGreen
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

                Box(
                    modifier = Modifier
                        .width(51.dp)
                        .height(48.dp)
                        .background(
                            color = if (transaction.amount.startsWith("+")) PennieGreen else PennieCoral,
                            shape = RoundedCornerShape(size = 10.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = CategoryIcon(category = transaction.category),
                        contentDescription = transaction.category,
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.padding(start = 12.dp)) {
                    Text(
                        text = transaction.description,
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.bodyMedium,

                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = transaction.category,
                        style = MaterialTheme.typography.bodySmall,

                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = transaction.amount,
                    fontWeight = FontWeight.Bold,
                    color = if (transaction.amount.startsWith("+"))
                        PennieGreen else PennieCoral
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = transaction.date,
                    style = MaterialTheme.typography.bodySmall
                )
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
            TransactionListItem(
                transaction = TransactionUiModel(
                    id = "1",
                    description = "Spotify Premium",
                    amount = "-£9.99",
                    category = "Entertainment",
                    date = "10 Jun"
                )
            )
            TransactionListItem(
                transaction = TransactionUiModel(
                    id = "2",
                    description = "June Salary",
                    amount = "+£2,100.00",
                    category = "Salary",
                    date = "09 Jun"
                )
            )
        }
    }
}