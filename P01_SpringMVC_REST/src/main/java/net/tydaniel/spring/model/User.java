package net.tydaniel.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author xiaojunp
 *
 */
@Entity
@Table(name="USER")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="users")
	@JsonIgnore
	private Set<BorrowInfo> userBorrowInfo;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	@JsonIgnore
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="maxborrow")
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

	@OneToMany(targetEntity=BorrowInfo.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="id", referencedColumnName="userid")
	public Set<BorrowInfo> getUserBorrowInfo() {
		return userBorrowInfo;
	}

	public void setUserBorrowInfo(Set<BorrowInfo> userBorrowInfo) {
		this.userBorrowInfo = userBorrowInfo;
	}
	
}
