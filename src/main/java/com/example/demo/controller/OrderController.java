package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Userorder;
import com.example.demo.service.LoginService;
import com.example.demo.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired 
	private LoginService userService;
	@RequestMapping("/getOrdersByUserId")
	public String getOrdersByUserId(@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,
			@RequestParam(value="userId") String userId,Model model) {
		PageHelper.startPage(pageNum, 5);
		List<Userorder> orders=orderService.getOrdersByUserId(userId);
		User user=userService.getUserById(userId);
		PageInfo pageInfo=new PageInfo(orders,5);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userId", userId);
		model.addAttribute("userMoney", user.getUserMoney());
		return "freemaker/orderInfo";
	}
	
	@RequestMapping("/getAllOrders")
	public String getAllOrders(@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,Model model) {
		PageHelper.startPage(pageNum, 5);
		List<Userorder> orders=orderService.getAllOrders();
		PageInfo pageInfo=new PageInfo(orders,5);
		model.addAttribute("pageInfo", pageInfo);
		return "freemaker/orderInfo";
	}
}
