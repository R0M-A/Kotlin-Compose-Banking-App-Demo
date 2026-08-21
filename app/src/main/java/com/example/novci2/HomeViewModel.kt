package com.example.novci2

import androidx.lifecycle.ViewModel
import com.example.novci2.data.FakeData

val userID = 0

class HomeViewModel : ViewModel() {
    val transactions = FakeData.transactionHistory
    val balanceCents = FakeData.userList[userID].balanceCents
}