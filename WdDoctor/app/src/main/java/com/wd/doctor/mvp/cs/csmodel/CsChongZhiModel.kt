package com.wd.doctor.mvp.cs.csmodel

import com.wd.doctor.bean.SendEmailCodeBean
import com.wd.doctor.bean.cs.ChongZhiBean
import com.wd.doctor.mvp.cs.cspresenter.CsChongZhiPresenter
import com.wd.doctor.mvp.cs.cspresenter.CsFaYanPresenter
import com.wd.doctor.mvp.cs.csview.CsChongZhiView
import com.wd.doctor.mvp.cs.csview.CsFaYanView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CsChongZhiModel (var findLogin: CsChongZhiView?): CsChongZhiPresenter {
    override fun onChongZhiSuccess(email: String,pwd1:String,pwd2:String) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorById = createService.chongZhi(email,pwd1,pwd2)
        findDoctorById.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<ChongZhiBean>() {
                override fun onComplete() {
                }
                override fun onNext(t: ChongZhiBean) {
                    t.let {
                        findLogin?.onChongZhiSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    findLogin?.onChongZhiError(e?.message.toString())
                }
            })
    }

    override fun onChongZhiError(msg: String) {
        findLogin?.onChongZhiError(msg)
    }

    override fun destroyView() {
        if(findLogin!=null){
            findLogin=null
        }
    }

}
