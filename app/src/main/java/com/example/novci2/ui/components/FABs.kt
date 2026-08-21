package com.example.novci2.ui.components

import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.novci2.R

@Composable
fun PrimanjeNovaca(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        { Text("Primi") },
        { Icon(painterResource(R.drawable.outline_universal_currency_24), "Primi novac") },
        { onClick() },
    )
}

@Composable
fun Placanje(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        { Text("Plati") },
        { Icon(painterResource(R.drawable.outline_send_money_24), "Plati novac") },
        { onClick() },
    )
}

@Composable
fun Kartice(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        { Text("Kartice") },
        { Icon(painterResource(R.drawable.outline_credit_card_24), "Kartice") },
        { onClick() },
    )
}

@Composable
fun Potvrdi(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        { Text("Potvrdi") },
        { Icon(painterResource(R.drawable.baseline_check_24), "Potvrdi, prihvati") },
        { onClick() },
    )
}

@Composable
fun Ponisti(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        { Text("Poništi") },
        { Icon(painterResource(R.drawable.outline_cancel_24), "Otkaži, odbij") },
        { onClick() },
    )
}