package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.FindInquiryDetailsListBean
import com.wd.doctor.mvp.wy.presenter.FindInquiryDetailsListPresenter
import com.wd.doctor.mvp.wy.view.FindInquiryDetailsListView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/28 15:51
 * @classname :FindInquiryDetailsListPresenterImpl
 */
class FindInquiryDetailsListPresenterImpl(var findInquiryDetailsListView: FindInquiryDetailsListView?): FindInquiryDetailsListPresenter{
    override fun onFindInquiryDetailsListSuccess(page: Int, count: Int, inquiryId: Int) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val findInquiryDetailsListData =
            createService.getFindInquiryDetailsListData(page, count, inquiryId)
        findInquiryDetailsListData?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableObserver<FindInquiryDetailsListBean>(){
                override fun onComplete() {
                }
                override fun onNext(t: FindInquiryDetailsListBean) {
                    t?.let {
                        findInquiryDetailsListView?.onFindInquiryDetailsListSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    findInquiryDetailsListView?.onFindInquiryDetailsListError(e.message.toString())
                }
            })
    }
    override fun onFindInquiryDetailsListError(msg: String) {
        findInquiryDetailsListView?.onFindInquiryDetailsListError(msg)
    }
    override fun destroyView() {
        if(findInquiryDetailsListView!=null){
            findInquiryDetailsListView=null
        }
    }
}