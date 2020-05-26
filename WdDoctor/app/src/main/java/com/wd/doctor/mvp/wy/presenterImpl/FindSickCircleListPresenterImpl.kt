package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.FindSickCircleListBean
import com.wd.doctor.mvp.wy.presenter.FindSickCircleListPresenter
import com.wd.doctor.mvp.wy.view.FindSickCircleListView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 19:14
 * @classname :FindSickCircleListPresenterImpl
 */
class FindSickCircleListPresenterImpl (var findSickCircleListView: FindSickCircleListView?): FindSickCircleListPresenter{
    override fun onFindSickCircleListSuccess(departmentId: Int, page: Int, count: Int) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findSickCircleList = createService.findSickCircleList(departmentId, page, count)
        findSickCircleList?.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<FindSickCircleListBean>(){
                override fun onComplete() {
                }
                override fun onNext(t: FindSickCircleListBean) {
                    t.let {
                        findSickCircleListView?.onFindSickCircleListViewSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    findSickCircleListView?.onFindSickCircleListViewError(e.message.toString())
                }
            })
    }

    override fun onFindSickCircleListLoadMoreSuccess(departmentId: Int, page: Int, count: Int) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findSickCircleList = createService.findSickCircleList(departmentId, page, count)
        findSickCircleList?.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<FindSickCircleListBean>(){
                override fun onComplete() {
                }
                override fun onNext(t: FindSickCircleListBean) {
                    t.let {
                        findSickCircleListView?.onFindSickCircleListViewSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    findSickCircleListView?.onFindSickCircleListViewError(e.message.toString())
                }
            })
    }

    override fun onFindSickCircleListError(msg: String) {
        findSickCircleListView?.onFindSickCircleListViewError(msg)
    }
    override fun destroyView() {
        if(findSickCircleListView!=null) {
            findSickCircleListView=null
        }
    }
}