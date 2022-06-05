package com.book_management_system.dao;

import com.book_management_system.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据层：包含对于Mysql的增删改查操作
 */
@Mapper
public interface BookDao {
    @Insert("INSERT INTO tbl_book VALUES (null, #{type}, #{name}, #{description})")
    void save(Book book);

    @Update("UPDATE tbl_book SET type = #{type}, name = #{name}, description = #{description} WHERE id = #{id}")
    void update(Book book);

    @Delete("DELETE FROM tbl_book WHERE id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT * FROM tbl_book WHERE id = #{id}")
    Book getById(Integer id);

    @Select("SELECT * FROM tbl_book")
    List<Book> getAll();

    List<Book> getByCondition(String name);
}
