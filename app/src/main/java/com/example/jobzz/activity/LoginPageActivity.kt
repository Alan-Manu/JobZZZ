package com.example.jobzz.activity

import android.content.SharedPreferences
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jobzz.R

class LoginPageActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextPass: EditText
    private lateinit var buttonSave: Button
    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        private const val SHARED_PREF_NAME = "mypref"
        private const val KEY_NAME = "name"
        private const val KEY_PASS = "pass"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        editTextName = findViewById(R.id.editext_name)
        editTextPass = findViewById(R.id.editext_pass)
        buttonSave = findViewById(R.id.button_save)

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)

        val name = sharedPreferences.getString(KEY_NAME, null)

        if (name != null) {
            val intent = Intent(this@LoginPageActivity, MainActivity::class.java)
            startActivity(intent)
        }

        buttonSave.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString(KEY_NAME, editTextName.text.toString())
            editor.putString(KEY_PASS, editTextPass.text.toString())
            editor.apply()

            val intent = Intent(this@LoginPageActivity, MainActivity::class.java)
            startActivity(intent)

            Toast.makeText(this@LoginPageActivity, "login success", Toast.LENGTH_SHORT).show()

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}

