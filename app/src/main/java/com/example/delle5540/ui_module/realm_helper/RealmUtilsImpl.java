package com.example.delle5540.ui_module.realm_helper;

import com.example.delle5540.ui_module.model.User;
import com.example.delle5540.ui_module.model.UserRealm;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dell e5540 on 3/31/2018.
 */

public class RealmUtilsImpl implements IRealmUtils {

    private Realm mRealm;

    public RealmUtilsImpl(Realm mRealm) {
        this.mRealm = mRealm;
    }

    @Override
    public Realm get() {
        return mRealm;
    }

    @Override
    public void closeRealm() {
        mRealm.close();
    }

    @Override
    public void refresh() {
        mRealm.refresh();
    }

    @Override
    public <T extends RealmObject> Observable<T> addObject(T object, Class<T> clazz) {
//        long id;
//        try {
//            id = mRealm.where(clazz).max("id").intValue() + 1;
//        } catch (Exception e) {
//            id = 0L;
//        }
        ((User) object).setId(1);
        return Observable.just(object)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .flatMap(t -> Observable.just(t)
                        .doOnSubscribe(mRealm::beginTransaction)
                        .doOnUnsubscribe(() -> {
                            mRealm.commitTransaction();
                        })
                        .doOnError(Throwable::printStackTrace)
                        .doOnNext(next -> mRealm.copyToRealmOrUpdate(next))
                );
    }

    @Override
    public <T extends RealmObject> Observable <RealmResults<T>> getObjects(Class<T> clazz) {

        return Observable.just(clazz)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .flatMap(t -> Observable.just(t)
                        .doOnSubscribe(mRealm::beginTransaction)
                        .doOnUnsubscribe(() -> {
                            mRealm.commitTransaction();
                        }).map(type->mRealm.where(type).findAll()));
    }

    @Override
    public <T extends RealmObject> Observable<T> getObject(long id, Class<T> clazz) {
        return Observable.just(clazz)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .flatMap(t -> Observable.just(t)
                        .doOnSubscribe(mRealm::beginTransaction)
                        .doOnUnsubscribe(() -> {
                            mRealm.commitTransaction();
                        })
                        .doOnError(Throwable::printStackTrace)
                        .map(type->mRealm.where(type).equalTo("user_id", id).findFirst()));
    }

    @Override
    public <T extends RealmObject> Observable <T> getLastObject(Class<T> clazz) {

        return Observable.just(clazz)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .flatMap(t -> Observable.just(t)
                        .doOnSubscribe(mRealm::beginTransaction)
                        .doOnUnsubscribe(() -> {
                            mRealm.commitTransaction();
                        }).map(type->mRealm.where(type).findAll().last()));
    }

    @Override
    public <T extends RealmObject> Observable<Class <T>> deleteObject( long id, Class<T> clazz) {

        return Observable.just(clazz)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .flatMap(t -> Observable.just(t)
                        .doOnSubscribe(mRealm::beginTransaction)
                        .doOnUnsubscribe(() -> {
                            mRealm.commitTransaction();
                        })
                        .doOnError(Throwable::printStackTrace)
                        .doOnNext(type->mRealm.where(type).equalTo("user_id", id).findFirst().removeFromRealm()));
    }

    @Override
    public <T extends RealmObject> Observable<Class <T>> deleteAllObjects( Class<T> clazz) {

        return Observable.just(clazz)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .flatMap(t -> Observable.just(t)
                        .doOnSubscribe(mRealm::beginTransaction)
                        .doOnUnsubscribe(() -> {
                            mRealm.commitTransaction();
                        })
                        .doOnError(Throwable::printStackTrace)
                        .doOnNext(type->mRealm.where(type).findAll().clear()));
    }
}
