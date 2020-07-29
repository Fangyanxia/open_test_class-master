package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller

public class LoginController{
	
	@Autowired
	private userRepository userRepository;
	
	@RequestMapping(value={"/index","/"})
	public String index(){
		return index;
	}

	@RequestMapping (value="login",method=RequestMethod.POST)
	public STRING signin(User user){
		Strign username = user.getUsername();
		List<User> userList = userRepository.findByusername(username);
		if(uerList.size()!=0){
		User user1 = userList.get(0);
		switch (user1.getTab()){
			case 0:
				if(user1.getPassword().equals(user.getPassword())){
					return "admin";
				}else{
					break;
				}
 			case 1:
				if(user1.getPassword().equals(user.getPassword())){
					return "teacher";
				}else{
					break;
				}							
			case 2:
				if(user1.getPassword().equals(user.getPassword())){
					return "student";
				}else{
					break;
				}
			default:
				break;	
			}

			}
		return "index";
		}

	}
