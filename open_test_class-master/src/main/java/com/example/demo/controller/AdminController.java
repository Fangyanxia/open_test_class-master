package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AdminController{
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/admin/addUser")
	public String addUser(User user){
		userRepository.save(user);
		return "success";
	}
	@RequestMapping("/admin/deleteUser")
	public String deleteUser(User user){
		userRepository.delete(user);
		return "success";
	}
	@RequestMapping("/admin/updateUser")
	public String updateUser(User user){
		userRepository.save(user);
		return "success";
	}

}