package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_login.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //로그인 버튼 클릭
        //아이디랑 비밀번호가 없을 경우 로그인 불가
        button_login.setOnClickListener {
            if ((login_id.length() == 0) or (login_password.length() == 0)) {
                Toast.makeText(
                    this, "아이디와 비밀번호를 입력하세요"
                    , Toast.LENGTH_SHORT
                ).show()
            } else {

                var tmp: String = ""
                Log.i("testLog", "loginclick id:${login_id.text} pw:${login_password.text}")
                Thread() {
                    tmp = UpdateMainLog1("${login_id.text}", "${login_password.text}")

                    var tmps: List<String> = tmp.split("@")
                    runOnUiThread {
                        Log.i("testLog", "loginclick : ${tmp}")
                        if ("${tmp}".equals("로그인 결과 : 0")) { //"로그인 결과 : 0" -> backend에서의 응답
                            Log.i("testLog", "로그인실패")
                            Toast.makeText(this, "로그인 실패.", Toast.LENGTH_SHORT).show()
                            
                        } else if ("${tmp}".equals("로그인 결과 : 1")) {
                            Log.i("testLog", "로그인성공")
                            Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, catagory_activity::class.java)
                            startActivity(intent)
                        }
                    }
                }.start()
            }
        }
        
        //회원가입 버튼 클릭
        button_register.setOnClickListener{
            val intent = Intent(this,join_acticity ::class.java)
            startActivity(intent)
        }

    }


    fun UpdateMainLog1(member_id:String,member_password:String):String{
        val url = URL("http://192.168.0.100:8383/androidLogin?member_id=${member_id}&member_password=${member_password}")
        val conn = url.openConnection() as HttpURLConnection // casting
        Log.i("testLogin", "conn.responseCode : ${conn.responseCode}")
        if(conn.responseCode == 200){
            val txt = url.readText()
            /*val arr = JSONArray(txt)
            var item = arr*/
            return "${txt}"
        } else return "null"
    }

    var lastTimeBackPressed : Long = 0
    override fun onBackPressed() {
        if(System.currentTimeMillis() - lastTimeBackPressed >= 1500){
            lastTimeBackPressed = System.currentTimeMillis()
            Toast.makeText(this,"'뒤로' 버튼을 한번 더 누르시면 종료됩니다.",Toast.LENGTH_LONG).show() }
        else {
            ActivityCompat.finishAffinity(this)
            System.runFinalization()
            System.exit(0)
        }
    }
}



