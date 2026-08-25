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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.novci2.ui.components.BalanceCard
import com.example.novci2.ui.components.Header
import com.example.novci2.ui.components.Ponisti
import com.example.novci2.ui.components.Potvrdi
import com.example.novci2.util.toCents
import java.math.BigInteger

@Composable
fun PaymentScreen(balanceCents: BigInteger, onConfirm: (BigInteger) -> Unit, onBack: () -> Unit) {

    var enteredCents by rememberSaveable { mutableStateOf(BigInteger.ZERO) }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
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

private val moneyPattern = Regex("^(0|[1-9]\\d*)?(\\.\\d{0,2})?$")
private val leadingZero = Regex("0[1-9]")

@Composable
fun FixedTwoDecimalInput(modifier: Modifier = Modifier, onEnteredCentsChange: (BigInteger) -> Unit) {
    Column(modifier, verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Enter Amount", Modifier.padding(bottom = 8.dp), Color.Gray, fontSize = 16.sp)

        var fieldValue by rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = fieldValue,
            onValueChange = { input ->

                var normInput = input.copy(input.text.replace(",", "."))
                if (normInput.text == ".") normInput = normInput.copy("0.", TextRange(2))
                if (leadingZero.matches(normInput.text)) normInput = input.copy(normInput.text.takeLast(1))

                if (moneyPattern.matches(normInput.text)) {
                    fieldValue = normInput
                    onEnteredCentsChange(normInput.text.toCents())
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            textStyle = TextStyle(fontSize = 48.sp, textAlign = TextAlign.Center),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("0.00", Modifier.alpha(.5f), textAlign = TextAlign.Center) },
            suffix = { Text("€", color = Color.White, fontSize = 48.sp) })
    }
}