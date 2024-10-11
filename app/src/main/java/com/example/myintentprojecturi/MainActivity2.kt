package com.example.myintentprojecturi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val receivedMessageView: TextView = findViewById<TextView>(R.id.receivedMessage)
        val editText = findViewById<EditText>(R.id.editTextSecond)
        val sendButton: Button = findViewById<Button>(R.id.sendButtonSecond)

        //get URI for the intent
        intent?.data?.let { data: Uri ->
            val message = data.schemeSpecificPart // Extract the message
            receivedMessageView .text = "Received: $message"
        }
        sendButton.setOnClickListener{
            val replyMessage = editText.text.toString()

            val replyIntent = Intent(this, MainActivity::class.java).apply{
                putExtra("reply",replyMessage)
            }
            startActivity(replyIntent)
        }

    }
}