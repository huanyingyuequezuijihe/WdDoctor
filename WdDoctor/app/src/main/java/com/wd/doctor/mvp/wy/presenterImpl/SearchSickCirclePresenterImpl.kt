package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.SearchSickCircleBean
import com.wd.doctor.mvp.wy.presenter.SearchSickCirclePresenter
import com.wd.doctor.mvp.wy.view.SearchSickCircleView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/23 16:49
 * @classname :SearchSickCirclePresenterImpl
 */
class SearchSickCirclePresenterImpl(var searchSickCircleView: SearchSickCircleView?): SearchSickCirclePresenter{
    override fun onSearchSickCircleDatas(keyWord: String) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val searchSickCircledata = createService.searchSickCircledata(keyWord)
        searchSickCircledata?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableObserver<SearchSickCircleBean>(){
                override fun onComplete() {
                }

                override fun onNext(value: SearchSickCircleBean) {
                    value?.let {
                        searchSickCircleView?.onSearchSickCircleSucess(it)
                    }
                }
                override fun onError(e: Throwable) {
                    searchSickCircleView?.onSearchSickCircleError(e?.message.toString())
                }
            })
    }

    override fun destroyView() {
        if (searchSickCircleView!=null){
            searchSickCircleView=null
        }
    }
}