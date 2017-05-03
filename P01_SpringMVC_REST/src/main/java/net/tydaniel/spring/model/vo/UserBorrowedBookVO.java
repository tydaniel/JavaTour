package net.tydaniel.spring.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.tydaniel.spring.util.JsonDateSerializer;
import net.tydaniel.spring.util.StringConverter;

public class UserBorrowedBookVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserBorrowedBookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserBorrowedBookVO(String username, String bookname, String bookauthor, String bookpublishing,
			String bookclassType, Object borrowDate, Object returnDate, int returnFlag, int expireFlag) {
		super();
		this.username = username;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
		this.bookpublishing = bookpublishing;
		this.bookclassType = bookclassType;
		this.borrowDate = StringConverter.stringToTimeStamp(borrowDate.toString());
		this.returnDate = StringConverter.stringToTimeStamp(returnDate.toString());
		this.returnFlag = returnFlag;
		this.expireFlag = expireFlag;
	}
	
	

	private String username;
	
	private String bookname;
	
	private String bookauthor;
	
	private String bookpublishing;
	
	private String bookclassType;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Timestamp borrowDate;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Timestamp returnDate;
	private int returnFlag;
	private int expireFlag;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getBookpublishing() {
		return bookpublishing;
	}
	public void setBookpublishing(String bookpublishing) {
		this.bookpublishing = bookpublishing;
	}
	public String getBookclassType() {
		return bookclassType;
	}
	public void setBookclassType(String bookclassType) {
		this.bookclassType = bookclassType;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
