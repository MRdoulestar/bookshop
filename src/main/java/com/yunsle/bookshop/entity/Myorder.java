package com.yunsle.bookshop.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by Doublestar on 2018/1/10 19:40).
 */
@Component
@ExcelTarget("myorder")
public class Myorder {
    @Excel(name = "编号", orderNum = "1", mergeVertical = true, isImportField = "id")
    long id;
    @Excel(name = "书名", orderNum = "2", mergeVertical = true, isImportField = "bookname")
    String bookname;
    @Excel(name = "数量", orderNum = "3", mergeVertical = true, isImportField = "num")
    int num;
    double price;
    @Excel(name = "状态", orderNum = "4", mergeVertical = true, isImportField = "status")
    String status;
    @Excel(name = "订单提交时间", orderNum = "5", mergeVertical = true, isImportField = "time")
    Timestamp time;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

}
