package com.wd.doctor.mvp.cs.csmodel

import com.wd.doctor.bean.SendEmailCodeBean
import com.wd.doctor.mvp.cs.cspresenter.CsFaYanPresenter
import com.wd.doctor.mvp.cs.csview.CsFaYanView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CsFaYanModel (var findLogin: CsFaYanView?): CsFaYanPresenter {
    override fun onLoginSuccess(email: String) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorById = createService.sendEmailCode(email)
        findDoctorById.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<SendEmailCodeBean>() {
                override fun onComplete() {
                }
                override fun onNext(t: SendEmailCodeBean) {
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
