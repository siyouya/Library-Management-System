package cc.southseast.model;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

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

    public User() {
    }

    public User(long id, String name, String password, String sex, Date birthday, String telphone, String email, Boolean isCheck) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.telphone = telphone;
        this.email = email;
        this.isCheck = isCheck;
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

    public LocalDate getBirthday() {
//        Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        Instant birthdayInstant = birthday.toInstant();
//        ZoneId zoneId = ZoneId.systemDefault();
//
//        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
//        LocalDate birthdayLocalDate = birthdayInstant.atZone(zoneId).toLocalDate();
        return birthday.toLocalDate();
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

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }
}