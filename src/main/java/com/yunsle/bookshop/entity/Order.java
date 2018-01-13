package com.yunsle.bookshop.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Doublestar on 2018/1/10 13:45).
 */
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    long id;
    int userid; //用户id
    int bookid; //书本id
    int sum;    //数量
    int send_check; //发货状态
    Timestamp upload_time;  //订单提交时间戳

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSend_check() {
        return send_check;
    }

    public void setSend_check(int send_check) {
        this.send_check = send_check;
    }

    public void setUpload_time(Timestamp upload_time) {
        this.upload_time = upload_time;
    }

    public Timestamp getUpload_time() {
        return upload_time;
    }
}
