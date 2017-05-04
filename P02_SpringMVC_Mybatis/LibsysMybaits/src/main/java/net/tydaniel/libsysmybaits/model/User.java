package net.tydaniel.libsysmybaits.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class User implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;
	
	@TableId(type = IdType.AUTO)
	@JsonIgnore
	private int id;
	
	@TableField(value = "username")
	private String username;
	
	@TableField(value = "password")
	@JsonIgnore
	private String password;
	
	@TableField(value = "name")
	private String name;
	
	@TableField(value = "address")
	private String address;
	
	@TableField(value = "mobile")
	private String mobile;
	
	@TableField(value = "maxborrow")
	private int maxborrow;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getMaxborrow() {
		return maxborrow;
	}

	public void setMaxborrow(int maxborrow) {
		this.maxborrow = maxborrow;
	}
}
