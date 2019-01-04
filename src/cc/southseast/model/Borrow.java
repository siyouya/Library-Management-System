package cc.southseast.model;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

import java.sql.Date;
import java.time.LocalDate;

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

    private Boolean isCheck;

    @One(field = "id")
    private User user;

    @One(field = "bookId")
    private Book book;

    public Borrow() {
    }

    public Borrow(long borrowId, long id, long bookId, Date borrowDay, Date returnDay, Boolean isCheck, User user, Book book) {
        this.borrowId = borrowId;
        this.id = id;
        this.bookId = bookId;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
        this.isCheck = isCheck;
        this.user = user;
        this.book = book;
    }

    public long getBorrowId() {
        return borrowId;
    }

//    public void setBorrowId(long borrowId) {
//        this.borrowId = borrowId;
//    }

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

    public LocalDate getBorrowDay() {
        return borrowDay.toLocalDate();
    }

    public void setBorrowDay(Date borrowDay) {
        this.borrowDay = borrowDay;
    }

    public LocalDate getReturnDay() {
        return returnDay.toLocalDate();
    }

    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
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
}
