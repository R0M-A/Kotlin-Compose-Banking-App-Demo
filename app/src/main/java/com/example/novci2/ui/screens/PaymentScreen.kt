package com.example.novci2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.novci2.ui.components.BalanceCard
import com.example.novci2.ui.components.Header
import com.example.novci2.ui.components.Ponisti
import com.example.novci2.ui.components.Potvrdi

@Composable
fun PaymentScreen(balanceCents: Int, onConfirm: (Long) -> Unit, onBack: () -> Unit) {

    var enteredCents by rememberSaveable { mutableLongStateOf(0L) }

    Box(Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Header()
            BalanceCard(Modifier.padding(horizontal = 4.dp), balanceCents)
            FixedTwoDecimalInput(Modifier.padding(horizontal = 20.dp, vertical = 30.dp)) { enteredCents = it }
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 100.dp, end = 4.dp)
                .align(Alignment.BottomEnd),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.End
        ) {
            Potvrdi { onConfirm(enteredCents) }
            Ponisti { onBack() }
        }
    }
}

@Composable
fun FixedTwoDecimalInput(modifier: Modifier = Modifier, onEnteredCentsChange: (Long) -> Unit) {
    Column(modifier, verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        var enteredText by rememberSaveable { mutableStateOf("") }

        Text("Enter Amount", Modifier.padding(bottom = 8.dp), Color.Gray, fontSize = 16.sp,)

        OutlinedTextField(
            value = enteredText,
            onValueChange = { input ->
                val normInput = input.replace(',', '.').let { if (it == ".") "0." else it }
                val isValid = normInput.matches(Regex("^(0|[1-9]\\d*)?(\\.\\d{0,2})?\$"))
                if (isValid) {
                    enteredText = normInput
                    onEnteredCentsChange(textToCents(normInput))
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(fontSize = 48.sp, textAlign = TextAlign.Center),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("0.00", Modifier.alpha(.5f), textAlign = TextAlign.Center) },
            suffix = { Text("€", color = Color.White, fontSize = 48.sp) })
    }
}

// TODO: Use BigNumbers, maybe unsigned to avoid any kind of overflow
// TODO: Make Money class that has normalized cents and euros getters. Also easier to use it as a type than plain Int. Maybe make it do the conversion too.
private fun textToCents(text: String): Long {
    if (text.isEmpty() || text == ".") return 0L
    val parts = text.split(".")

    val euros = parts[0].ifEmpty { "0" }.toLong()
    val cents = parts
        .getOrElse(1, {"0"})
        .padEnd(2, '0')
        .take(2)
        .toLong()

    return euros * 100L + cents
}