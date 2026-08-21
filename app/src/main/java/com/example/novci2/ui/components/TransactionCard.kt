package com.example.novci2.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.novci2.model.TransactionRecord

@Composable
fun TransactionCard(
    transaction: TransactionRecord
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF706A7C)
        ),
        shape = RoundedCornerShape(18.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color.Black
            ) {

                Icon(
                    painterResource(transaction.icon),
                    "Simbolički prikaz sadržaja tranzakcije",
                    Modifier.padding(10.dp),
                    Color.White
                )

            }

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    transaction.title,
                    color = Color.White,
                    fontSize = 18.sp
                )

                Text(
                    transaction.date,
                    color = Color.LightGray,
                    fontSize = 13.sp
                )

            }

            val amount = transaction.amount.toInt()
            val isPositive = amount > 0
            val text = (if (isPositive) "+" else "") + "$amount €"
            val color = if (isPositive) Color(0xFF65F58F) else Color(0xFFFF6B6B)

            Text(
                text,
                color = color,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }

    }

}