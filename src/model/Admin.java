package model;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

@Table("admin")
public class Admin {

    @Id
    private int id;

    private String name;

    private String password;

    private String studentId;

    private String sex;

    private Date birthday;

    private String telphone;

    private String email;

    public Admin() {
    }

    public Admin(String name, String password, String studentId, String sex, Date birthday, String telphone, String email) {
        this.name = name;
        this.password = password;
        this.studentId = studentId;
        this.sex = sex;
        this.birthday = birthday;
        this.telphone = telphone;
        this.email = email;
    }

    public long getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
