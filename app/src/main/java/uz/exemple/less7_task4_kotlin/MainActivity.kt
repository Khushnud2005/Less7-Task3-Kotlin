package uz.exemple.less7_task4_kotlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var et_userName: EditText
    lateinit var et_password: EditText
    lateinit var btn_confirm: Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        et_userName = findViewById(R.id.et_userName)
        et_password = findViewById(R.id.et_password)
        btn_confirm = findViewById(R.id.btn_confirm)
        textView = findViewById(R.id.textview)

        et_userName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val userNameInput = et_userName.text.toString().trim { it <= ' ' }
                if (!userNameInput.isEmpty()) {
                    et_password.isEnabled = true
                }else{
                    et_password.isEnabled = false
                    btn_confirm.isEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })

        et_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val passwordInput = s.toString().trim { it <= ' ' }
                if (!passwordInput.isEmpty()) {
                    btn_confirm.isEnabled = true
                }else{
                    btn_confirm.setEnabled(false)
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })

        et_password.setOnKeyListener { v, keyCode, event ->
            val abc = et_password.text.toString().trim { it <= ' ' }
            if (!abc.isEmpty()) {
                textView.text = abc
            } else {
                textView.text = "OnKeyListener"
            }
            false
        }
    }
}