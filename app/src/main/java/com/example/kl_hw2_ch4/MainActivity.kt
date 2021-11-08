package com.example.kl_hw2_ch4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_choice).setOnClickListener{
            val intent = Intent(this, SecActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestcode: Int, resultcode: Int, data: Intent?) {
        super.onActivityResult(requestcode, resultcode, data)
        data?.extras?.let {
            if (requestcode == 1 && resultcode == Activity.RESULT_OK) {
                findViewById<TextView>(R.id.tv_meal).text =
                    "飲料: ${it.getString("drink")}\n\n" +
                            "甜度: ${it.getString("sugar")}\n\n" +
                            "冰塊: ${it.getString("ice")}"
            }
        }
    }
}

