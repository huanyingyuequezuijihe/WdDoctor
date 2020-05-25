package com.wd.doctor.net

import com.wd.doctor.bean.SendEmailCodeBean
import com.wd.doctor.bean.cs.LoginBean
import com.wd.doctor.bean.wy.*
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

    //注册
    @POST(ApiUrl.user_register)
    @FormUrlEncoded
    open fun getRegister(@Field("email") email: String,
    @Field("code") count: String,
    @Field("pwd1") pwd1:String,
    @Field("pwd2") pwd2:String,
    @Field("name") name:String,
    @Field("inauguralHospital") inauguralHospital:String,
    @Field("departmentId") departmentId:String,
    @Field("jobTitleId") jobTitleId:String,
    @Field("personalProfile") personalProfile:String,
    @Field("goodField") goodField:String
    ):Observable<LoginBean>
    //查询科室
   // @GET("mobile.bwstudent.com/health/share/knowledgeBase/v1/findDepartment")
    //@FormUrlEncoded
    //open fun getkeshi() :Observable<>


    //登录
    @POST(ApiUrl.user_login)
    @FormUrlEncoded
    open fun  getLogin(@Field("email") email: String, @Field("pwd") pwd:String):Observable<LoginBean>


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
    //查询病友圈详情
    @GET(ApiUrl.findSickCircleInfo)
    open fun findSickCircleInfo(@Query("sickCircleId") sickCircleId:Int): Observable<FindSickCircleInfoBean>
    //根据关键词查询病友圈
    @GET(ApiUrl.searchSickCircle)
    open fun searchSickCircledata(@Query ("keyWord") keyWord :String ):Observable<SearchSickCircleBean>
    //解答  发表评论
    @POST(ApiUrl.publishComment)
    @FormUrlEncoded
    open fun getPublishCommentData(@Field("sickCircleId") sickCircleId :Int,@Field("content") content :String): Observable<PublishCommentBean>
    //修改消息状态为全部已读
    @PUT(ApiUrl.modifyAllStatus)
    open fun getModifyAllStatusData(): Observable<ModifyAllStatusBean>
}