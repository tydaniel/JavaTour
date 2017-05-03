package net.tydaniel.spring.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author xiaojunp
 *
 */
@Entity
@Table(name="BORROWINFO")
public class BorrowInfo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="userid")
	private int userID;
	
	@ManyToOne(targetEntity=User.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="userid", referencedColumnName="id", insertable=false, updatable=false)
	@JsonIgnore 
	private User users;
	
	@Column(name="bookid")
	private int bookID;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="bookid", insertable=false, updatable=false)
	@JsonIgnore
	private Book books;
	
	@Column(name="borrowdate")
	private Timestamp borrowDate;
	
	@Column(name="returndate")
	private Timestamp returnDate;
	
	@Column(name="returnflag")
	private int returnFlag;
	
	@Column(name="expireflag")
	private int expireFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
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

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Book getBooks() {
		return books;
	}

	public void setBooks(Book books) {
		this.books = books;
	}
	
}
