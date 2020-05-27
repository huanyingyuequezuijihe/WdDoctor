package com.wd.doctor.bean.wy;

import java.io.Serializable;

//待实现功能
public class InquiryBean implements Serializable {
    private String userheadpic;
    private String username;
    private String usermessage;
    private Long usertime;

    public InquiryBean(String userheadpic, String username, String usermessage, Long usertime) {
        this.userheadpic = userheadpic;
        this.username = username;
        this.usermessage = usermessage;
        this.usertime = usertime;
    }

    public String getUserheadpic() {
        return userheadpic;
    }

    public void setUserheadpic(String userheadpic) {
        this.userheadpic = userheadpic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsermessage() {
        return usermessage;
    }

    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage;
    }

    public Long getUsertime() {
        return usertime;
    }

    public void setUsertime(Long usertime) {
        this.usertime = usertime;
    }
}
