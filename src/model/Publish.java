package model;

import org.nutz.dao.entity.annotation.*;

@Table("publish")
public class Publish {

    @Id
    // 出版社编号
    private int id;

    // 出版社
    private String name;

    public Publish() {
    }

    public Publish(int id, String name) {
        this.id = id;
        this.name = name;
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

}
