package com.example.delle5540.ui_module.commons;

/**
 * Created by dell e5540 on 5/8/2018.
 */

public class CommonRequest {
    private  String email;
    private  String password;

    public CommonRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
