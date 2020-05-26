package com.wd.doctor.mvp.wy.presenter

import com.wd.doctor.bean.wy.FindSickCircleListBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 19:12
 * @classname :FindSickCircleListPresenter
 */
interface FindSickCircleListPresenter {
    //成功
    fun onFindSickCircleListSuccess(departmentId:Int,page:Int,count:Int)
    //刷新成功
    fun onFindSickCircleListLoadMoreSuccess(departmentId:Int,page:Int,count:Int)
    //失败
    fun onFindSickCircleListError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}