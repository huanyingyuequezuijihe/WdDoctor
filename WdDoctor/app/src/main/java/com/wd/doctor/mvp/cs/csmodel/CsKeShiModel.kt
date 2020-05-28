package com.wd.doctor.mvp.cs.csmodel

import com.wd.doctor.bean.cs.KeShiBean
import com.wd.doctor.bean.cs.LoginBean
import com.wd.doctor.mvp.cs.cspresenter.CsKeShiPresenter
import com.wd.doctor.mvp.cs.cspresenter.CsLoginPresenter
import com.wd.doctor.mvp.cs.csview.CsKeShiView
import com.wd.doctor.mvp.cs.csview.CsLoginView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CsKeShiModel (var findLogin: CsKeShiView?): CsKeShiPresenter {
    override fun onKeShiSuccess(url:String) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorById = createService.getkeshi(url)
        findDoctorById?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableObserver<KeShiBean>() {
                override fun onComplete() {
                }
                override fun onNext(t: KeShiBean) {
                    t?.let {
                        findLogin?.onKeShiSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    findLogin?.onKeShiError(e?.message.toString())
                }
            })
    }

    override fun onKeShiError(msg: String) {
        findLogin?.onKeShiError(msg)
    }

    override fun destroyView() {
        if(findLogin!=null){
            findLogin=null
        }
    }

}
