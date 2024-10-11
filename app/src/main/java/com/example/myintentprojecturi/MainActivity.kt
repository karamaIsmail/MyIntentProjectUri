package com.example.myintentprojecturi

import android.R.attr.data
import android.R.attr.value
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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextMain)
        val sendButton : Button = findViewById<Button>(R.id.main_send_button)

        sendButton.setOnClickListener{
            val message = editText.text.toString()
            //create an intent with URI
        val messageUri = Uri.parse("massage:$message")
        val intent = Intent(this,MainActivity2::class.java).apply{
            data  = messageUri
        }
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        intent?.let {
            if (it.hasExtra("reply")){
                val reply = it.getStringExtra("reply")
                val repliedMessageView:TextView = findViewById<TextView>(R.id.repliedMessage)
                repliedMessageView.setText("Reply: $reply")
            }
        }
    }
}