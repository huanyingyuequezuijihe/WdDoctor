package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.FindSickCircleListBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 19:11
 * @classname :FindSickCircleListView
 */
interface FindSickCircleListView {
    //成功
    fun onFindSickCircleListViewSuccess(response: FindSickCircleListBean)
    //刷新成功
    fun onFindSickCircleListLoadMoreSuccess(response: FindSickCircleListBean)
    //失败
    fun onFindSickCircleListViewError(msg:String)
}