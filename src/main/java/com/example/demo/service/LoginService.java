package com.example.demo.service;

import com.example.demo.pojo.User;

public interface LoginService {
	public String getUserPass(String userId);
	public String getUserPassByName(String userName);
	public User getUserByName(String userName);
	public User getUserById(String userId);
	public void updateUser(String userId, String Money);
	public void addUser(User user);
}
