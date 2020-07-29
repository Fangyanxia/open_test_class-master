package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * user
 *
 * @author fyx
 * @date 2020/07/26
 *
 */
@Entity
@Table(name="user")

public class User{
	@Id
	@GeneratedValue
	private Long id;
	public Integer getTab(){
		retrun tab;
	} 
	public void setTab(Integer tab) {
        	this.tab = tab;
    	}
	//标记 0 为管理员 1为老师 2为学生
    	private Integer tab;
	@Column(length=32)
	private String username;
	@Column(length=64)
	private String password;
  	
 	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id=id;
	}

	public String username(){
		return username();
	}
	public void setUsername(String username){
		this.username=username;
	}
  	public String getPassword() {
        	return password;
    	}

    	public void setPassword(String password) {
        	this.password = password;
    	}
}












}