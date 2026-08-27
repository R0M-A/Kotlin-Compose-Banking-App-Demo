package com.example.novci2.data

import com.example.novci2.R
import com.example.novci2.model.TransactionRecord
import com.example.novci2.model.User

object FakeData {
    val userList = listOf(
        User(
            "G.", "Jakov", "", "Jaković", balanceCents = 1234567890.toBigInteger(), ID = 0
        ),

        User(
            "Gđa", "Petra", "P.", "Petrović", balanceCents = 10088.toBigInteger(), ID = 1
        )
    )
    val transactionHistory = listOf(
        TransactionRecord(
            "Netflix payment", "8.7.2026.", -50.0, R.drawable.baseline_movie_24
        ),

        TransactionRecord(
            "Spotify subscription", "7.7.2026.", -25.0, R.drawable.baseline_music_note_24
        ),

        TransactionRecord(
            "Yes boss!", "1.7.2026.", 1200.0, R.drawable.baseline_work_24
        ),

        TransactionRecord(
            "Yes boss!", "1.6.2026.", 1200.0, R.drawable.baseline_work_24
        ),

        TransactionRecord(
            "Yes boss!", "1.5.2026.", 1200.0, R.drawable.baseline_work_24
        ),

        TransactionRecord(
            "Testing data", "31.2.2026.", 1000.0, R.drawable.baseline_transform_24
        ),

        TransactionRecord(
            "Testing data", "31.2.2026.", 1000.0, R.drawable.baseline_transform_24
        ),

        TransactionRecord(
            "Testing data", "31.2.2026.", 1000.0, R.drawable.baseline_transform_24
        ),

        TransactionRecord(
            "Testing data", "31.2.2026.", 1000.0, R.drawable.baseline_transform_24
        ),

        TransactionRecord(
            "Testing data", "31.2.2026.", 1000.0, R.drawable.baseline_transform_24
        ),

        TransactionRecord(
            "Testing data", "31.2.2026.", 1000.0, R.drawable.baseline_transform_24
        ),

        TransactionRecord(
            "Testing data", "31.2.2026.", 1000.0, R.drawable.baseline_transform_24
        ),

        TransactionRecord(
            "Testing data", "31.2.2026.", 1000.0, R.drawable.baseline_transform_24
        ),

        TransactionRecord(
            "Testing data", "31.2.2026.", -1000.0, R.drawable.baseline_transform_24
        )
    )
}