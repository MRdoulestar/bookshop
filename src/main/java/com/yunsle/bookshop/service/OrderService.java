package com.yunsle.bookshop.service;

import com.yunsle.bookshop.dao.OrderRepository;
import com.yunsle.bookshop.entity.*;
import com.yunsle.bookshop.utils.JsonUtil;
import com.yunsle.bookshop.utils.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Doublestar on 2018/1/10 19:31).
 */
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderUtil orderUtil;
    @Autowired
    JsonUtil jsonUtil;

    /**
     * 管理员查看所有订单
     * @return
     */
    public List<Myorder> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        //使用工具类进行类型转换
        System.out.println("订单转换工具调用");
        List<Myorder> myorders = orderUtil.toMyorders(orderList);
        return myorders;
    }

    /**
     * 用户获得自己的订单
     *
     * @param session
     * @return
     */
    public List<Myorder> getMyorders(HttpSession session) {
        User user = (User) session.getAttribute("user");
        int userid = (int) user.getId();
        List<Order> orderList = orderRepository.findByUserid(userid);
        //使用工具类进行类型转换
        System.out.println("订单转换工具调用");
        return orderUtil.toMyorders(orderList);
    }

    /**
     * 用户下单购买
     * @param session
     * @return
     */
    public StatusMessage addOrders(HttpSession session) {
        //获得用户
        User user = (User)session.getAttribute("user");
        //获得session中的购物车所有项，逐一加入订单
        List<CartItem> list = (List<CartItem>) session.getAttribute("cart");
        for (CartItem c : list) {
            orderRepository.addOrder((int)user.getId(), c.getId(), c.getNum());
        }
        //清空session购物车
        session.removeAttribute("cart");
        session.setAttribute("itemnums", 0);
        session.setAttribute("itemprices", 0.0);
        return new StatusMessage(200, "success", "下单成功");
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    public StatusMessage deleteOrder(long id) {
        try {
            orderRepository.delete(id);
            return new StatusMessage(200, "success", "订单删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusMessage(500, "error", "订单删除失败");
        }
    }

    /**
     * 更新订单
     * @param id
     * @param status
     * @return
     */
    public StatusMessage updateOrder(long id, String status) {
        try {
            int statusInt = 0;
            if(status.equals("已发货")) {
                statusInt = 1;
            }else if(status.equals("未发货")) {
                statusInt = 0;
            }else {
                throw new Exception("自定义抛出错误");
            }
            orderRepository.updateStatus(id, statusInt);
            return new StatusMessage(200, "success", "订单修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusMessage(500, "error", "订单修改失败");
        }
    }
}
