package com.wd.doctor.mvp.wy.presenterImpl

import com.wd.doctor.bean.wy.PublishCommentBean
import com.wd.doctor.mvp.wy.presenter.PublishCommentPresenter
import com.wd.doctor.mvp.wy.view.PublishCommentView
import com.wd.doctor.net.ApiService
import com.wd.doctor.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/24 11:30
 * @classname :PublishCommentPresenteriMPL
 */
class PublishCommentPresenterImpl(var publishCommentView: PublishCommentView?):PublishCommentPresenter {
    override fun onPublishCommentData(sickCircleId: Int, content: String) {
        val createService = NetManager.netManager.createService(ApiService::class.java)
        val publishCommentData = createService.getPublishCommentData(sickCircleId, content)
        publishCommentData?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object :DisposableObserver<PublishCommentBean>(){
                override fun onComplete() {
                }
                override fun onNext(t: PublishCommentBean) {
                    t?.let {
                        publishCommentView?.onPublishCommentSuccess(t)
                    }
                }
                override fun onError(e: Throwable) {
                    publishCommentView?.onPublishCommentError(e?.message.toString())
                }
            })
    }

    override fun destroyView() {
        if(publishCommentView!=null){
            publishCommentView=null
        }
    }
}