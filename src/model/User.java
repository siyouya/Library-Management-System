package model;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.text.DateFormat;
import java.util.Date;

@Table("user")
public class User{

    @Id
    private long id;

    private String studentId;

    private String name;

    private String password;

    private String sex;

    private Date birthday;

    private String telphone;

    private String email;

    public User() {
    }

    public User(String studentId, String name, String password, String sex, Date birthday, String telphone, String email) {
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

    public String getBirthday() {
        DateFormat returnYear = DateFormat.getDateInstance();
        return returnYear.format(birthday); }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", studentId='" + studentId + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}