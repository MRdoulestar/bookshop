package com.yunsle.bookshop.controller;

import com.yunsle.bookshop.entity.Cart;
import com.yunsle.bookshop.entity.CartItem;
import com.yunsle.bookshop.entity.StatusMessage;
import com.yunsle.bookshop.service.CartService;
import com.yunsle.bookshop.service.OrderService;
import com.yunsle.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Doublestar on 2018/1/10 15:13).
 */
@RestController
@RequestMapping(value = "/post", method = RequestMethod.POST)
public class PostController {
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;

    //  用户登陆
    @RequestMapping("/login.do")
    public StatusMessage login(HttpSession session, String name, String password) {
        return userService.userLogin(session, name, password);
    }

    //管理员登陆
    @RequestMapping("/adminlogin.do")
    public StatusMessage adminlogin(HttpSession session, String name, String password) {
        return userService.adminLogin(session, name, password);
    }

    //  用户注册模块
    @RequestMapping(value = "/register.do")
    public StatusMessage register(String name, String password, String repassword) {
        return userService.userResistor(name, password, repassword);
    }

    //  添加到购物车
    @RequestMapping(value = "/addcart.do")
    public StatusMessage addcart(HttpSession session, int bookid) {
        return cartService.addCartItem(session, bookid);
    }

    //  购物车减少
    @RequestMapping(value = "/minuscart.do")
    public StatusMessage minuscart(HttpSession session, int bookid) {
        return cartService.minusCartItem(session, bookid);
    }

    //  删除购物车条目
    @RequestMapping(value = "/delcart.do")
    public StatusMessage delcart(HttpSession session, int bookid) {
        return cartService.delCartItem(session, bookid);
    }

    //用户下单
    @RequestMapping(value = "/buy.do")
    public StatusMessage buy(HttpSession session) {
        return orderService.addOrders(session);
    }
}