package com.yunsle.bookshop.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunsle.bookshop.entity.Book;
import com.yunsle.bookshop.entity.Myorder;
import com.yunsle.bookshop.entity.Order;
import com.yunsle.bookshop.entity.StatusMessage;
import com.yunsle.bookshop.service.BookService;
import com.yunsle.bookshop.service.OrderService;
import com.yunsle.bookshop.utils.DateUtil;
import com.yunsle.bookshop.utils.JsonUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Doublestar on 2018/1/11 16:32).
 */
@RestController
@RequestMapping(value = "/admin/post", method = RequestMethod.POST)
public class AdminPostController {
    @Autowired
    BookService bookService;
    @Autowired
    OrderService orderService;
    @Autowired
    DateUtil dateUtil;
    @Autowired
    JsonUtil jsonUtil;

    //获得所有书籍
    @RequestMapping("/getbooks")
    public StatusMessage getbooks() {
        return jsonUtil.toJson(bookService.getAllBooks());
    }

    //删除书籍
    @RequestMapping("/deletebook")
    public StatusMessage delbook(long bookid) {
        return bookService.deleteBook(bookid);
    }

    //修改书籍
    @RequestMapping("/updatebook")
    public StatusMessage updatebook(Book book, String time) {
        Timestamp timestamp = dateUtil.stringToTimestamp(time);
        book.setPublishTime(timestamp);
        return bookService.updateCustomer(book);
    }

    //添加书籍
    @RequestMapping("/insertbook")
    public StatusMessage insertbook(Book book, String time) {
        Timestamp timestamp = dateUtil.stringToTimestamp(time);
        book.setPublishTime(timestamp);
        return bookService.insertCustomer(book);
    }

    //获得所有订单
    @RequestMapping("/getorders")
    public StatusMessage getorders() {
        return jsonUtil.toJson(orderService.getAllOrders());
    }

    //删除订单
    @RequestMapping("/deleteorder")
    public StatusMessage delorder(long id) {
        return orderService.deleteOrder(id);
    }

    //修改订单
    @RequestMapping("/updateorder")
    public StatusMessage updateorder(long id, String status) {
        return orderService.updateOrder(id, status);
    }

}
