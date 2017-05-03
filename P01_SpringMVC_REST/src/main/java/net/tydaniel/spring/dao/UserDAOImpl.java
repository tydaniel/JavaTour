package net.tydaniel.spring.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import net.tydaniel.spring.model.BorrowInfo;
import net.tydaniel.spring.model.User;
import net.tydaniel.spring.model.vo.UserBorrowedBookVO;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
	    session.persist(p);
		logger.info("User saved successfully, User Details="+p);		
	}

	@Override
	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("User updated successfully, User Details="+p);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		for(User p : userList){
			logger.info("User List::"+p);
		}
		return userList;
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) session.get(User.class, new Integer(id));
		logger.info("User loaded successfully, User details="+p);
		return p;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.get(User.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("User deleted successfully, User details="+p);		
	}

	@Override
	public List<UserBorrowedBookVO> getUserBorrowed(int id) {		
		Session session = this.sessionFactory.getCurrentSession();
//		List<BorrowInfo> rtnList = new ArrayList<BorrowInfo>();
//		User p = (User) session.get(User.class, new Integer(id));
//		logger.info("User loaded successfully, User details="+p);
//		rtnList.addAll(p.getUserBorrowInfo());
//		return rtnList;
		String sql = "SELECT new net.tydaniel.spring.model.vo.UserBorrowedBookVO(u.name, b.name, b.author, b.publishing, b.classType, bi.borrowDate, bi.returnDate, bi.returnFlag, bi.expireFlag) FROM User u, Book b, BorrowInfo bi WHERE u.id=bi.userID AND bi.bookID=b.id";
		List<UserBorrowedBookVO> rtnList = session.createQuery(sql).list();
		return rtnList;
	}

	
}
