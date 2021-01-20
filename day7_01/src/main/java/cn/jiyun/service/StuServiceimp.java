package cn.jiyun.service;

import cn.jiyun.dao.AddDao;
import cn.jiyun.dao.StuDao;
import cn.jiyun.pojo.Address;
import cn.jiyun.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StuServiceimp implements StuService{
    @Autowired
    private StuDao stuDao;
    @Autowired
    private AddDao addDao;

    @Override
    public Page<Student> findStuByPage(String name, Date birthday,String addres,Pageable pageable) {

        return stuDao.findStuByPage(name,birthday,addres,pageable);
    }

    @Override
    public void toDel(Long id) {
        stuDao.deleteById(id);
    }

    @Override
    public List<Address> findByAid(Integer aid) {

        return addDao.findByAid(aid);
    }

    @Override
    public void add(Student student) {
        stuDao.save(student);
    }

    @Override
    public Student findByid(Long id) {
        return stuDao.findByIds(id);
    }

    @Override
    public void update(Student student) {
        stuDao.save(student);
    }

    @Override
    public Integer findBySex(String sex) {
        return stuDao.findBySex(sex);
    }


}
