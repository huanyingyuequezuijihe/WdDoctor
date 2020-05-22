package com.wd.doctor.net

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/18 20:48
 * @classname :ApiUrl
 */
object ApiUrl{
    const val BASE_URL="http://mobile.bwstudent.com/"
    //发送给验证码
    const val sendEmailCode="health/doctor/v1/sendEmailCode"
    //申请入驻
    const val applyJoin="health/doctor/v1/applyJoin"
    //登录
    const val login="health/doctor/v1/login"
    //根据医生id查询医生信息
    const val findDoctorById="health/doctor/verify/v1/findDoctorById"
    //病友圈列表展示
    const val findSickCircleList="health/doctor/sickCircle/v1/findSickCircleList"
    //查询病友圈详情
    const val findSickCircleInfo="health/doctor/sickCircle/v1/findSickCircleInfo"
}