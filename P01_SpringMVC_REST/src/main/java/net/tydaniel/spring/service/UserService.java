package net.tydaniel.spring.service;

import java.util.List;

import net.tydaniel.spring.model.User;
import net.tydaniel.spring.model.vo.UserBorrowedBookVO;

public interface UserService {
	public void addUser(User p);
	public void updateUser(User p);
	public List<User> listUsers();
	public User getUserById(int id);	
	public void removeUser(int id);	
	public List<UserBorrowedBookVO> getUserBorrowed(int id);
}
