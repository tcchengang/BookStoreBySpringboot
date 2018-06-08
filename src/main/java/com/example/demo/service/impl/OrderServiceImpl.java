package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.example.demo.mapper.UserorderMapper;
import com.example.demo.pojo.Userorder;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private UserorderMapper userorderMapper;
	@Override
	public List<Userorder> getAllOrders() {
		
		return userorderMapper.selectAll();
	}

	@Override
	public List<Userorder> getOrdersByUserId(String id) {
		Example example =new Example(Userorder.class);
		Criteria criteria=example.createCriteria();
		criteria.andEqualTo("orderUserid", id);
		return userorderMapper.selectByExample(example);
		 
	}

}
