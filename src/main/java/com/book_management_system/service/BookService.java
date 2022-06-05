package com.book_management_system.service;

import com.book_management_system.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional //将所有方法进行AOP事务管理
public interface BookService {

    /**
     * Insert a book into tbl_book
     * @param book Book to be inserted
     * @return Success/Failure
     */
    boolean save(Book book);

    /**
     * Update a book's info
     * @param book Book to be updated
     * @return Success/Failure
     */
    boolean update(Book book);

    /**
     * Delete a book by id
     * @param id Deleted book's id
     * @return Success/Failure
     */
    boolean delete(Integer id);

    /**
     * Get a book by id
     * @param id Selected book's id
     * @return Selected book
     */
    Book getById(Integer id);

    /**
     * Get all books from tbl_book
     * @return List of all books from tbl_book
     */
    List<Book> getAll();

    List<Book> getByCondition(String name);
}
