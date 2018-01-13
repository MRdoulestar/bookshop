package com.yunsle.bookshop;

import com.yunsle.bookshop.dao.BookRepository;
import com.yunsle.bookshop.dao.OrderRepository;
import com.yunsle.bookshop.dao.UserRepository;
import com.yunsle.bookshop.entity.Book;
import com.yunsle.bookshop.entity.Order;
import com.yunsle.bookshop.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookshopApplicationTests {
	@Autowired
	UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    OrderRepository orderRepository;


	@Test
	public void contextLoads() {}

	@Test
    public void test() {
//        List<Order> orderList = orderRepository.findByUserid(1);
//        System.out.println(orderList);
//        List<Book> bookList = bookRepository.findBooks("%测试%");
//        System.out.println(bookList);
//        orderRepository.addOrder(1, 1, 100);
//	    bookRepository.update(1,"测试", "作者", "ceshi",
//                new Timestamp(12321232), 14.4, 14.4 ,"123123", "123123",
//                "31221", "123123" ,1);
//        bookRepository.insert(1,"测试2", "作者", "ceshi",
//                new Timestamp(12321232), 14.4, 14.4 ,"123123", "123123",
//                "31221", "123123");
	}

	@Test
    public void testt() {
        long t = Long.parseLong("12312312");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(t);
        String datestr = simpleDateFormat.format(date);
        Timestamp  ts = Timestamp.valueOf(datestr);
        System.out.println(ts);
    }

}
