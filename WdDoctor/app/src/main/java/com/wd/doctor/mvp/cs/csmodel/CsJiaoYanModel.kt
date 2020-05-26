package com.wd.doctor.mvp.cs.csmodel

import com.wd.doctor.bean.cs.YanEmailBean
import com.wd.doctor.mvp.cs.cspresenter.CsJiaoYanPresenter
import com.wd.doctor.mvp.cs.csview.CsJiaoYanView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CsJiaoYanModel (var findLogin: CsJiaoYanView?): CsJiaoYanPresenter {
    override fun onLoginSuccess(email: String, code: String) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorById = createService.yanEmail(email,code)
        findDoctorById.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<YanEmailBean>() {
                override fun onComplete() {
                }
                override fun onNext(t: YanEmailBean) {
                    t.let {
                        findLogin?.onLoginSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    findLogin?.onLoginError(e?.message.toString())
                }
            })
    }

    override fun onLoginError(msg: String) {
        findLogin?.onLoginError(msg)
    }

    override fun destroyView() {
        if(findLogin!=null){
            findLogin=null
        }
    }

}
