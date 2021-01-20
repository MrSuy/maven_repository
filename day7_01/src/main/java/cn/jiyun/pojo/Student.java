package cn.jiyun.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Long id;
    private String name;
    private String sex;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Long shengid;
    private Long shiid;
    private String juti;
    private String sheng;
    private String shi;
    private Long xianid;
    private String xian;
    private String addres;

    public Long getXianid() {
        return xianid;
    }

    public void setXianid(Long xianid) {
        this.xianid = xianid;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddress(String addres) {
        this.addres = addres;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", shengid=" + shengid +
                ", shiid=" + shiid +
                ", juti='" + juti + '\'' +
                ", sheng='" + sheng + '\'' +
                ", shi='" + shi + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(Long id, String name, String sex, Integer age, Date birthday, Long shengid, Long shiid, String juti, String sheng, String shi) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.shengid = shengid;
        this.shiid = shiid;
        this.juti = juti;
        this.sheng = sheng;
        this.shi = shi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getShengid() {
        return shengid;
    }

    public void setShengid(Long shengid) {
        this.shengid = shengid;
    }

    public Long getShiid() {
        return shiid;
    }

    public void setShiid(Long shiid) {
        this.shiid = shiid;
    }

    public String getJuti() {
        return juti;
    }

    public void setJuti(String juti) {
        this.juti = juti;
    }

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }
}
