package com.khusin;

import java.io.Serializable;

/**
 * Created by sinchan on 07/09/17.
 */
public class Action implements Serializable{

    private String sms;
    private String smsDetail;

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getSmsDetail() {
        return smsDetail;
    }

    public void setSmsDetail(String smsDetail) {
        this.smsDetail = smsDetail;
    }
}
