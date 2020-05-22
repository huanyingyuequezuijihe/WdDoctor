package com.wd.doctor.fragment

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    var count=5
    val presenter by lazy { FindSickCircleListPresenterImpl(this) }
    //适配器
    val recyclerViewAskWithin by lazy {
        RecyclerViewAskWithin()
    }
    override fun initView(): View? {
        val view = View.inflate(context, R.layout.fragment_askwithin, null)
        return view
    }

    override fun initListener() {
        super.initListener()
        //初始化刷新控件
        //刷新的颜色
        swiRefreshLayout.setColorSchemeColors(Color.RED,Color.GREEN,Color.BLUE)
        //刷新的监听
        swiRefreshLayout.setOnRefreshListener {
            //刷新
            initData()
        }
        //监听列表的滑动
        recyclerAskWithin.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    //加载更多、显示
                    presenter.onFindSickCircleListSuccess(departmentId,1,count+10)
                }
            }
        })
        //
        recyclerAskWithin.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                //空闲状态 判断最后可见条目 是否为最后一条
                if (newState==RecyclerView.SCROLL_STATE_IDLE){
                    //获取recyclerView的布局管理器的是什么布局
                    val layoutManager=  recyclerView.layoutManager
                    //如果recyclerView的布局管理器的设置的不是 线性 直接返回 不做处理
                    if (!(layoutManager is LinearLayoutManager)) return
                    //如果recyclerView的布局管理器的设置的是线性  展示
                    if (layoutManager is LinearLayoutManager){
                        //获取线性属性
                        val manager: LinearLayoutManager =layoutManager
                        //找到最后一条
                        var lastPosition=   manager.findLastVisibleItemPosition()
                        if (lastPosition==recyclerViewAskWithin.itemCount-1){
                            //调用加载条目
                            presenter.onFindSickCircleListSuccess(departmentId,1,count+5)
                        }
                    }
                }
            }
        })
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
        presenter.onFindSickCircleListSuccess(departmentId,1,count)
    }
    override fun onFindSickCircleListViewSuccess(response: FindSickCircleListBean) {
        //隐藏刷新控件
        Handler().postDelayed(object :Runnable{
            override fun run() {
                swiRefreshLayout.isRefreshing=false
            }
        },2000)
        //成功
        val result = response.result
        /*//适配器
        val recyclerViewAskWithin = context?.let { RecyclerViewAskWithin(result, it) }*/
        recyclerAskWithin.adapter=recyclerViewAskWithin
        recyclerViewAskWithin.updateList(result)
    }

    override fun onFindSickCircleListLoadMoreSuccess(response: FindSickCircleListBean) {
        //成功
        val result = response.result
        recyclerViewAskWithin.loadMore(result)
    }

    override fun onFindSickCircleListViewError(msg: String) {
        //隐藏刷新控件
        Handler().postDelayed(object :Runnable{
            override fun run() {
                swiRefreshLayout.isRefreshing=false
            }
        },2000)
    }
}