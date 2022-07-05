package com.icesi.model;

public class User {

    private int id;
    private String name;
    private String lastname;
    private String nickname;
    private String email;
    private String password;
    private String date_sing_up;

    public User(int id, String name, String lastname, String nickname, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public User(String name, String lastname, String nickname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_sing_up() {
        return date_sing_up;
    }

    public void setDate_sing_up(String date_sing_up) {
        this.date_sing_up = date_sing_up;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
