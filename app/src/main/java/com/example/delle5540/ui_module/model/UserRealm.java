package com.example.delle5540.ui_module.model;

/**
 * Created by dell e5540 on 3/31/2018.
 */
import  io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserRealm extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;
    private String surname;

/*  Temporary */
    private String email;
    private String password;
/* ************/

    public UserRealm() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
