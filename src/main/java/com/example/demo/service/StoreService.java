package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Store;

public interface StoreService {
	public List<Store> getAllStores();
	public Store getStoreById(int id);
	public void insert(Store store);
	public List<Store> getStoresByBookId(String bookId);
}
