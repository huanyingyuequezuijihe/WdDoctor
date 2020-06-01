package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.FindDoctorWalletBean
import com.wd.doctor.mvp.wy.presenter.FindDoctorWalletPresenter
import com.wd.doctor.mvp.wy.view.FindDoctorWalletView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 21:39
 * @classname :FindDoctorWalletPresenterImpl
 */
class FindDoctorWalletPresenterImpl(var findDoctorWalletView: FindDoctorWalletView?): FindDoctorWalletPresenter{
    override fun onFindDoctorWalletSuccess() {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorWalletData = createService.getFindDoctorWalletData()
        findDoctorWalletData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :DisposableObserver<FindDoctorWalletBean>(){
                override fun onComplete() {
                }

                override fun onNext(t: FindDoctorWalletBean) {
                    t?.let {
                        findDoctorWalletView?.onFindDoctorWalletSuccess(t)
                    }
                }

                override fun onError(e: Throwable) {
                    findDoctorWalletView?.onFindDoctorWalletError(e.message.toString())
                }
            })
    }

    override fun destroyView() {
        if(findDoctorWalletView!=null){
            findDoctorWalletView=null
        }
    }
}