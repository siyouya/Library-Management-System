package cc.southseast.model;

import org.nutz.dao.entity.annotation.*;

@Table("book")
public class Book {

    @Id
    private int id;

    // 书号
    private String number;

    // 书名
    private String name;

    // 价格
    private double price;

    // 作者
    private String writer;

    // 出版日期
    private String publishDate;

    private String publish;

    public Book() {
    }

    public Book(String number, String name, double price, String writer, String publishDate, String publish) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.writer = writer;
        this.publishDate = publishDate;
        this.publish = publish;
    }

    public long getId() { return id; }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }
}


