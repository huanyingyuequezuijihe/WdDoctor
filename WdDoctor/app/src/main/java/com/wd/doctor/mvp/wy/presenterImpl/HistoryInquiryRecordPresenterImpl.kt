package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.FindHistoryInquiryRecordBean
import com.wd.doctor.mvp.wy.presenter.HistoryInquiryRecordPresenter
import com.wd.doctor.mvp.wy.view.HistoryInquiryRecordView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/25 15:14
 * @classname :HistoryInquiryRecordPresenterImpl
 */
class HistoryInquiryRecordPresenterImpl(var historyInquiryRecordView: HistoryInquiryRecordView?): HistoryInquiryRecordPresenter{
    override fun onHistoryInquiryRecordData(page: Int, count: Int) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val historyInquiryRecordData = createService.getHistoryInquiryRecordData(page, count)
        historyInquiryRecordData?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object :DisposableObserver<FindHistoryInquiryRecordBean>(){
                override fun onComplete() {
                }
                override fun onNext(t: FindHistoryInquiryRecordBean) {
                    t?.let {
                        historyInquiryRecordView?.onHistoryInquiryRecordSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    historyInquiryRecordView?.onHistoryInquiryRecordError(e.message.toString())
                }
            })
    }

    override fun destroyView() {
        if(historyInquiryRecordView!=null){
            historyInquiryRecordView=null
        }
    }
}