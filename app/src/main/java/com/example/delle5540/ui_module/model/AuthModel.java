package com.example.delle5540.ui_module.model;

/**
 * Created by dell e5540 on 2/15/2018.
 */

public class AuthModel {
    private String action;
    private String email;
    private String password;
    private String lang;
    private String timeZone;
    private String devId;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    @Override
    public String toString() {
        return "AuthModel{" +
                "action='" + action + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lang='" + lang + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", devId='" + devId + '\'' +
                '}';
    }
}
