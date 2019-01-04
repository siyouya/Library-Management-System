package cc.southseast.model;

import org.nutz.dao.entity.annotation.*;

@Table("publish")
public class Publish {


    @Id(auto=false)
    // 出版社编号
    private long publishId;

    // 出版社
    private String publishName;

    private String publishPhone;

    private Boolean isCheck;

    public Publish(long publishId, String publishName, String publishPhone, Boolean isCheck) {
        this.publishId = publishId;
        this.publishName = publishName;
        this.publishPhone = publishPhone;
        this.isCheck = isCheck;
    }

    public Publish() {
    }

    public long getPublishId() {
        return publishId;
    }

    public void setPublishId(long publishId) {
        this.publishId = publishId;
    }

    public String getPublishName() { return publishName; }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public String getPublishPhone() {
        return publishPhone;
    }

    public void setPublishPhone(String publishPhone) { this.publishPhone = publishPhone; }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }
}
