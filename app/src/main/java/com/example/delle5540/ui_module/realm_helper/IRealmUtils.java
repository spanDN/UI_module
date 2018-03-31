package com.example.delle5540.ui_module.realm_helper;

import com.example.delle5540.ui_module.model.User;
import com.example.delle5540.ui_module.model.UserRealm;

import java.util.List;

import io.realm.RealmResults;

/**
 * Created by dell e5540 on 3/31/2018.
 */

public interface IRealmUtils {
    void add(UserRealm user);
    void remove(int id);
    void addOrUpdate(UserRealm user);
    void removeAll();
    RealmResults<UserRealm> getAll();
}
