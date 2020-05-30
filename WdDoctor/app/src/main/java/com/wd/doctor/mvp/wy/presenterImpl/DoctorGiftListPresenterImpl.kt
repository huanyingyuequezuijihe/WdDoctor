package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.FindDoctorGiftListBean
import com.wd.doctor.mvp.wy.presenter.DoctorGiftListPresenter
import com.wd.doctor.mvp.wy.view.DoctorGiftListView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/30 11:35
 * @classname :DoctorGiftListPresenterImpl
 */
class DoctorGiftListPresenterImpl(var doctorGiftListView: DoctorGiftListView?): DoctorGiftListPresenter{
    override fun onFindDoctorByIdSuccess(page: Int, count: Int) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findDoctorGiftListData = createService.getFindDoctorGiftListData(page, count)
        findDoctorGiftListData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :DisposableObserver<FindDoctorGiftListBean>(){
                override fun onComplete() {
                }
                override fun onNext(t: FindDoctorGiftListBean) {
                    t?.let {
                        doctorGiftListView?.onFindDoctorByIdSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    doctorGiftListView?.onFindDoctorByIdError(e.message.toString())
                }
            })
    }
    override fun onFindDoctorByIdError(msg: String) {
        doctorGiftListView?.onFindDoctorByIdError(msg)
    }
    override fun destroyView() {
        if(doctorGiftListView!=null){
            doctorGiftListView=null
        }
    }
}