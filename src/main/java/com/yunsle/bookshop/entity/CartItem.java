package com.yunsle.bookshop.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;

/**
 * Created by Doublestar on 2018/1/10 10:39).
 *购物车条目实体
 */
@Component
public class CartItem {

    int id; //书本id
    String bookname; //书本名称
    int num; //购买数量
    double price; //书本单价
    double allprice; //本书总价

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookname() {
        return bookname;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setAllprice(double allprice) {
        this.allprice = allprice;
    }

    public double getAllprice() {
        return allprice;
    }
}
