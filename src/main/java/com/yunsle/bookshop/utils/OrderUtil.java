package com.yunsle.bookshop.utils;

import com.yunsle.bookshop.dao.BookRepository;
import com.yunsle.bookshop.entity.Myorder;
import com.yunsle.bookshop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doublestar on 2018/1/10 19:48).
 */
@Component
public class OrderUtil {
    @Autowired
    BookRepository bookRepository;

    /**
     * Order转为Myorder的工具方法
     * @param order
     * @return
     */
    public Myorder toMyorder(Order order) {
        Myorder myorder = new Myorder();
        //id
        myorder.setId(order.getId());
        //书籍名称
        myorder.setBookname(bookRepository.findById(order.getBookid()).getBookname());
        //购买数量
        myorder.setNum(order.getSum());
        //订单价格
        myorder.setPrice(order.getSum() * bookRepository.findById(order.getBookid()).getPrice());
        //发货状态
        myorder.setStatus( (order.getSend_check()==1)?"已发货":"未发货" );
        //订单提交时间
        myorder.setTime(order.getUpload_time());
        return myorder;
    }

    /**
     * Order的list转为Myorder的list工具方法
     * @param orderList
     * @return
     */
    public List<Myorder> toMyorders(List<Order> orderList){
        List<Myorder> list = new ArrayList<Myorder>();
        //转为Myorder的List
        for(Order order : orderList) {
            list.add(toMyorder(order));
        }
        return list;
    }

}
