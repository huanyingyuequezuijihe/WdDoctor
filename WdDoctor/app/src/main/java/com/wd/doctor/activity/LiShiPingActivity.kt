package com.wd.doctor.activity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.cs.LiShiPingBean
import com.wd.doctor.mvp.cs.csmodel.CsPingModel
import com.wd.doctor.mvp.cs.csview.CsPingView
import com.wd.doctor.util.SpCacheUtil

/**
 * @author: asus
 * @date: 20/6/1
 */
class LiShiPingActivity: BaseActivity(),CsPingView {
    val presenter by lazy { CsPingModel(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_lishiping
    }

    override fun initData() {
        var doctorId= SpCacheUtil.spCacheUtil.getIntData("doctorId")
        var sessionId=SpCacheUtil.spCacheUtil.getStringData("sessionId").toString()
        presenter.onPingSuccess(doctorId,sessionId,1)
    }

    override fun onPingSuccess(response: LiShiPingBean?) {
            println("qqqqqq"+response)
    }

    override fun onPingError(msg: String?) {

    }
}