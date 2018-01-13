package com.yunsle.bookshop.entity;

import javax.persistence.*;

/**
 * Created by Doublestar on 2018/1/10 13:45).
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    long id;
    String username;    //用户名
    String password;    //密码
    int points; //积分
    int role;   //角色

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
