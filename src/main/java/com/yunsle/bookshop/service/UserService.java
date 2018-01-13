package com.yunsle.bookshop.service;

import com.yunsle.bookshop.dao.UserRepository;
import com.yunsle.bookshop.entity.StatusMessage;
import com.yunsle.bookshop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by Doublestar on 2018/1/10 19:08).
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * 管理员登陆
     * @param session
     * @param name
     * @param password
     * @return
     */
    public StatusMessage adminLogin(HttpSession session, String name, String password) {
        try {
            User admin = userRepository.findByUsername(name);
            if(admin.getPassword().equals(password) && admin.getRole() == 1) {
                //设置session信息
                session.setAttribute("isAdmin",true);
                return new StatusMessage(200, "success", "登陆成功");
            } else {
                return new StatusMessage(500, "error", "登陆失败");
            }
        } catch (Exception e) {
            return new StatusMessage(500, "error", "登陆失败");
        }
    }

    /**
     * 用户登陆
     * @param name
     * @param password
     * @return
     */
    public StatusMessage userLogin(HttpSession session, String name, String password) {
        try {
            User user = userRepository.findByUsername(name);
            if(user.getPassword().equals(password) && user.getRole() == 0) {
                //设置session信息
                session.setAttribute("isLogin",true);
                session.setAttribute("user", user);
                session.setAttribute("itemprices",0.0);
                session.setAttribute("itemnums",0);
                return new StatusMessage(200, "success", "登陆成功");
            } else {
                return new StatusMessage(500, "error", "登陆失败");
            }
        } catch (Exception e) {
            return new StatusMessage(500, "error", "登陆失败");
        }
    }

    /**
     * 用户注销
     * @param session
     */
    public void userLogout(HttpSession session) {
        session.removeAttribute("isLogin");
        session.removeAttribute("user");
        session.removeAttribute("cart");
        session.setAttribute("itemnums", 0);
        session.setAttribute("itemprices", 0.0);
    }

    /**
     * 用户注册
     * @param name
     * @param password
     * @param repassword
     * @return
     */
    public StatusMessage userResistor(String name, String password, String repassword) {
        if(!password.equals(repassword)){
            return new StatusMessage(500, "error", "两次密码不一致");
        }
        if(userRepository.findByUsername(name) != null){
            return new StatusMessage(500, "error", "该用户已经被注册");
        }
        try {
            User newuser = new User();
            newuser.setRole(0);
            newuser.setUsername(name);
            newuser.setPassword(password);
            userRepository.save(newuser);
            return new StatusMessage(200, "success", "注册成功");
        }catch (Exception e) {
            return new StatusMessage(200, "success", "注册失败");
        }
    }
}
