package com.hubu.controller;

import com.hubu.pojo.Book;
import com.hubu.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
//设置produces 解决post请求的中文乱码问题
@RequestMapping(value = "/book", produces = {"application/json;charset=UTF-8"})
@CrossOrigin
public class BookController {

    @Resource
    private HttpSession session;

    @Resource
    private BookService bookService;

    @PostMapping("/addBook")
    public String addBook(Book book)
    {
        int i = bookService.addBook(book);
        return "添加书籍" + book.getBookName() + "成功!";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String realName = file.getOriginalFilename();
        String realPath = session.getServletContext().getRealPath("/images");
        File dest = new File(realPath + "\\" + realName);
        file.transferTo(dest);
        return "上传图片" + realName + "成功!";
    }

    @GetMapping("/getTotalNumber")
    public int getBookToTalNumber(){
        return bookService.getBookTotalNumber();
    }

    @GetMapping("/page/{pageNum}/{pageSize}")
    public List<Book> getBookList(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return bookService.getBookList(pageNum, pageSize);
    }

    @PostMapping("/getBookByBookNameNumber")
    public int getBookByBookNameNumber(String bookName){
        return bookService.getBookByBookNameNumber(bookName);
    }

    @PostMapping("/getBookListByBookName/{pageNum}/{pageSize}")
    public List<Book> getBookListByBookName(String bookName, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return bookService.getBookListByBookName(bookName, pageNum, pageSize);
    }

    @PostMapping("/getBookById")
    public Book getBookListById(String id){
        return bookService.getBookListById(id);
    }

    @PostMapping("/updateBook")
    public String updateBook(Book book){
        int i = bookService.updateBook(book);
        return "修改书籍" + book.getBookName() + "成功!";
    }

    @PostMapping("/deleteBook")
    public int deleteBook(String id){
        return bookService.deleteBook(id);
    }
}
