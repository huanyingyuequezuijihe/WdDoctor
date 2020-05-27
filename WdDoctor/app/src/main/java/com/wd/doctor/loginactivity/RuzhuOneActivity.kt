package com.wd.doctor.loginactivity

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.view.get
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.cs.KeShiBean
import com.wd.doctor.bean.cs.ZhiChegBean
import com.wd.doctor.mvp.cs.csmodel.CsKeShiModel
import com.wd.doctor.mvp.cs.csmodel.CsZhiChengModel
import com.wd.doctor.mvp.cs.csview.CsKeShiView
import com.wd.doctor.mvp.cs.csview.CsZhiChengView
import com.wd.doctor.util.SpCacheUtil
import kotlinx.android.synthetic.main.activity_ruzhuone_activity.*
import org.jetbrains.anko.startActivity

class RuzhuOneActivity : BaseActivity(), CsKeShiView, CsZhiChengView {
    override fun initLayoutId(): Int {
        return R.layout.activity_ruzhuone_activity
    }

    val presenterzhi by lazy { CsZhiChengModel(this) }
    val presenterkeshi by lazy { CsKeShiModel(this) }
    var startAdapter: ArrayAdapter<String>? = null
    var startAdapter2: ArrayAdapter<String>? = null
    var strs = ArrayList<String>()
    var strid = ArrayList<Int>()
    var strs2 = ArrayList<String>()
    var strid2 = ArrayList<Int>()
    var pos: Int = 0

    override fun initData() {
        presenterkeshi.onKeShiSuccess("http://mobile.bwstudent.com/health/share/knowledgeBase/v1/findDepartment")
        presenterzhi.onZhiChengSuccess()
    }
    override fun initListener() {
        ruzhu_back_one.setOnClickListener {
            finish()
        }
        ruzhu_btn_xia.setOnClickListener {
            var ruzhu_name = ruzhu_ed_name.text.toString()
            var ruzhu_yiyuan = ruzhu_ed_yiyuan.text.toString()

            SpCacheUtil.spCacheUtil.saveStringData("name",ruzhu_name)
            SpCacheUtil.spCacheUtil.saveStringData("yiyuan",ruzhu_yiyuan)

            startActivity<RuzhuThreeActivity>()
        }
    }
    override fun onKeShiSuccess(response: KeShiBean?) {
        var result = response?.result

        for ((index, str) in result!!.withIndex()) {
            strs2.add(result.get(index).departmentName)
            strid2.add(result.get(index).id)
        }
        startAdapter2 = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, strs2)
        startAdapter2!!.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner_keshi.adapter = startAdapter2
        spinner_keshi.setSelection(0)
        var jobid = strid2.get(0)
        SpCacheUtil.spCacheUtil.saveIntData("keshiid",jobid)

        println("ssssssssssss"+jobid.toString())


        println("科室" + response)
    }

    override fun onKeShiError(msg: String?) {
        println("科室" + msg)
    }

    override fun onZhiChengSuccess(response: ZhiChegBean?) {
        var result = response?.result

        for ((index, str) in result!!.withIndex()) {
            strs.add(result.get(index).jobTitle)
            strid.add(result.get(index).id)
        }
        startAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, strs)
        startAdapter!!.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner_zhicheng.adapter = startAdapter
        spinner_zhicheng.setSelection(0)
        var jobid = strid.get(0)
        SpCacheUtil.spCacheUtil.saveIntData("zhichengid",jobid)

        println("ssssssssssss"+jobid.toString())


        println("职称" + response)
    }

    override fun onZhiChengError(msg: String) {
        println("职称" + msg)
    }
    fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        spinner_zhicheng.setSelection(position)
        spinner_keshi.setSelection(position)
        pos=parent?.get(position)?.id!!
    }

}