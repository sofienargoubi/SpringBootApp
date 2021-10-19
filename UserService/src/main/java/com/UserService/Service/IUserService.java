package com.UserService.Service;

import java.util.List;

import com.UserService.Entity.User;





public interface IUserService {
	
	public Long register(User user);
	public List<User> getAllUsers();

}
