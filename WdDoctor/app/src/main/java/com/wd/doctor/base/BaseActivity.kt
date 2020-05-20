package com.wd.doctor.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/18 18:24
 * @classname :BaseActivity
 */
abstract class BaseActivity :AppCompatActivity(),AnkoLogger{
    private var isshowtitle = true
    var lastClick: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayoutId())
        initListener()
        initData()
    }
    //获取布局ID
    abstract fun initLayoutId():Int
    protected open fun initListener(){}
    protected open fun initData(){}
    //吐司
    protected open fun myToast(msg:String){
        runOnUiThread { toast(msg) }
    }
    //跳转   界面
    inline fun <reified T:BaseActivity> startActivityTo(){
        startActivity<T>()
    }
    //跳转   finish当前界面
    inline fun <reified T:BaseActivity> startActivityAndFinish(){
        startActivity<T>()
        finish()
    }
    /**是否设置标题栏 */
    fun setTitle(ishow: Boolean) {
        isshowtitle = ishow
    }
    //防止快速点击
    private fun fastClick(): Boolean {
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false
        }
        lastClick = System.currentTimeMillis()
        return true
    }
}