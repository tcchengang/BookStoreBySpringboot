package com.example.demo.service;

public interface ActionService {
	public boolean buy(int userId, int bookId);
	public boolean book(int userId,int bookId);
	public boolean rebuy(int userId, int bookId, int orderId);
}
