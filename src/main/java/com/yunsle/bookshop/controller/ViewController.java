package com.yunsle.bookshop.controller;

import com.yunsle.bookshop.dao.OrderRepository;
import com.yunsle.bookshop.entity.Book;
import com.yunsle.bookshop.service.BookService;
import com.yunsle.bookshop.service.OrderService;
import com.yunsle.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Doublestar n 2018/1/9 18:27).
 */
@Controller
public class ViewController {
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    //前台主页
    @RequestMapping("/")
    public String welcome() {
        return "redirect:/index";
    }
    @RequestMapping("/index")
    public String index(HttpSession session) {
        System.out.println(session.getAttribute("itemprices"));
        return "home";
    }
    //所有图书展示,以及搜索
    @RequestMapping("/books")
    public String allBook(Model model, HttpSession session, String search) {
        if(search == null) {
            model.addAttribute("books", bookService.getAllBooks());
        }else {
            model.addAttribute("books", bookService.searchBooks(search));
        }
        return "all-books";
    }

    //图书单页
    @RequestMapping("/book")
    public String singleBook(Model model, HttpSession session, String bookid) {
        if(bookid == null){ //判断参数是否传递
            return "404";
        }
        long id = Long.parseLong(bookid);   //解析成long
        Book book = bookService.findBookById(id);
        if(book == null) {  //判断书本参数是否正确
          return "404";
        }
        model.addAttribute("book", book);
        return "single-book";
    }

    //我的账户
    @RequestMapping("/mycount")
    public String mycount(Model model, HttpSession session) {
        return "mycount";
    }

    //我的订单
    @RequestMapping("/myorder")
    public String myorder(Model model, HttpSession session) {
        model.addAttribute("myorders", orderService.getMyorders(session));
        return "myorder";
    }

    //购物车页
    @RequestMapping("/cart")
    public String cart(Model model, HttpSession session) {
        model.addAttribute("cart", session.getAttribute("cart"));
        return "cart";
    }

    //登陆页
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //退出登陆页面
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        userService.userLogout(session);
        return "redirect:/index";
    }

    //注册页
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    //忘记密码
    @RequestMapping("/forgetpassword")
    public String forgetpwd() {
        return "forgetpwd";
    }

    //管理员登陆
    @RequestMapping("/adminlogin")
    public String adminlogin() {
        return "adminlogin";
    }
}
