package net.tydaniel.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 图书
 * </p>
 *
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
public class Book extends Model<Book> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 书名
     */
	private String name;
    /**
     * 作者
     */
	private String author;
    /**
     * 出版社
     */
	private String publishing;
    /**
     * 图书分类
     */
	private String classtype;
    /**
     * 图书ISBN编号
     */
	@TableField("ISBN")
	private String isbn;
    /**
     * 库存量
     */
	private Integer total;
    /**
     * 已借数量
     */
	private Integer borrowed;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public String getClasstype() {
		return classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(Integer borrowed) {
		this.borrowed = borrowed;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
