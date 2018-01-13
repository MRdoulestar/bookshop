package com.yunsle.bookshop.dao;

import com.yunsle.bookshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Doublestar on 2018/1/10 14:18).
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);

    @Query(value = "SELECT b FROM Book b WHERE b.bookname LIKE :bookname")
    List<Book> findBooks(@Param("bookname") String bookname);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO book(typeId,bookname,author,publisher,publish_time," +
            "price,priceoff,ISBN,description,catalog,img) VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",
            nativeQuery = true)
    void insert(int typeId, String bookname, String author, String publisher, Timestamp publish_time,
                double price, double priceoff, String ISBN, String description, String catalog, String img);


    @Transactional
    @Modifying
    @Query("update Book b set b.typeID = ?1, b.bookname=?2, b.author=?3, b.publisher=?4," +
            "b.publishTime=?5, b.price=?6, b.priceoff=?7, b.ISBN=?8, b.description=?9, b.catalog=?10," +
            "b.img=?11 where b.id = ?12")
    void diyUpdate(int typeId, String bookname, String author, String publisher, Timestamp publish_time,
                double price, double priceoff, String ISBN, String description, String catalog, String img,long id);

}
