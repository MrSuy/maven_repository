package cn.jiyun.service;

import cn.jiyun.dao.AddDao;
import cn.jiyun.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddServuceimp implements AddServuce{
    @Autowired
    private AddDao addDao;

    @Override
    public Address findBySid(Long shengid) {

        return addDao.findBySid(shengid);

    }
}
