package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivityActivity : AppCompatActivity() {

    private lateinit var recipientNumberEditText: EditText
    private lateinit var messageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recipientNumberEditText = findViewById(R.id.recipient_number_edittext)
        messageEditText = findViewById(R.id.message_edittext)

        val sendButton: Button = findViewById(R.id.send_button)
        sendButton.setOnClickListener {
            val recipientNumber = recipientNumberEditText.text.toString()
            val message = messageEditText.text.toString()

            if (isValidRecipientNumber(recipientNumber) && isMessageImported(message)) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("recipient_number", recipientNumber)
                intent.putExtra("message", message)
                startActivity(intent)
            }
        }
    }

    private fun isValidRecipientNumber(recipientNumber: String): Boolean {
        return recipientNumber.matches(Regex("\\d+"))
    }

    private fun isMessageImported(message: String): Boolean {
        return message.isNotEmpty()
    }
}









