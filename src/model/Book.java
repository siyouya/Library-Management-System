package model;

import org.nutz.dao.entity.annotation.*;

@Table("book")
public class Book {

    @Id
    // 书号
    private int id;

    // 书名
    private String name;

    // 价格
    private double price;

    // 作者
    private String writer;

    // 出版日期
    private String publishDate;

    public Book(int id, String name, double price, String writer, String publishDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.writer = writer;
        this.publishDate = publishDate;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}


