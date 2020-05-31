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
            val etSContent = etSsContent.text.toString()
            presenter.onSearchSickCircleDatas(etSContent)
            //添加
            myFlowView.addView(etSContent)
        }
        //流式布局
        myFlowView.setAddText {
            presenter.onSearchSickCircleDatas(it)
        }
    }
    override fun initData() {
        super.initData()
    }
    override fun onSearchSickCircleSuccess(response: SearchSickCircleBean) {
        val result = response.result
        if(result.size==0){
            recyclerSearchCircle.visibility=View.GONE
            linearNo.visibility= View.VISIBLE
            tvNoSearch.setText("没有找到"+etSsContent.text.toString()+"的相关病友圈")
        }else{
            recyclerSearchCircle.visibility=View.VISIBLE
            linearNo.visibility=View.GONE
            recyclerSearchCircle.adapter=adapter
            adapter.updateList(response?.result!!)
        }
        //查询完   清空
        etSsContent.setText("")
    }

    override fun onSearchSickCircleError(message: String?) {
        myToast("获取数据异常"+message)
    }
    override fun onDestroy() {
        super.onDestroy()
        presenter.destroyView()
    }
}
