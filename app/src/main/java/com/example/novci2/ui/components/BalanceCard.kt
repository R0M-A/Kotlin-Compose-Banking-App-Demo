package com.example.novci2.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.novci2.util.toMoneyString
import java.math.BigInteger

@Composable
fun BalanceCard(modifier: Modifier = Modifier, balanceCents: BigInteger) {
    Surface(modifier
        .fillMaxWidth()
        .height(100.dp), RoundedCornerShape(24.dp), Color(0xFF878093)) {
        Box(Modifier.fillMaxSize()) {
            Text(balanceCents.toMoneyString(), Modifier.align(Alignment.Center), Color.White, fontSize = 34.sp, fontWeight = FontWeight.Bold)
        }
    }
}
