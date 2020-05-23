package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.doctor.R
import com.wd.doctor.adapter.wy.RecyclerViewSearch
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.wy.SearchSickCircleBean
import com.wd.doctor.mvp.wy.presenterImpl.SearchSickCirclePresenterImpl
import com.wd.doctor.mvp.wy.view.SearchSickCircleView
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity(), SearchSickCircleView {
    val presenter by lazy { SearchSickCirclePresenterImpl(this) }
    val adapter by lazy { RecyclerViewSearch() }
    override fun initLayoutId(): Int {
        return R.layout.activity_search
    }
    override fun initListener() {
        super.initListener()
        imgBackSearchCircle.setOnClickListener {
            finish()
        }
        recyclerSearchCircle.layoutManager= LinearLayoutManager(this)
        btn_ss.setOnClickListener {
            val etSsContent = etSsContent.text.toString()
            presenter.onSearchSickCircleDatas(etSsContent!!)
        }
    }
    override fun initData() {
        super.initData()
    }
    override fun onSearchSickCircleSucess(reponse: SearchSickCircleBean) {
        recyclerSearchCircle.adapter=adapter
        adapter.updateList(reponse?.result!!)
        if(reponse.result.size==0){
            wuxx.visibility= View.INVISIBLE
            wuxxcon.setText("没有找到“${etSsContent}”的相关病友圈")
        }
    }

    override fun onSearchSickCircleError(message: String?) {
        myToast("获取数据异常"+message)
    }
}
