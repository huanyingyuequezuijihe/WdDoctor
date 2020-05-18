package com.wd.doctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.util.RsaCoder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val encryptByPublicKey = RsaCoder.encryptByPublicKey("yang.1998.")
        println("==========="+encryptByPublicKey)
    }
}
