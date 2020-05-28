package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.PublishCommentBean
import com.wd.doctor.bean.wy.PushMessageBean
import com.wd.doctor.mvp.wy.presenter.PushMessagePresenter
import com.wd.doctor.mvp.wy.view.PushMessageView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/28 15:10
 * @classname :PushMessagePresenter
 */
class PushMessagePresenterImpl(var pushMessageView: PushMessageView?): PushMessagePresenter{
    override fun onPushMessageSuccess(inquiryId: Int, content: String, type: Int, userId: Int) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val pushMessageData = createService.getPushMessageData(inquiryId, content, type, userId)
        pushMessageData?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object :DisposableObserver<PushMessageBean>(){
                override fun onComplete() {
                }
                override fun onNext(t: PushMessageBean) {
                    t?.let {
                        pushMessageView?.onPushMessageViewSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    pushMessageView?.onPushMessageViewError(e.message.toString())
                }
            })
    }

    override fun onPushMessageError(msg: String) {
        pushMessageView?.onPushMessageViewError(msg)
    }

    override fun destroyView() {
        if(pushMessageView!=null){
            pushMessageView=null
        }
    }
}