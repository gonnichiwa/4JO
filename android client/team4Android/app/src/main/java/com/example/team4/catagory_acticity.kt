package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_catagory.*
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_join.button
import kotlinx.android.synthetic.main.activity_login.*

class catagory_acticity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catagory) //로그인 메인 페이지

        //로그아웃
        button6.setOnClickListener {  }

        // 농장번호
        button7.setOnClickListener {
            val intent = Intent(this,management_acticity ::class.java)
            startActivity(intent)
        }
        button8.setOnClickListener {
            val intent = Intent(this,management_acticity ::class.java)
            startActivity(intent)
        }
        button9.setOnClickListener {
            val intent = Intent(this,management_acticity ::class.java)
            startActivity(intent)
        }
        button10.setOnClickListener {
            val intent = Intent(this,management_acticity ::class.java)
            startActivity(intent)
        }



    }
}