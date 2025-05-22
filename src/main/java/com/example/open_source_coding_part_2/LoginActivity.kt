package com.example.open_source_coding_part_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val db = AppDatabase.getDatabase(this)
        val userDao = db.userDao()


        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin?.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
        }

        val btnLOGOUT = findViewById<Button>(R.id.btnNEXT)
        btnLOGOUT?.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val usernameInput = findViewById<EditText>(R.id.editTextText)
        val passwordInput = findViewById<EditText>(R.id.editTextText3)
        val submitButton = findViewById<Button>(R.id.btnLogin)

        submitButton.setOnClickListener {
            val name = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            when {
                name.isEmpty() -> usernameInput.error = "Username cannot be empty"
                password.isEmpty() -> passwordInput.error = "Password cannot be empty"
                else -> {
                    val user = userDao.getUser(name, password)
                    if (user != null) {
                        val intent = Intent(this, CategoryActivity::class.java)
                        intent.putExtra("USERNAME", name)
                        startActivity(intent)
                        Log.d("LoginCheck", "Trying login with: $name / $password")
                        Log.d("LoginCheck", "User exists: ${user != null}")
                        finish()
                    } else {
                        passwordInput.error = "Invalid username or password"
                    }
                }
            }
        }
    }
}