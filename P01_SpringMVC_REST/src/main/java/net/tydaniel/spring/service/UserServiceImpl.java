package net.tydaniel.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.tydaniel.spring.dao.UserDAO;
import net.tydaniel.spring.model.User;
import net.tydaniel.spring.model.vo.UserBookVO;
import net.tydaniel.spring.model.vo.UserBorrowedBookVO;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addUser(User p) {
		this.userDAO.addUser(p);
	}

	@Override
	@Transactional
	public void updateUser(User p) {
		this.userDAO.updateUser(p);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		logger.info("Service id =" + id);
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(int id) {		
		this.userDAO.removeUser(id);
	}

	@Override
	@Transactional
	public List<UserBorrowedBookVO> getUserBorrowed(int id) {
		return this.userDAO.getUserBorrowed(id);
	}

	@Override
	@Transactional
	public List<UserBookVO> getUserBook() {
		return this.userDAO.getUserBook();
	}
}
