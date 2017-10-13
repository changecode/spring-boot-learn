package com.springboot.mongo;

/**
 * Created by WIN on 2017/10/13.
 */
public class Customer {

//    @Id
    private String cid; //用于mongodb的"_id"索引, 如果定义为Integer可能索引只会是0，会出现key重复导致数据库插不进去的情况
    private String firstname;
    private String secondname;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
}
