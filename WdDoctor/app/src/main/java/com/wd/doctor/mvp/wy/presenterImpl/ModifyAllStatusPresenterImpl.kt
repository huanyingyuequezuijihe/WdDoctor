package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.ModifyAllStatusBean
import com.wd.doctor.mvp.wy.presenter.ModifyAllStatusPresenter
import com.wd.doctor.mvp.wy.view.ModifyAllStatusView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/24 20:49
 * @classname :ModifyAllStatusPresenterImpl
 */
class ModifyAllStatusPresenterImpl(var modifyAllStatusView: ModifyAllStatusView?): ModifyAllStatusPresenter{
    override fun onModifyAllStatusData() {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val modifyAllStatusData = createService.getModifyAllStatusData()
        modifyAllStatusData?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object :DisposableObserver<ModifyAllStatusBean>(){
                override fun onComplete() {
                }
                override fun onNext(t: ModifyAllStatusBean) {
                    t?.let {
                        modifyAllStatusView?.onModifyAllStatusViewSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    modifyAllStatusView?.onModifyAllStatusViewError(e.message.toString())
                }
            })
    }

    override fun destroyView() {
        if(modifyAllStatusView==null){
            modifyAllStatusView=null
        }
    }
}