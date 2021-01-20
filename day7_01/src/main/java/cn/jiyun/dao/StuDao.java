package cn.jiyun.dao;

import cn.jiyun.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface StuDao extends JpaRepository<Student,Long>{

    @Query(nativeQuery = true,value = "select * from student where (?1 is null or name like %?1%) "
            + " and (?2 is null or birthday=?2) and (?3 is null or addres like %?3%)",
            countQuery = "select count(*) from student where (?1 is null or name like %?1%) "
                    + " and (?2 is null or birthday=?2) and (?3 is null or addres like %?3%)")
   /* @Query(value = "select a from Student a where (?1 is null or name like %?1%) and (?2 is null or birthday=?2) and (?3 is null or addres like %?3%)")*/
    Page<Student> findStuByPage(String name, Date birthday,String addres,Pageable pageable);

    @Query(value = "select a from Student a where id=?1")
    Student findByIds(Long id);

    @Query(value = "select count(id) from Student where sex=?1 group by sex")
    Integer findBySex(String sex);
}
