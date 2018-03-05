package com.ws.juxtarem.dao;

import com.ws.juxtarem.obj.User;

public interface UserDao {
	public long saveUser(User user);
	public User findUserByMail(String mail);
}
