package com.yunsle.bookshop.dao;

import com.yunsle.bookshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Doublestar on 2018/1/10 13:59).
 */
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findById(long id);
    User findByUsername(String username);
}
