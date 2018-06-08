package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Userorder;

public interface OrderService {
	public List<Userorder>  getAllOrders();
	public List<Userorder>  getOrdersByUserId(String id);
}
