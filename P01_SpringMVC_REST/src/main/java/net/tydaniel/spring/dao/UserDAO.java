package net.tydaniel.spring.dao;

import java.util.List;

import net.tydaniel.spring.model.User;
import net.tydaniel.spring.model.vo.UserBookVO;
import net.tydaniel.spring.model.vo.UserBorrowedBookVO;

public interface UserDAO {
	public void addUser(User p);
	public void updateUser(User p);
	public List<User> listUsers();
	public User getUserById(int id);
	public void removeUser(int id);
	public List<UserBorrowedBookVO> getUserBorrowed(int id);	
	public List<UserBookVO> getUserBook();
}
