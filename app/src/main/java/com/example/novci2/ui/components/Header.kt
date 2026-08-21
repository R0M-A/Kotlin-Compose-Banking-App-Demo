package com.example.novci2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.novci2.R
import com.example.novci2.data.FakeData

@Composable
fun Header() {
    Row(
        Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .offset(y = (-10).dp)
            .padding(horizontal = 4.dp),
        Arrangement.SpaceBetween,
        Alignment.Bottom
    ) {
        Row(Modifier.padding(horizontal = 2.dp), Arrangement.SpaceBetween, Alignment.CenterVertically) {
            val fontSize = 30.sp
            val density = LocalDensity.current
            val iconSize = with(density) { fontSize.toDp() } // Convert sp to dp dynamically

            Icon(painterResource(R.drawable.outline_finance_24), "Bank logo", Modifier.size(iconSize).padding(end = 2.dp), Color.White)
            Text("BEST Bank", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
        }

        Surface(Modifier.clickable(onClick = {}), RoundedCornerShape(50), Color(0xFF7E57C2)) {
            val userID = 0

            Row(Modifier.padding(12.dp, 6.dp), Arrangement.SpaceBetween, Alignment.CenterVertically) {
                Icon(painterResource(R.drawable.outline_person_edit_24), "Personal info and settings", Modifier.padding(end = 10.dp))
                Text(FakeData.userList[userID].prefixedFirstName, textAlign = TextAlign.Start)
            }
        }
    }
}