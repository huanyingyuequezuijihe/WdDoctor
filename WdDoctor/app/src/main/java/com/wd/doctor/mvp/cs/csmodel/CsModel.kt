package com.wd.doctor.mvp.cs.csmodel

import com.wd.doctor.bean.cs.LoginBean
import com.wd.doctor.bean.wy.FindDoctorByIdBean
import com.wd.doctor.mvp.cs.cspresenter.CsPresenter
import com.wd.doctor.mvp.cs.csview.CsView
import com.wd.doctor.mvp.wy.presenter.FindDoctorByIdPresenter
import com.wd.doctor.mvp.wy.view.FindDoctorByIdView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CsModel (var findLogin: CsView?): CsPresenter {
    override fun onLoginSuccess(email: String, pwd: String) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorById = createService.getLogin(email,pwd)
        findDoctorById.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<LoginBean>() {
                override fun onComplete() {
                }
                override fun onNext(t: LoginBean) {
                    t.let {
                        findLogin?.onLoginSuccess(it)
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
