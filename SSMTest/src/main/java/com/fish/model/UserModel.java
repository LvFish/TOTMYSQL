package com.fish.model;

public class UserModel {
    private int id;
    private String account;
    private String password;
    private String nickname;
    private int permission;

    public UserModel(){
        id = 0;
        account = null;
        password = null;
        nickname = null;
        permission = 0;
    }

    public UserModel(int id, String account, String password, String nickname, int permission) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
