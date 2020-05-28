package com.wd.doctor.net

import com.wd.doctor.bean.SendEmailCodeBean
import com.wd.doctor.bean.cs.*
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
    ):Observable<RegistBean>
    //查询医生的问诊记录列表
    @GET(ApiUrl.getwen)
    @FormUrlEncoded
    open fun getwen(@Field("doctorId")doctorId:Int,@Field("sessionId")sessionId:String):Observable<WenBean>
    //登录
    @POST(ApiUrl.user_login)
    @FormUrlEncoded
    open fun  getLogin(@Field("email") email: String, @Field("pwd") pwd:String):Observable<LoginBean>
    //科室查询
    @GET()
    open fun getkeshi(@Url() url:String?):Observable<KeShiBean>?
    //职称查询
    @GET(ApiUrl.ruzhu_zhicheng)
    open fun getzhicheng():Observable<ZhiChegBean>?
    //校验验证码
    @POST(ApiUrl.yan_email)
    @FormUrlEncoded
    open fun yanEmail(@Field("email") email: String,@Field("code") code:String):Observable<YanEmailBean>
    //重置密码
    @PUT(ApiUrl.chong_zhi)
    @FormUrlEncoded
    open fun chongZhi(@Field("email") email: String,@Field("pwd1") pwd1: String,@Field("pwd2") pwd2: String):Observable<ChongZhiBean>
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
    //查询医生历史问诊记录列表
    @GET(ApiUrl.findHistoryInquiryRecord)
    open fun getHistoryInquiryRecordData(@Query("page") page:Int,@Query("count") count:Int): Observable<FindHistoryInquiryRecordBean>
    //发送消息（文本消息）
    @POST(ApiUrl.pushMessage)
    @FormUrlEncoded
    open fun getPushMessageData(@Field("inquiryId") inquiryId :Int,@Field("content") content:String,@Query("type") type:Int,@Query("userId") userId:Int): Observable<PushMessageBean>
    //查询问诊聊天记录
    @GET(ApiUrl.findInquiryDetailsList)
    open fun getFindInquiryDetailsListData(@Query("page") page:Int,@Query("count") count:Int,@Query("inquiryId") inquiryId:Int): Observable<FindInquiryDetailsListBean>
}