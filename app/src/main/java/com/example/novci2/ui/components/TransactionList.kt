package com.example.novci2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.novci2.model.TransactionRecord

@Composable
fun TransactionList(transactions: List<TransactionRecord>, modifier: Modifier = Modifier) {
    LazyColumn(modifier
        .fillMaxSize()
        .drawWithContent {  //Research CompositingStrategy.Offscreen
            drawContent()
            val gradient = Brush.verticalGradient(
                0f to Color.Transparent,
                0.1f to Color.Black, // TODO: Change to themed bg color
                0.9f to Color.Black, // TODO: Change to themed bg color
                1f to Color.Transparent
            )
            drawRect(gradient, blendMode = BlendMode.DstIn) // Ignores transparent (top and bottom)
        },
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        items(transactions) { transaction -> TransactionCard(transaction) }
    }
}