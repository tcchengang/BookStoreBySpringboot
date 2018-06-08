package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.StoreMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserorderMapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.Store;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Userorder;
import com.example.demo.service.ActionService;
@Service
public class ActionServiceImpl implements ActionService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private StoreMapper storeMapper;
	@Autowired
	private BookMapper bookMapper;
	@Override
	public boolean buy(int userId, int bookId) {
		Book book=bookMapper.selectByPrimaryKey(bookId);
		Float price=book.getBookPrice();
		User user=userMapper.selectByPrimaryKey(userId);
		if(user.getUserMoney()>=price) {
			user.setUserMoney(user.getUserMoney()-price);
			userMapper.updateByPrimaryKeySelective(user);
			Userorder userorder=new Userorder();
			userorder.setOrderBookid(bookId);
			userorder.setOrderBookname(book.getBookName());
			userorder.setOrderBooknum(1);
			userorder.setOrderState(1);
			userorder.setOrderUserid(userId);
			userorderMapper.insertSelective(userorder);
			Example example=new Example(Store.class);
			Criteria criteria=example.createCriteria();
			criteria.andEqualTo("bookId", bookId);
			Store store=storeMapper.selectOneByExample(example);
			store.setStoreLeftnum(store.getStoreLeftnum()-1);
			store.setStoreMoney(store.getStoreMoney()+price);
			store.setStoreSalednum(store.getStoreSalednum()+1);
			storeMapper.updateByPrimaryKeySelective(store);	
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean book(int userId, int bookId) {
		Book book=bookMapper.selectByPrimaryKey(bookId);
		Float price=book.getBookPrice();
		User user=userMapper.selectByPrimaryKey(userId);
		Userorder userorder=new Userorder();
		userorder.setOrderBookid(bookId);
		userorder.setOrderBookname(book.getBookName());
		userorder.setOrderBooknum(1);
		userorder.setOrderState(0);
		userorder.setOrderUserid(userId);
		userorderMapper.insertSelective(userorder);
		return true;
	}
	@Override
	public boolean rebuy(int userId, int bookId,int orderId) {
		Book book=bookMapper.selectByPrimaryKey(bookId);
		Float price=book.getBookPrice();
		User user=userMapper.selectByPrimaryKey(userId);
		if(user.getUserMoney()>=price) {
			user.setUserMoney(user.getUserMoney()-price);
			userMapper.updateByPrimaryKeySelective(user);
			Userorder userorder=userorderMapper.selectByPrimaryKey(orderId);
			userorder.setOrderState(1);
			userorderMapper.updateByPrimaryKeySelective(userorder);
			Example example=new Example(Store.class);
			Criteria criteria=example.createCriteria();
			criteria.andEqualTo("bookId", bookId);
			Store store=storeMapper.selectOneByExample(example);
			store.setStoreLeftnum(store.getStoreLeftnum()-1);
			store.setStoreMoney(store.getStoreMoney()+price);
			store.setStoreSalednum(store.getStoreSalednum()+1);
			storeMapper.updateByPrimaryKeySelective(store);	
			return true;
		}else {
			return false;
		}
	}
	
}
