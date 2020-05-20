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
        val encryptByPublicKey1 = RsaCoder.encryptByPublicKey("神农")
        println("==========="+encryptByPublicKey1)
        val encryptByPublicKey2 = RsaCoder.encryptByPublicKey("男")
        println("==========="+encryptByPublicKey2)
        val encryptByPublicKey3 = RsaCoder.encryptByPublicKey("神")
        println("==========="+encryptByPublicKey3)
        val encryptByPublicKey4 = RsaCoder.encryptByPublicKey("1314520")
        println("==========="+encryptByPublicKey4)
        val encryptByPublicKey5 = RsaCoder.encryptByPublicKey("火云洞")
        println("==========="+encryptByPublicKey5)
        val encryptByPublicKey6 = RsaCoder.encryptByPublicKey("1314520")
        println("==========="+encryptByPublicKey6)
        val encryptByPublicKey7 = RsaCoder.encryptByPublicKey("天庭")
        println("==========="+encryptByPublicKey7)
    }
}
