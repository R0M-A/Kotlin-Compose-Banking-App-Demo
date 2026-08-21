package com.example.novci2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.novci2.model.TransactionRecord
import com.example.novci2.ui.components.BalanceCard
import com.example.novci2.ui.components.Header
import com.example.novci2.ui.components.Kartice
import com.example.novci2.ui.components.Placanje
import com.example.novci2.ui.components.PrimanjeNovaca
import com.example.novci2.ui.components.TransactionList

@Composable
fun HomeScreen(balance: Int, transactions: List<TransactionRecord>, onNavigateToPayment: () -> Unit) {

    Box(Modifier
        .fillMaxSize()
        .background(Color.Black) // Brush.verticalGradient(listOf(Color.Black, Color(0xFF1A1722)))
    ) {

        Column(Modifier.fillMaxSize()) {
            Header()
            BalanceCard(Modifier.padding(horizontal = 4.dp), balance)
            TransactionList(transactions, Modifier.padding(horizontal = 20.dp))
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 100.dp, end = 4.dp)
                .align(Alignment.BottomEnd),
            Arrangement.spacedBy(12.dp),
            Alignment.End
        ) {
            Placanje { onNavigateToPayment() }
            PrimanjeNovaca { }
            Kartice { }
        }
    }
}