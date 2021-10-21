package com.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserService.Entity.User;
import com.UserService.Service.IUserService;




@RestController
@RequestMapping("/api/test")
public class UserController {
	
	
	@Autowired
	IUserService userService;

	@GetMapping("/users")
	public String get() {
		return "Public Content.";
	}
	
	@PostMapping("/register")
	@ResponseBody
	public User register(@RequestBody User user)
	{
		userService.register(user);
		return user;
	}
	
	@GetMapping("/Users")
	@ResponseBody
	public List<User> getAllUsers() {
			
		return userService.getAllUsers();
	}
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('SELLER') or hasRole('BUYER')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/buyer")
	@PreAuthorize("hasRole('BUYER')")
	public String buyerAccess() {
		return "buyer Board.";
	}
	@GetMapping("/seller")
	@PreAuthorize("hasRole('SELLER')")
	public String sellerAccess() {
		return "seller Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

}
