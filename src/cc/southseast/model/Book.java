package cc.southseast.model;

import org.nutz.dao.entity.annotation.*;

import java.sql.Date;
import java.util.List;

@Table("book")
public class Book {


    @Id(auto=false)
    // 书号
    private long bookId;

    // 书名
    private String bookName;

    // 价格
    private double bookPrice;

    // 作者
    private String writer;

    private long publishId;

    private Boolean isCheck;

    @ManyMany(relation = "b_user_book", from = "bookId", to = "id")
    private List<User> user;

    @One(field = "publishId")
    public Publish publish;

    public Book() {
    }

    public Book(long bookId, String bookName, double bookPrice, String writer, long publishId, Boolean isCheck, List<User> user, Publish publish) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.writer = writer;
        this.publishId = publishId;
        this.isCheck = isCheck;
        this.user = user;
        this.publish = publish;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public long getPublishId() {
        return publishId;
    }

    public void setPublishId(long publishId) {
        this.publishId = publishId;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Publish getPublish() {
        return publish;
    }

    public void setPublish(Publish publish) {
        this.publish = publish;
    }
}


