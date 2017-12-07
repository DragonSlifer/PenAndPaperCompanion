package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model;

/**
 * Created by Jorge on 26/11/2017.
 */

public class User {
    private String user_name, user_pass, salt, user_id, email;

    public User(String user_name, String user_pass) {
        this.user_name = user_name;
        this.user_pass = user_pass;
    }

    public User(String user_name, String user_pass, String user_id) {
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.user_id = user_id;
    }

    public boolean checkInfo(String user_name, String user_pass) {
        return ((user_name == this.user_name) && (user_pass == this.user_pass));
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }


    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return user_id;
    }
}
