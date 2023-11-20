package com.exacto.cliAuthentication.service;

import java.util.List;

import com.exacto.cliAuthentication.entity.User;

public interface UserService {
	public User addUser(User user);
	public List<User> getUsers();
	public User getUser(long userid);
	public User updateUser(User user);
	public User deleteUser(long userId);
}
