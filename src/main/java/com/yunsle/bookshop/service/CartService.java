package com.yunsle.bookshop.service;

import com.yunsle.bookshop.dao.BookRepository;
import com.yunsle.bookshop.entity.Book;
import com.yunsle.bookshop.entity.Cart;
import com.yunsle.bookshop.entity.CartItem;
import com.yunsle.bookshop.entity.StatusMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doublestar on 2018/1/10 21:36).
 */
@Service
public class CartService {

    @Autowired
    BookRepository bookRepository;

    //工具函数，从bookid获取对应的购物车项
    private CartItem getCartItemByBookid(int bookid) {
        CartItem cartItem = new CartItem();
        Book book = bookRepository.findById(bookid);
        cartItem.setId(bookid);
        cartItem.setNum(1);
        cartItem.setBookname(book.getBookname());
        cartItem.setPrice(book.getPrice());
        cartItem.setAllprice(book.getPrice());
        return cartItem;
    }

    /**
     * 加入购物车
     *
     * @param session
     * @param bookid
     * @return
     */
    public StatusMessage addCartItem(HttpSession session, int bookid) {
        //获取bookid对应的购物车条目
        CartItem cartItem = getCartItemByBookid(bookid);
        //操作session
        List<CartItem> list = new ArrayList<CartItem>();
        List<CartItem> temp = new ArrayList<CartItem>();
        double itemprices;
        int itemnums;
        boolean exist = false;
        //如果session中购物车已经存在
        if (session.getAttribute("cart") != null) {
            temp = (List<CartItem>) session.getAttribute("cart");
        }
        //对新增的购物条目是否存在进行处理,如果已经存在，直接添加数量和总价
        for (CartItem c : temp) {
            if (c.getId() == (cartItem.getId())) {
                c.setNum(1 + c.getNum());
                c.setAllprice(c.getAllprice() + c.getPrice());
                exist = true;
            }
            list.add(c);
        }
        //不存在直接添加一项
        if (!exist) {
            list = temp;
            list.add(cartItem);
        }
        //购物车总价和商品总数增加
        try {
            itemnums = (int) session.getAttribute("itemnums") + 1;
            itemprices = (double) session.getAttribute("itemprices")
                    + cartItem.getPrice();
            session.setAttribute("itemnums", itemnums);
            session.setAttribute("itemprices", itemprices);
            //更新购物车
            session.setAttribute("cart", list);
            return new StatusMessage(200, "success", "添加到购物车成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusMessage(500, "error", "添加到购物车失败,请先登录");
        }

    }

    /**
     * 减少购物车
     *
     * @param session
     * @param bookid
     * @return
     */
    public StatusMessage minusCartItem(HttpSession session, int bookid) {
        //获取bookid对应的购物车条目
        CartItem cartItem = getCartItemByBookid(bookid);
        //操作session
        List<CartItem> list = new ArrayList<CartItem>();
        List<CartItem> temp = new ArrayList<CartItem>();
        double itemprices;
        int itemnums;
        //如果session中购物车已经存在
        temp = (List<CartItem>) session.getAttribute("cart");
        //对新增的购物条目是否存在进行处理,如果已经存在，直接添加数量和总价
        for (CartItem c : temp) {
            if (c.getId() == (cartItem.getId())) {
                c.setNum(c.getNum() - 1);
                c.setAllprice(c.getAllprice() - c.getPrice());
            }
            list.add(c);
        }
        //购物车总价和商品总数减少
        try {
            itemnums = (int) session.getAttribute("itemnums") - 1;
            itemprices = (double) session.getAttribute("itemprices")
                    - cartItem.getPrice();
            session.setAttribute("itemnums", itemnums);
            session.setAttribute("itemprices", itemprices);
            //更新购物车
            session.setAttribute("cart", list);
            return new StatusMessage(200, "success", "减少购物车成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusMessage(500, "error", "减少购物车失败");
        }

    }

    /**
     * 删除购物车项
     *
     * @param session
     * @param bookid
     * @return
     */
    public StatusMessage delCartItem(HttpSession session, int bookid) {
        CartItem cartItem = getCartItemByBookid(bookid);
        List<CartItem> list = new ArrayList<CartItem>();
        List<CartItem> temp = new ArrayList<CartItem>();
        double itemprices = 0;
        int itemnums = 0;
        if (session.getAttribute("cart") != null) {
            temp = (List<CartItem>) session.getAttribute("cart");
        }
        //删除指定ID项
        for (CartItem c : temp) {
            if (c.getId() != cartItem.getId()) {
                list.add(c);
            } else {
                itemnums = c.getNum();
            }
        }
        //购物车总价和商品总数减少
        System.out.println(cartItem.getNum());
        itemprices = (double) session.getAttribute("itemprices") - (double) itemnums * cartItem.getPrice();
        itemnums = (int) session.getAttribute("itemnums") - itemnums;
        session.setAttribute("itemnums", itemnums);
        session.setAttribute("itemprices", itemprices);
        //更新购物车
        session.setAttribute("cart", list);
        return new StatusMessage(200, "success", "删除成功");
    }

}
