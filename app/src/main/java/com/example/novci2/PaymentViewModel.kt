package com.example.novci2

import androidx.lifecycle.ViewModel
import com.example.novci2.data.FakeData

class PaymentViewModel() : ViewModel() {
    val balanceCents = FakeData.userList[userID].balanceCents
}