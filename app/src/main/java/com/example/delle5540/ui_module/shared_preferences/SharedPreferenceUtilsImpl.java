package com.example.delle5540.ui_module.shared_preferences;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.delle5540.ui_module.model.User;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dell e5540 on 3/31/2018.
 */

public class SharedPreferenceUtilsImpl implements ISharedUtils {

    private Application application;
    public static final String PREFS_NAME = "SP_UTILS";
    public static final String USERS_CONSTANT = "Users";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public SharedPreferenceUtilsImpl(Application application) {
        this.application = application;
    }

    @Override
    public void init() {
        preferences = application.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    @Override
    public List<User> getUsers() {
        List<User> users;
        if(preferences.contains(USERS_CONSTANT)) {
            String jsonUser = preferences.getString(USERS_CONSTANT, null);
            Gson gson = new Gson();
            User[] usersItems = gson.fromJson(jsonUser, User[].class);
            users = Arrays.asList(usersItems);
        } else {
            return null;
        }
        return users;
    }

    @Override
    public void addUser(User user_input) {
        List<User> users = getUsers();
        if ( users == null ) {
            users = new ArrayList<User>();
        }
        users.add(user_input);
        saveUsers(users);
    }

    @Override
    public void removeUser(User user) {
        List<User> users = getUsers();
        if(users != null ) {
            users.remove(user);
            saveUsers(users);
        }
    }

    @Override
    public void removeUsers() {
        List<User> users = getUsers();
        if(users != null ) {
            for(User internal_user : users) {
                users.remove(internal_user);
            }
        }
        saveUsers(users);
    }

    @Override
    public void saveUsers(List<User> users) {
        Gson gson = new Gson();
        String jsonUsers = gson.toJson(users);

        editor.putString(USERS_CONSTANT, jsonUsers);
        editor.commit();
    }
}
