package cc.southseast.model;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
import java.sql.Date;
import java.time.LocalDate;

@Table("user")
public class User{

    @Id(auto=false)
    private long id;

    private String name;

    private String password;

    private String sex;

    private Date birthday;

    private String telphone;

    private String email;

    private Boolean isCheck;

    private Boolean isAdmin;

    public User(long id, String name, String password, String sex, Date birthday, String telphone, String email, Boolean isCheck, Boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.telphone = telphone;
        this.email = email;
        this.isCheck = isCheck;
        this.isAdmin = isAdmin;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() { return birthday.toLocalDate(); }

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

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public Boolean getAdmin() { return isAdmin; }

    public void setAdmin(Boolean admin) { isAdmin = admin; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                ", isCheck=" + isCheck +
                ", isAdmin=" + isAdmin +
                '}';
    }
}