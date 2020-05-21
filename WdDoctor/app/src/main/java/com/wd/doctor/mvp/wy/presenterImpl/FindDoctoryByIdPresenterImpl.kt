package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.FindDoctorByIdBean
import com.wd.doctor.mvp.wy.presenter.FindDoctorByIdPresenter
import com.wd.doctor.mvp.wy.view.FindDoctorByIdView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 15:21
 * @classname :FindDoctoryByIdPresenterImpl
 */
class FindDoctorByIdPresenterImpl (var findDoctorByIdView: FindDoctorByIdView?): FindDoctorByIdPresenter {
    override fun onFindDoctorByIdSuccess() {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorById = createService.findDoctorById()
        findDoctorById.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<FindDoctorByIdBean>() {
                override fun onComplete() {
                }
                override fun onNext(t: FindDoctorByIdBean) {
                    t.let {
                        findDoctorByIdView?.onFindDoctorByIdSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    findDoctorByIdView?.onFindDoctorByIdError(e?.message.toString())
                }
            })
    }

    override fun onFindDoctorByIdError(msg: String) {
        findDoctorByIdView?.onFindDoctorByIdError(msg)
    }

    override fun destroyView() {
        if(findDoctorByIdView!=null){
            findDoctorByIdView=null
        }
    }
}