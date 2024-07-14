package com.example.textgpt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val eTPrompt = findViewById<EditText>(R.id.eTprompt)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tVResult = findViewById<TextView>(R.id.tVResult)

        btnSubmit.setOnClickListener {
            val prompt = eTPrompt.text.toString()

            val generativeModel = GenerativeModel(
                // For text-only input, use the gemini-pro model
                modelName = "gemini-pro",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = "AIzaSyAPL6ELUcDSldN__388Z8muPLLTo2adelk"
            )
             runBlocking {
                 val response = generativeModel.generateContent(prompt)
                 tVResult.text = response.text
             }
        }
    }
}