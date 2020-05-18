package com.wd.doctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_q_d.*

class QDActivity : AppCompatActivity() {
    /*var time=60
    val handler : Handler = object : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when(msg.what){
                3 ->{
                    var t =msg.data.get("data")
                }else ->{

            }
            }
            false
        }
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q_d)
        tv_dao.setText("dsadasdas")
        //tv_dao.isEnabled=false


    }

}