package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.FindSickCircleInfoBean
import com.wd.doctor.mvp.wy.presenter.SickCircleInfoPresenter
import com.wd.doctor.mvp.wy.view.SickCircleInfoView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.Android

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/22 14:33
 * @classname :SickCircleInfoPresenterImpl
 */
class SickCircleInfoPresenterImpl(var sickCircleInfoView: SickCircleInfoView?) :SickCircleInfoPresenter{
    override fun onSickCircleInfoSuccess(sickCircleId: Int) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findSickCircleInfo = createService.findSickCircleInfo(sickCircleId)
        findSickCircleInfo?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object :DisposableObserver<FindSickCircleInfoBean>(){
                override fun onComplete() {
                }
                override fun onNext(t: FindSickCircleInfoBean) {
                    sickCircleInfoView?.let {
                        sickCircleInfoView?.onSickCircleInfoViewSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    sickCircleInfoView?.onSickCircleInfoViewError(e.message.toString())
                }
            })
    }

    override fun onSickCircleInfoError(msg: String) {
        sickCircleInfoView?.onSickCircleInfoViewError(msg)
    }

    override fun destroyView() {
        if(sickCircleInfoView!=null){
            sickCircleInfoView=null
        }
    }
}