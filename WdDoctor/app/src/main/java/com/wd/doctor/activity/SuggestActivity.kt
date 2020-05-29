package com.wd.doctor.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.doctor.R
import com.wd.doctor.adapter.cs.RecyclerViewSuggestAdapter
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.cs.SuggestBean
import com.wd.doctor.mvp.cs.csmodel.CsSuggestModel
import com.wd.doctor.mvp.cs.csview.CsSuggestView
import com.wd.doctor.util.SpCacheUtil
import kotlinx.android.synthetic.main.activity_suggest.*

//被采纳的建议页面
class SuggestActivity : BaseActivity(),CsSuggestView {
    val presenter by lazy { CsSuggestModel (this) }
    val adapter by lazy { RecyclerViewSuggestAdapter() }
    override fun initLayoutId(): Int {
        return R.layout.activity_suggest
    }

    override fun initListener() {
        super.initListener()
    }

    override fun initData() {
        super.initData()

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerSuggest.layoutManager= linearLayoutManager


        myTitleSuggest.title?.setText("被采纳的建议")
        var doctorId= SpCacheUtil.spCacheUtil.getIntData("doctorId")
        var sessionId= SpCacheUtil.spCacheUtil.getStringData("sessionId").toString()


        presenter.onSuggestSuccess(doctorId,sessionId)
        myTitleSuggest.back?.setOnClickListener { finish() }
    }

    override fun onSuggestSuccess(response: SuggestBean?) {
        println("ooooo"+response)

        recyclerSuggest.adapter=adapter
        val result = response?.result
        if (result != null) {
            adapter.updateList(result)
        }

    }

    override fun onSuggestError(msg: String) {
        println("ooooo"+msg)
    }
}
