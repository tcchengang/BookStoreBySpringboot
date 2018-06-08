package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.pojo.Book;


public interface BookService {
	public List<Book> getBooks();
	public void addBook(Book book);
	public List<Book> getBooksByName(String bookName);
	public List<Book> getBookdByType(String type);
	public Book getBookById(int id);
}
