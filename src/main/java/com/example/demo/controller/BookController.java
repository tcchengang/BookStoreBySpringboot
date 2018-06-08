package com.example.demo.controller;

import java.util.List;

import javax.xml.stream.events.StartDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.User;
import com.example.demo.service.BookService;
import com.example.demo.service.LoginService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired 
	private LoginService userService;
	@GetMapping("/getBooks")
	public String getBooks(@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,
			@RequestParam(value="userId",required=false) String userId,Model model) {
		PageHelper.startPage(pageNum, 5);
		List<Book> books=bookService.getBooks();
		PageInfo pageInfo=new PageInfo(books,5);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userId", userId);
		User user=userService.getUserById(userId);
		model.addAttribute("userMoney", user.getUserMoney());
		if(user.getUserPower()==0)
			return "freemaker/bookstore";
		else {
			return "freemaker/controller";
		}	

	}
	
	@GetMapping("/addBook")
	public String addBook() {
		Book book =new Book();

		for (int i = 0; i < 10; i++) {
			book.setBookName("2"+i);
			book.setBookPrice((float) 12.0);
			book.setBookType("散文");
			bookService.addBook(book);
		}
		return "freemaker/bookstore";
	}
	
	@GetMapping("/getBooksByName")
	public String getBooksbyName(@RequestParam(value="bookName",defaultValue="1") String bookName ,
			@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,
			@RequestParam(value="userId") String userId,Model model) {
		PageHelper.startPage(pageNum, 5);
		List<Book> books=bookService.getBooksByName(bookName);
		PageInfo pageInfo=new PageInfo(books,5);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userId", userId);
		User user=userService.getUserById(userId);
		model.addAttribute("userMoney", user.getUserMoney());
		return "freemaker/bookstore";
	}
	
	@GetMapping("/getBooksByType")
	public String getBooksbyType(@RequestParam(value="bookType",defaultValue="1") String bookType ,
			@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,
			@RequestParam(value="userId") String userId,Model model) {
		PageHelper.startPage(pageNum, 5);
		List<Book> books=bookService.getBookdByType(bookType);
		PageInfo pageInfo=new PageInfo(books,5);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userId", userId);
		User user=userService.getUserById(userId);
		model.addAttribute("userMoney", user.getUserMoney());
		return "freemaker/bookstore";
	}
	@GetMapping("/login")
	public String login() {
		return "freemaker/index";
	}
	
	@GetMapping("/start")
	public String start() {
		return "freemaker/start";
	}
	@GetMapping("toAddBook")
	public String toAddBook(@RequestParam(value="userId",required=false) String userId,Model model) {
		model.addAttribute("userId", userId);
		return "freemaker/addBook";
	}
	@GetMapping("/insertBook")
	public String insertBook(Book book,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,
			@RequestParam(value="userId",required=false) String userId,Model model) {		
			bookService.addBook(book);
			PageHelper.startPage(pageNum, 5);
			List<Book> books=bookService.getBooks();
			PageInfo pageInfo=new PageInfo(books,5);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("userId", userId);
			User user=userService.getUserById(userId);
			model.addAttribute("userMoney", user.getUserMoney());
			if(user.getUserPower()==0)
				return "freemaker/bookstore";
			else {
				return "freemaker/controller";
			}
	}
	
}
