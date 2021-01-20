package cn.jiyun.pojo;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Long sid;
    private Integer aid;
    private String aname;

    @Override
    public String toString() {
        return "Address{" +
                "sid=" + sid +
                ", aid=" + aid +
                ", aname='" + aname + '\'' +
                '}';
    }

    public Address() {
    }

    public Address(Long sid, Integer aid, String aname) {
        this.sid = sid;
        this.aid = aid;
        this.aname = aname;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
}
