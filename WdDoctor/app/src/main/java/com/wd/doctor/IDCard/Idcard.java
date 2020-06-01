package com.wd.doctor.IDCard;

import com.wd.doctor.util.RsaCoder;
import com.wd.doctor.util.SpCacheUtil;

import org.json.JSONObject;

import java.net.URLEncoder;

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/6/1 19:07
 * @classname :Idcard
 */
public class Idcard {
    public static String idcard(String filePath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    // 本地文件路径
                    //filePath = "[本地文件路径]";
                    byte[] imgData = FileUtil.readFileByBytes(filePath);
                    String imgStr = Base64Util.encode(imgData);
                    String imgParam = URLEncoder.encode(imgStr, "UTF-8");

                    String param = "id_card_side=" + "front" + "&image=" + imgParam;

                    // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
                    String accessToken = "24.b68fc4fc4ed0922d9b998fc2c93568ac.2592000.1593602765.282335-20176263";

                    String data = HttpUtil.post(url, accessToken, param);
                    JSONObject jsonObject=new JSONObject(data);
                    JSONObject words_result = jsonObject.getJSONObject("words_result");

                    JSONObject result1 =jsonObject.getJSONObject("公民身份号码");
                    JSONObject result2 =jsonObject.getJSONObject("姓名");
                    JSONObject result3 =jsonObject.getJSONObject("性别");
                    JSONObject result4 =jsonObject.getJSONObject("民族");
                    JSONObject result5 =jsonObject.getJSONObject("住址");
                    JSONObject result6 =jsonObject.getJSONObject("出生");

                    String card_number =result1.getString("words");
                    String name = result2.getString("words");
                    String sex = result3.getString("words");
                    String notail = result4.getString("words");
                    String address = result5.getString("words");
                    String birthday = result6.getString("words");

                    String encryptcard_number= RsaCoder.encryptByPublicKey(card_number);
                    String encryptname=RsaCoder.encryptByPublicKey(name);
                    String encryptsex=RsaCoder.encryptByPublicKey(sex);
                    String encryptnotail=RsaCoder.encryptByPublicKey(notail);
                    String encryptaddress=RsaCoder.encryptByPublicKey(address);
                    String encryptbirthday=RsaCoder.encryptByPublicKey(birthday);

                    SpCacheUtil.Companion.getSpCacheUtil().saveStringData("card_number",encryptcard_number);
                    SpCacheUtil.Companion.getSpCacheUtil().saveStringData("wordsname",encryptname);
                    SpCacheUtil.Companion.getSpCacheUtil().saveStringData("wordssex",encryptsex);
                    SpCacheUtil.Companion.getSpCacheUtil().saveStringData("wordsnotail",encryptnotail);
                    SpCacheUtil.Companion.getSpCacheUtil().saveStringData("wordsaddress",encryptaddress);
                    SpCacheUtil.Companion.getSpCacheUtil().saveStringData("wordsbirthday",encryptbirthday);
                    //System.out.println(result);
                    return ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return null;
    }

   /* public static void main(String[] args) {
        //Idcard.idcard();
    }*/
}
