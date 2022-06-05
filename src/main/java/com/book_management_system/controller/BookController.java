package com.book_management_system.controller;

import com.book_management_system.domain.Book;
import com.book_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@ResponseBody + @Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag, (flag ? Code.SAVE_OK : Code.SAVE_ERR));
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag =  bookService.update(book);
        return new Result(flag, (flag ? Code.UPDATE_OK : Code.UPDATE_ERR));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag, (flag ? Code.DELETE_OK : Code.DELETE_ERR));
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = (book != null) ? Code.GET_OK : Code.GET_ERR;
        String msg = (book != null) ? "" : "查询失败";
        return new Result(book, code, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.getAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "" : "数据查询失败，请重试！";
        return new Result(bookList, code,msg);
    }

    @GetMapping({"/cond/{name}"})
    public Result getByCondition(@PathVariable String name) {
        List<Book> bookList = bookService.getByCondition("%" + name + "%");
        return new Result(bookList, Code.GET_OK);
    }

    /*
     * Used for testing exception
     */
//    @PutMapping("/{id}")
//    public Result throwException(Integer id) {
////        int a = 1/0;
//        if (id == 1) {
//            throw new BusinessException(Code.BUSINESS_ERR, "Business error");
//        }
//        try{
//            int i = 1/0;
//        }catch (Exception e) {
//            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "System error", e);
//        }
//        return new Result();
//    }
}
