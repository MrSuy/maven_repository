package cn.jiyun.service;

import cn.jiyun.pojo.Address;

import java.util.Optional;

public interface AddServuce {
    Address findBySid(Long shengid);

}
