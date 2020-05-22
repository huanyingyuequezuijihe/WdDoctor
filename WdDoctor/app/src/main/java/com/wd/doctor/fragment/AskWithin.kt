package com.wd.doctor.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.doctor.R
import com.wd.doctor.adapter.wy.RecyclerViewAskWithin
import com.wd.doctor.base.BaseFragment
import com.wd.doctor.bean.wy.FindSickCircleListBean
import com.wd.doctor.mvp.wy.presenterImpl.FindSickCircleListPresenterImpl
import com.wd.doctor.mvp.wy.view.FindSickCircleListView
import kotlinx.android.synthetic.main.activity_ask_problem.*
import kotlinx.android.synthetic.main.activity_me.*
import kotlinx.android.synthetic.main.fragment_askwithin.*

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 8:10
 * @classname :AskWithin
 * 内科
 */
class AskWithin(val departmentId:Int) :BaseFragment(), FindSickCircleListView{
    val presenter by lazy { FindSickCircleListPresenterImpl(this) }
    override fun initView(): View? {
        val view = View.inflate(context, R.layout.fragment_askwithin, null)
        return view
    }

    override fun initListener() {
        super.initListener()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayoutManager = LinearLayoutManager(this.context)
        recyclerAskWithin.layoutManager=linearLayoutManager
    }
    override fun initData() {
        super.initData()
        /*val linearLayoutManager = LinearLayoutManager(context!!)
        recyclerAsk.layoutManager=linearLayoutManager*/
        presenter.onFindSickCircleListSuccess(departmentId,1,10)
    }
    override fun onFindSickCircleListViewSuccess(response: FindSickCircleListBean) {
        //成功
        val result = response.result
        //适配器
        val recyclerViewAskWithin = context?.let { RecyclerViewAskWithin(result, it) }
        recyclerAskWithin.adapter=recyclerViewAskWithin
    }

    override fun onFindSickCircleListViewError(msg: String) {
    }
}