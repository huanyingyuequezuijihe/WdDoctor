package com.wd.doctor.mvp.cs.csmodel

import com.wd.doctor.bean.cs.LoginBean
import com.wd.doctor.bean.cs.RegistBean
import com.wd.doctor.mvp.cs.cspresenter.CsLoginPresenter
import com.wd.doctor.mvp.cs.cspresenter.CsRegistPresenter
import com.wd.doctor.mvp.cs.csview.CsLoginView
import com.wd.doctor.mvp.cs.csview.CsRegistView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CsLoginRegistModel (var findLogin: CsRegistView?): CsRegistPresenter {
    override fun onRegistSuccess(email:String,
                                code:String,
                                pwd1:String,
                                pwd2:String,
                                name:String,
                                inauguralHospital:String,
                                departmentId:Int,
                                jobTitleId:Int,
                                personalProfile:String,
                                goodField:String) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorById = createService.getRegister(email,code,pwd1,pwd2,name,
                                                    inauguralHospital,departmentId,
                                                    jobTitleId,personalProfile,goodField)
        findDoctorById.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<RegistBean>() {
                override fun onComplete() {
                }
                override fun onNext(t: RegistBean) {
                    t.let {
                        findLogin?.onRegistSuccess(it)
                    }
                }
                override fun onError(e: Throwable) {
                    findLogin?.onRegistError(e?.message.toString())
                }
            })
    }

    override fun onRegistError(msg: String) {
        findLogin?.onRegistError(msg)
    }

    override fun destroyView() {
        if(findLogin!=null){
            findLogin=null
        }
    }

}
