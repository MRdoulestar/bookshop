package com.yunsle.bookshop.service;

import com.yunsle.bookshop.dao.BookRepository;
import com.yunsle.bookshop.entity.Book;
import com.yunsle.bookshop.entity.StatusMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Doublestar on 2018/1/10 15:15).
 *为求速度，不实现接口
 */
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String bookname) {
        return bookRepository.findBooks("%"+bookname+"%");
    }

    public Book findBookById(long id){
        return bookRepository.findById(id);
    }

    //删除书籍
    public StatusMessage deleteBook(long bookid) {
        try {
            bookRepository.delete(bookid);
            return new StatusMessage(200, "success", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusMessage(500, "error", "删除失败");
        }
    }
    //添加书籍
    public StatusMessage insertCustomer(Book book) {
        try {
            Book r = bookRepository.save(book);
            //返回添加的book的id
            return new StatusMessage(200, "success", String.valueOf(r.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusMessage(500, "error", "添加失败");
        }
    }

    //更新书籍
    public StatusMessage updateCustomer(Book book) {
        try {
//            bookRepository.update(book.getTypeID(), book.getBookname(),
//                    book.getAuthor(), book.getPublisher(), book.getPublishTime(), book.getPrice(),
//                    book.getPriceoff(), book.getISBN(), book.getDescription(), book.getCatalog(),
//                    book.getImg(), bookid);
            Book r = bookRepository.save(book);
            return new StatusMessage(200, "success", "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusMessage(500, "error", "修改失败");
        }
    }


}
