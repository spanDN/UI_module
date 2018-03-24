package com.example.delle5540.ui_module.utils.Validator;

import android.text.TextUtils;
import android.util.Patterns;
import 	java.util.regex.Pattern;

/**
 * Created by dell e5540 on 3/24/2018.
 */

public class ValidatorImpl implements IValidator {
    @Override
    public boolean isPhoneValid(String phone) {
        if (!TextUtils.isEmpty(phone)) {
            return Patterns.PHONE.matcher(phone).matches();
        }
        return false;
    }

    @Override
    public boolean isEmailValid(String email) {
        if (!TextUtils.isEmpty(email)) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false;
    }

    @Override
    public boolean isPasswordValid(String password) {
        Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
