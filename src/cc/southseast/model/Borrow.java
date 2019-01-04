package cc.southseast.model;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

import java.sql.Date;
import java.util.List;

/**
 * @Author: Southseast
 * @Date: 2019/1/4 12:01 AM
 * @Version 1.0
 */
@Table("borrow")
public class Borrow {

    @Id
    private long borrowId;

    private long id;

    private long bookId;

    private Date borrowDay;

    private Date returnDay;

    @One(field = "id")
    private User user;

    @One(field = "bookId")
    private Book book;

    public Borrow(long borrowId, long id, long bookId, Date borrowDay, Date returnDay) {
        this.borrowId = borrowId;
        this.id = id;
        this.bookId = bookId;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
    }

    public Borrow() {
    }

    public long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(long borrowId) {
        this.borrowId = borrowId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(Date borrowDay) {
        this.borrowDay = borrowDay;
    }

    public Date getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }
}
