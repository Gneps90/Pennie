package com.jash.feature_overview.presentation.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jash.core.presentation.designsystem.PennieTheme
import com.jash.core.presentation.designsystem.TrendingDownIcon
import com.jash.core.presentation.designsystem.TrendingUpIcon
import com.jash.core.presentation.designsystem.WifiIcon

@Composable
fun TotalBalanceCard(
    totalBalance: String,
    income: String,
    expenses: String,
    modifier: Modifier = Modifier,
    onViewAllClick: () -> Unit
) {
    Card(
        modifier = modifier
            .width(338.dp)
            .height(169.dp),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0x996366F1),
                                Color(0xCC6366F1)
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(text = "Total Balance", color = Color.White)
                    Text(text = totalBalance, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Text(
                                text = "Income",
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.surface,
                            )
                            Icon(
                                imageVector = TrendingUpIcon,
                                contentDescription = "Income",
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = income,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }


                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Text(
                                text = "Expense",
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.surface,
                            )
                            Icon(
                                imageVector = TrendingDownIcon,
                                contentDescription = "Expense",
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = expenses,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextButton(onClick = onViewAllClick) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "View All",
                            color = MaterialTheme.colorScheme.surface,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }


                Spacer(modifier = Modifier.width(4.dp))


                Icon(
                    imageVector = WifiIcon,
                    contentDescription = null,
                    tint = Color.White
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TotalBalanceCardPreview() {
    PennieTheme {
        TotalBalanceCard(
            totalBalance = "£2,500.00",
            income = "£5,000.00",
            expenses = "£2,500.00",
            onViewAllClick = { }
        )
    }
}