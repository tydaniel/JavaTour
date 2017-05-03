package net.tydaniel.spring.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.tydaniel.spring.model.Book;
import net.tydaniel.spring.model.User;
import net.tydaniel.spring.util.JsonDateSerializer;
import net.tydaniel.spring.util.StringConverter;

public class UserBookVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private Book book;
		
	@JsonSerialize(using=JsonDateSerializer.class)
	private Timestamp borrowDate;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Timestamp returnDate;
	private int returnFlag;
	private int expireFlag;
	
	
	
	
	public UserBookVO(User user, Book book, Object borrowDate, Object returnDate, int returnFlag,
			int expireFlag) {
		super();
		this.user = user;
		this.book = book;
		this.borrowDate = StringConverter.stringToTimeStamp(borrowDate.toString());
		this.returnDate = StringConverter.stringToTimeStamp(returnDate.toString());
		this.returnFlag = returnFlag;
		this.expireFlag = expireFlag;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Timestamp getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Timestamp borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Timestamp getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}
	public int getReturnFlag() {
		return returnFlag;
	}
	public void setReturnFlag(int returnFlag) {
		this.returnFlag = returnFlag;
	}
	public int getExpireFlag() {
		return expireFlag;
	}
	public void setExpireFlag(int expireFlag) {
		this.expireFlag = expireFlag;
	}
}
