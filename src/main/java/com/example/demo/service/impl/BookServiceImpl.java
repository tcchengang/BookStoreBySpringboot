package com.example.demo.service.impl;

import java.util.List;

import net.bytebuddy.asm.Advice.This;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.example.demo.mapper.BookMapper;
import com.example.demo.pojo.Book;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<Book> getBooks() {
		List<Book> books=bookMapper.selectAll();		
		return books;
	}

	@Override
	public void addBook(Book book) {
		bookMapper.insert(book);
		
	}

	@Override
	public List<Book> getBooksByName(String bookName) {
		Example example=new Example(Book.class);
		Criteria criteria=example.createCriteria();
		criteria.andLike("bookName", "%"+bookName+"%");
		//criteria.andEqualTo("bookName", bookName);
		List<Book> books=bookMapper.selectByExample(example);
		return books;
	}

	@Override
	public List<Book> getBookdByType(String type) {
		Example example=new Example(Book.class);
		Criteria criteria=example.createCriteria();
		//criteria.andLike("bookName", "%"+type+"%");
		criteria.andEqualTo("bookType", type);
		List<Book> books=bookMapper.selectByExample(example);
		return books;
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
