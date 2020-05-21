package com.wd.doctor.net

import com.wd.doctor.bean.SendEmailCodeBean
import com.wd.doctor.bean.wy.FindDoctorByIdBean
import com.wd.doctor.bean.wy.FindSickCircleListBean
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*
import java.util.*

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/19 14:48
 * @classname :ApiService
 */
interface ApiService {
    //发送验证码
    @POST(ApiUrl.sendEmailCode)
    @FormUrlEncoded
    open fun sendEmailCode(@Field("email") email:String):Observable<SendEmailCodeBean>
    //根据医生id查询医生信息
    @GET(ApiUrl.findDoctorById)
    open fun findDoctorById(): Observable<FindDoctorByIdBean>
    //病友圈列表展示   根据科室id进行查找
    @GET(ApiUrl.findSickCircleList)
    open fun findSickCircleList(@Query("departmentId") departmentId:Int, @Query("page") page:Int, @Query("count") count:Int):Observable<FindSickCircleListBean>
}