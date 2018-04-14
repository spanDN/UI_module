package com.example.delle5540.ui_module.realm_helper;

import com.example.delle5540.ui_module.model.UserRealm;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by dell e5540 on 3/31/2018.
 */

public class RealmUtilsImpl implements IRealmUtils {

    private Realm realm;

    public RealmUtilsImpl(Realm input) {
        this.realm = input;
    }

    @Override
    public void add(UserRealm user) {
        realm.beginTransaction();
        realm.copyToRealm(user);
        realm.commitTransaction();
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void addOrUpdate(UserRealm user) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public RealmResults<UserRealm> getAll() {
        return null;
    }


}
