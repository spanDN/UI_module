package com.example.delle5540.ui_module.shared_preferences;

import com.example.delle5540.ui_module.model.User;

import java.util.List;

/**
 * Created by dell e5540 on 3/31/2018.
 */

public interface ISharedUtils {
    void init();
    List<User> getUsers();
    void addUser(User user);
    void removeUser(User user);
    void removeUsers();
    void saveUsers(List <User> users);
}
