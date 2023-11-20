package com.exacto.cliAuthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exacto.cliAuthentication.entity.User;
import com.exacto.cliAuthentication.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
    @Autowired
	private UserService userService;
	
	@PostMapping("/app/hello1")
	public User addUser(@RequestBody User user) {
		
		return this.userService.addUser(user);
	}   


	@GetMapping("/users")
	public List<User> getUsers(){
		System.out.println("Inside here Getusers");
		return this.userService.getUsers();
	}
	 
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable String userId) {
			return this.userService.getUser(Long.parseLong(userId));
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
			return this.userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{userId}")
	public User deleteUser(@PathVariable String userId) {
			return this.userService.deleteUser(Long.parseLong(userId));
	}  
}
