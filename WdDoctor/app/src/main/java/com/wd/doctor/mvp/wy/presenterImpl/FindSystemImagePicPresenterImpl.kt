package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.FindSystemImagePicBean
import com.wd.doctor.mvp.wy.presenter.FindSystemImagePicPresenter
import com.wd.doctor.mvp.wy.view.FindSystemImagePicView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 16:05
 * @classname :FindSystemImagePicPresenter
 */
class FindSystemImagePicPresenterImpl(var findSystemImagePicView: FindSystemImagePicView?): FindSystemImagePicPresenter{
    override fun onFindSystemImagePicSuccess() {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findSystemImagePicData = createService.getFindSystemImagePicData()
        findSystemImagePicData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :DisposableObserver<FindSystemImagePicBean>(){
                override fun onComplete() {
                }

                override fun onNext(t: FindSystemImagePicBean) {
                    t?.let {
                        findSystemImagePicView?.onFindSystemImagePicSuccess(t)
                    }
                }

                override fun onError(e: Throwable) {
                    findSystemImagePicView?.onFindSystemImagePicError(e.message.toString())
                }
            })
    }

    override fun destroyView() {
        if(findSystemImagePicView!=null){
            findSystemImagePicView=null
        }
    }
}