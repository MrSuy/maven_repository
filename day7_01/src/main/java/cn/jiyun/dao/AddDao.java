package cn.jiyun.dao;

import cn.jiyun.pojo.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddDao extends JpaRepository<Address,Long> {

    @Query(value = "select a from Address a where aid=?1")
    List<Address> findByAid(Integer aid);

    @Query(value = "select a from Address a where sid=?1")
    Address findBySid(Long id);


}
