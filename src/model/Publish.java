package model;

import org.nutz.dao.entity.annotation.*;

@Table("publish")
public class Publish {

    @Id
    private int id;

    // 出版社编号
    private String number;

    // 出版社
    private String name;

    private String telphone;

    private String address;

    private String boss;

    public Publish() {
    }

    public Publish(String number, String name, String telphone, String address, String boss) {
        this.number = number;
        this.name = name;
        this.telphone = telphone;
        this.address = address;
        this.boss = boss;
    }

    public long getId() {
        return id;
    }

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

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }
}
