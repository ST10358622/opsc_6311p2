package com.example.open_source_coding_part_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val btnSignUp=findViewById<Button>(R.id.btnLogin)
        btnSignUp?.setOnClickListener{
            val intent= Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        val btnLogIn=findViewById<Button>(R.id.btnNEXT)
        btnLogIn?.setOnClickListener{
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}