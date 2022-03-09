package com.hubu.service;

import com.hubu.pojo.Book;
import java.util.List;


public interface BookService {

    int addBook(Book book);

    int getBookTotalNumber();

    List<Book> getBookList(int pageNum, int pageSize);

    int getBookByBookNameNumber(String bookName);

    List<Book> getBookListByBookName(String bookName, int pageNum, int pageSize);

    Book getBookListById(String id);

    int updateBook(Book book);

    int deleteBook(String id);
}
