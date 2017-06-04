package com.stunstun.spring.service.entity;

public class User {

    public Long id;

    public String userName;

    protected User() {}

    public User(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        return (userName == null ? userName.length() : 0);
    }

    @Override
    public String toString() {
        return "id[" +id + "] userName[" + userName + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}