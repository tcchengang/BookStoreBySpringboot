package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.User;
import com.example.demo.service.BookService;
import com.example.demo.service.LoginService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/checkLogin")
	public String checkLogin(@RequestParam(value="userName") String userName,
				@RequestParam(value="userPass") String userPass, Model model) {
		PageHelper.startPage(1, 5);
		List<Book> books=bookService.getBooks();
		PageInfo pageInfo=new PageInfo(books,5);
		User user=loginService.getUserByName(userName);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userId",user.getUserId());
		model.addAttribute("userMoney", user.getUserMoney());
		if(userPass.equals(user.getUserPass())) {
			if(user.getUserPower()==0)
				return "freemaker/bookstore";
			else {
				return "freemaker/controller";
			}
		}
		else 
			return "freemaker/index";
		
	}
	
	@RequestMapping("/addUser")
	public String addUser() {
		return "freemaker/addUser";
	}
	@RequestMapping("/insertUser")
	public String insertUser(User user) {
		user.setUserPower(0);
		loginService.addUser(user);
		return "freemaker/regsuccess";
	}
}
