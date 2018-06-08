package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.example.demo.mapper.StoreMapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.Store;
import com.example.demo.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreMapper storeMapper;
	
	@Override
	public List<Store> getAllStores() {
		return storeMapper.selectAll();
	}

	@Override
	public Store getStoreById(int id) {
		Example example=new Example(Store.class);
		Criteria criteria=example.createCriteria();
		criteria.andEqualTo("storeId", id);
		Store store=storeMapper.selectOneByExample(example);
		return store;
	}

	@Override
	public void insert(Store store) {
		storeMapper.insert(store);
		
	}

	@Override
	public List<Store> getStoresByBookId(String bookId) {
		Example example=new Example(Store.class);
		Criteria criteria=example.createCriteria();
		criteria.andLike("bookId", "%"+bookId+"%");
		List<Store> stores=storeMapper.selectByExample(example);
		return stores;
	}

}
