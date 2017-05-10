package net.tydaniel.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 借阅信息明细
 * </p>
 *
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
public class Borrowinfo extends Model<Borrowinfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 借阅用户ID
     */
	private Long userid;
    /**
     * 借阅图书ID
     */
	private Long bookid;
    /**
     * 借阅时间
     */
	private Date borrowdate;
    /**
     * 归还时间
     */
	private Date returndate;
    /**
     * 归还状态标志
     */
	private Integer returnflag;
    /**
     * 过期状态标志
     */
	private Integer expireflag;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public Date getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public Integer getReturnflag() {
		return returnflag;
	}

	public void setReturnflag(Integer returnflag) {
		this.returnflag = returnflag;
	}

	public Integer getExpireflag() {
		return expireflag;
	}

	public void setExpireflag(Integer expireflag) {
		this.expireflag = expireflag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
