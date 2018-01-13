package com.yunsle.bookshop.dao;

import com.yunsle.bookshop.entity.Order;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Doublestar on 2018/1/10 14:20).
 */
public interface OrderRepository extends JpaRepository<Order, Long>{
    List<Order> findById(long id);
    List<Order> findByUserid(int userid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO t_order(userid,bookid,sum) VALUES (?1,?2,?3)", nativeQuery = true)
    void addOrder(int userid, int bookid, int sum);

    @Transactional
    @Modifying
    @Query(value = "UPDATE  t_order SET send_check=?2 WHERE id=?1", nativeQuery = true)
    void updateStatus(long id, int status);
}
