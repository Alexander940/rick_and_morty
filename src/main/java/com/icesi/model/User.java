package com.icesi.model;

/**
 * This class contains the data and the actions of a user
 * @author alexanderecheverry
 * @version 1.0
 */
public class User {

    private int id;
    private String name;
    private String lastname;
    private String nickname;
    private String email;
    private String password;
    private String date_sing_up;
    private int points;
    private int seedsGotten;
    private boolean winner;

    public User(int id, String name, String lastname, String nickname, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        winner = false;
    }

    public User(String name, String lastname, String nickname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        winner = false;
    }

    public User(){
        winner = false;
    }

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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getSeedsGotten() {
        return seedsGotten;
    }

    public void setSeedsGotten(int seedsGotten) {
        this.seedsGotten = seedsGotten;
    }

    public void addSeed(){
        seedsGotten++;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", date_sing_up='" + date_sing_up + '\'' +
                '}';
    }
}
