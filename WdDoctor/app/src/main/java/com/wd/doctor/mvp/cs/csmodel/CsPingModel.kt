package com.wd.doctor.mvp.cs.csmodel

import com.wd.doctor.bean.cs.KeShiBean
import com.wd.doctor.bean.cs.LiShiPingBean
import com.wd.doctor.bean.cs.LoginBean
import com.wd.doctor.mvp.cs.cspresenter.CsKeShiPresenter
import com.wd.doctor.mvp.cs.cspresenter.CsLoginPresenter
import com.wd.doctor.mvp.cs.cspresenter.CsPingPresenter
import com.wd.doctor.mvp.cs.csview.CsKeShiView
import com.wd.doctor.mvp.cs.csview.CsLoginView
import com.wd.doctor.mvp.cs.csview.CsPingView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CsPingModel (var findLogin: CsPingView?): CsPingPresenter {
    override fun onPingSuccess(doctorId:Int,sessionId:String,recordId:Int) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorById = createService.getping(doctorId,sessionId,recordId)
        findDoctorById?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableObserver<LiShiPingBean>() {
                override fun onComplete() {
                }
                override fun onNext(t: LiShiPingBean) {
                    t?.let {
                        findLogin?.onPingSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    findLogin?.onPingError(e?.message.toString())
                }
            })
    }

    override fun onPingError(msg: String) {
        findLogin?.onPingError(msg)
    }

    override fun destroyView() {
        if(findLogin!=null){
            findLogin=null
        }
    }

}
