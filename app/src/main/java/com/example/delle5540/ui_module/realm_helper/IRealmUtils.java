package com.example.delle5540.ui_module.realm_helper;

import com.example.delle5540.ui_module.model.User;
import com.example.delle5540.ui_module.model.UserRealm;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

import java.util.List;

import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by dell e5540 on 3/31/2018.
 */

public interface IRealmUtils
{
    void add(UserRealm user);
    void remove(int id);
    void addOrUpdate(UserRealm user);
    void removeAll();
    RealmResults<UserRealm> getAll();

    /* New interface part */
    Realm get();
    void closeRealm();
    void refresh();
    <T extends RealmObject> Observable<T> addObject(T object, Class<T> clazz);
    <T extends RealmObject> Observable<RealmResults<T>> getObjects(Class<T> clazz);
    <T extends RealmObject> Observable<Class<T>> deleteObject(long id, Class<T> clazz);
    <T extends RealmObject> Observable<Class<T>> deleteAllObjects(Class<T> clazz);
    <T extends RealmObject> Observable<T> getLastObject(Class<T> clazz);
}
