package com.wd.doctor.mvp.cs.csmodel

import com.wd.doctor.bean.cs.KeShiBean
import com.wd.doctor.bean.cs.LoginBean
import com.wd.doctor.bean.cs.ZhiChegBean
import com.wd.doctor.mvp.cs.cspresenter.CsKeShiPresenter
import com.wd.doctor.mvp.cs.cspresenter.CsLoginPresenter
import com.wd.doctor.mvp.cs.cspresenter.CsZhiChengPresenter
import com.wd.doctor.mvp.cs.csview.CsKeShiView
import com.wd.doctor.mvp.cs.csview.CsLoginView
import com.wd.doctor.mvp.cs.csview.CsZhiChengView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CsZhiChengModel (var findLogin: CsZhiChengView?): CsZhiChengPresenter {
    override fun onZhiChengSuccess() {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorById = createService.getzhicheng()
        findDoctorById?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableObserver<ZhiChegBean>() {
                override fun onComplete() {
                }
                override fun onNext(t: ZhiChegBean) {
                    t.let {
                        findLogin?.onZhiChengSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    findLogin?.onZhiChengError(e?.message.toString())
                }
            })
    }

    override fun onZhiChengError(msg: String) {
        findLogin?.onZhiChengError(msg)
    }

    override fun destroyView() {
        if(findLogin!=null){
            findLogin=null
        }
    }

}
