package com.jeepway.model;

public class User {
    private int uid;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(int uid, String name, String email, String phone, String password) {
        setUid(uid);
        setName(name);
        setEmail(email);
        setPhone(phone);
        setPassword(password);
    }

    private void setUid(int uid) {
        this.uid = uid;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("User{uid=%d, name='%s', email='%s', phone='%s', password='%s'}", 
                getUserID(), getName(), getEmail(), getPhone(), getPassword());
    }
}
