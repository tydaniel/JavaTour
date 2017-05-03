package net.tydaniel.spring.dao;

import java.util.List;

import net.tydaniel.spring.model.Book;

public interface BookDAO {
	public void addBook(Book p);
	public void updateBook(Book p);
	public List<Book> listBooks();
	public Book getBookById(int id);
	public void removeBook(int id);
}
