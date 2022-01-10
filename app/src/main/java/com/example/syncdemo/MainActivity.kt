package com.example.syncdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.syncdemo.activities.RequestActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.get_started_button)
        MainApplication()
        button.setOnClickListener {
            val intent = Intent(this, RequestActivity::class.java)
            this.startActivity(intent)
        }
    }
}