package com.wd.doctor.net

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/18 20:48
 * @classname :ApiUrl
 */
object ApiUrl{
    //根路径
    const val BASE_URL="http://mobile.bwstudent.com/"
    //注册
    const val user_register = "health/doctor/v1/applyJoin"
    //登录
    const val user_login = "health/doctor/v1/login"
    //重置密码
    const val chong_zhi="health/doctor/v1/resetUserPwd"
    //校验验证码
    const val yan_email = "health/doctor/v1/checkCode"
    //发送给验证码
    const val sendEmailCode="health/doctor/v1/sendEmailCode"
    //申请入驻
    const val applyJoin="health/doctor/v1/applyJoin"
    //科室查询
    const val ruzhu_keshi="mobile.bwstudent.com/health/share/knowledgeBase/v1/findDepartment"
    //职称查询
    const val ruzhu_zhicheng="health/doctor/v1/findJobTitleList"
    //被采纳建议
    const val beicaina_suggest="health/doctor/verify/v1/findMyAdoptedCommentList"
    //根据医生id查询医生信息
    const val findDoctorById="health/doctor/verify/v1/findDoctorById"
    //病友圈列表展示
    const val findSickCircleList="health/doctor/sickCircle/v1/findSickCircleList"
    //查询病友圈详情
    const val findSickCircleInfo="health/doctor/sickCircle/v1/findSickCircleInfo"
    //根据关键词查询病友圈
    const val searchSickCircle="health/doctor/sickCircle/v1/searchSickCircle"
    //解答  发表评论
    const val publishComment="health/doctor/sickCircle/verify/v1/publishComment"
    //修改消息状态为全部已读
    const val modifyAllStatus="health/doctor/verify/v1/modifyAllStatus"
    //查询医生历史问诊记录列表
    const val findHistoryInquiryRecord="health/doctor/inquiry/verify/v1/findHistoryInquiryRecord"
    //查询医生的问诊记录列表
    const val getwen="health/doctor/inquiry/verify/v1/findInquiryRecordList"

    //查询问诊聊天记录
    const val findInquiryDetailsList="health/doctor/inquiry/verify/v1/findInquiryDetailsList"
    //发送消息（文本消息）
    const val pushMessage="health/doctor/inquiry/verify/v1/pushMessage"
}