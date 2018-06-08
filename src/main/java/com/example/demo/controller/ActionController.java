package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.User;
import com.example.demo.service.ActionService;
import com.example.demo.service.LoginService;

@Controller
public class ActionController {
	@Autowired
	private ActionService actionService;
	@Autowired
	private LoginService userService;
	@RequestMapping("/buy")
	public String buy(@RequestParam(value="userId") int userId ,@RequestParam(value="orderId", defaultValue="0") int  orderId,
			@RequestParam(value="bookId") int bookId,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,Model model) {
		model.addAttribute("userId", userId);
		if(orderId==0) {
			if(actionService.buy(userId, bookId)) {
				return "freemaker/success";
				
			}else {
				return "freemaker/fail";
			}
		}else {
			if(actionService.rebuy(userId, bookId,orderId)) {
				return "freemaker/success";
				
			}else {
				return "freemaker/fail";
			}
		}
	}
	@RequestMapping("/book")
	public String book(@RequestParam(value="userId") int userId ,
			@RequestParam(value="bookId") int bookId,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,Model model) {
		model.addAttribute("userId", userId);
		if(actionService.book(userId, bookId)) {
			return "freemaker/success";
			
		}else {
			return "freemaker/fail";
		}
	}
	@RequestMapping("/addMoney")
	public String addMoney(@RequestParam(value="userId") String userId ,
			@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,Model model) {
		model.addAttribute("userId", userId);
		User user=userService.getUserById(userId);
		model.addAttribute("userMoney", user.getUserMoney());
		return "freemaker/addMoney";
	}
	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam(value="userId") String userId ,
			@RequestParam(value="money") Double money,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,Model model) {
		User user=userService.getUserById(userId);
		money=money+user.getUserMoney();
		userService.updateUser(userId, money+"");
		
		model.addAttribute("userId", userId);
		return "freemaker/success";
	}
}
