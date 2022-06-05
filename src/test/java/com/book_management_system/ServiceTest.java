package com.book_management_system;

import com.book_management_system.domain.Book;
import com.book_management_system.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testSave(){
        Book book = new Book (13, "test", "test", "test");
        Assertions.assertTrue(bookService.save(book));
    }

    @Test
    public void testUpdate(){
        Book book = new Book (13, "test", "test", "testUpdate");
        Assertions.assertTrue(bookService.update(book));
    }

    @Test
    public void testDelete() {
        Assertions.assertTrue(bookService.delete(13));
        Assertions.assertTrue(bookService.delete(14));
    }

    @Test
    public void testGetAll() {
        List<Book> books = bookService.getAll();
        System.out.println(books);
    }

    @Test
    public void testGet(){
        System.out.println(bookService.getById(1));
        System.out.println(bookService.getById(2));
        System.out.println(bookService.getById(3));
        System.out.println(bookService.getById(4));
        System.out.println(bookService.getById(5));
        System.out.println(bookService.getById(6));
    }

    @Test
    public void testGetByCondition() {
        List<Book> books = bookService.getByCondition("%java%");
        System.out.println(books);
    }
}
