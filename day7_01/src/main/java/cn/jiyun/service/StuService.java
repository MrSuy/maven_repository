package cn.jiyun.service;

import cn.jiyun.pojo.Address;
import cn.jiyun.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface StuService {
    Page<Student> findStuByPage(String name, Date birthday,String addres,Pageable pageable);

    void toDel(Long id);

    List<Address> findByAid(Integer aid);

    void add(Student student);

    Student findByid(Long id);

    void update(Student student);

    Integer findBySex(String n);
}
