package com.wd.doctor.mvp.cs.csmodel

import com.wd.doctor.bean.cs.SuggestBean
import com.wd.doctor.bean.cs.ZhiChegBean
import com.wd.doctor.mvp.cs.cspresenter.CsSuggestPresenter
import com.wd.doctor.mvp.cs.csview.CsSuggestView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CsSuggestModel (var findLogin: CsSuggestView?): CsSuggestPresenter {
    override fun onSuggestSuccess(doctorId: Int, sessionId: String) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorById = createService.getSuggest(doctorId,sessionId,1,5)
        findDoctorById?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableObserver<SuggestBean>() {
                override fun onComplete() {
                }
                override fun onNext(t: SuggestBean) {
                    t.let {
                        findLogin?.onSuggestSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    findLogin?.onSuggestError(e?.message.toString())
                }
            })
    }


    override fun onSuggestError(msg: String) {
        findLogin?.onSuggestError(msg)
    }

    override fun destroyView() {
        if(findLogin!=null){
            findLogin=null
        }
    }

}
