package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.User;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public String getUserPass(String userId) {
		Example example=new Example(User.class);
		Criteria criteria=example.createCriteria();
		criteria.andEqualTo("userId", userId);
		User user=userMapper.selectOneByExample(example);	
		//System.out.println(user.getUserPass());
		return user.getUserPass();
	}
	@Override
	public String getUserPassByName(String userName) {
		Example example=new Example(User.class);
		Criteria criteria=example.createCriteria();
		criteria.andEqualTo("userName", userName);
		User user=userMapper.selectOneByExample(example);	
		//System.out.println(user.getUserPass());
		return user.getUserPass();
	}
	@Override
	public User getUserByName(String userName) {
		Example example=new Example(User.class);
		Criteria criteria=example.createCriteria();
		criteria.andEqualTo("userName", userName);
		User user=userMapper.selectOneByExample(example);	
		//System.out.println(user.getUserPass());
		return user;
	}
	@Override
	public User getUserById(String userId) {
		return userMapper.selectByPrimaryKey(Integer.parseInt(userId));
	}
	@Override
	public void updateUser(String userId, String Money) {
		User user=getUserById(userId);
		user.setUserMoney(Float.parseFloat(Money));
		userMapper.updateByPrimaryKeySelective(user);
		
	}
	@Override
	public void addUser(User user) {
		userMapper.insertSelective(user);
		
	}
	
	
}
