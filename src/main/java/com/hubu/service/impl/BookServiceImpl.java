package com.hubu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hubu.mapper.BookMapper;
import com.hubu.pojo.Book;
import com.hubu.service.BookService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public int addBook(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    public int getBookTotalNumber() {
        List<Book> bookList = bookMapper.selectAll();
        return bookList.size();
    }

    @Override
    public List<Book> getBookList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return bookMapper.selectAll();
    }

    @Override
    public int getBookByBookNameNumber(String bookName) {
        Example example = new Example(Book.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("bookName", "%" + bookName + "%");
        List<Book> bookList = bookMapper.selectByExample(example);
        return bookList.size();
    }

    @Override
    public List<Book> getBookListByBookName(String bookName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Book.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("bookName", "%" + bookName + "%");
        return bookMapper.selectByExample(example);
    }

    @Override
    public Book getBookListById(String id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public int deleteBook(String id) {
        return bookMapper.deleteByPrimaryKey(id);
    }
}
