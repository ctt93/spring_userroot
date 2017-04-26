package com.dao;

import java.util.List;

import com.model.Pager;
import com.model.User;

public interface IUserDao {
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public List<User> list();
	public Pager<User> find();
	public User loadByUsername(String username);
}
