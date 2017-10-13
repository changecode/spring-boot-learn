package com.springboot.mongo;

import java.util.List;

/**
 * Created by WIN on 2017/10/13.
 *  MongoRepository<Customer, Integer> 第一个参数：T 操作的vo 第二个参数：ID T的主键类型 该接口实现了CRUD方法
 * findBySecondname命名是有讲究的，Secondname（是Customer的属性）若改为lastname就会报找不到属性lastname的错误
 */
public interface CustomerRepository  { //extends MongoRepository<Customer, String>
    public Customer findByFirstname(String firstname);
    public List<Customer> findBySecondname(String secondname);
}
