package com.example.mainactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var recipientNumberTextView: TextView
    private lateinit var messageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        recipientNumberTextView = findViewById(R.id.recipient_number_textview)
        messageTextView = findViewById(R.id.message_textview)

        val recipientNumber = intent.getStringExtra("recipient_number")
        val message = intent.getStringExtra("message")

        recipientNumberTextView.text = recipientNumber
        messageTextView.text = message

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener {
            recipientNumberTextView.text = ""
            messageTextView.text = ""
        }
    }
}


