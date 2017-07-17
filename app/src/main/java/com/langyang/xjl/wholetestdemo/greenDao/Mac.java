package com.langyang.xjl.wholetestdemo.greenDao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Author : xjl
 * @Created : 2016-12-13
 * @E-mail : xvjialing@outlook.com
 * @Version : 1.0
 */
@Entity
public class Mac {
    @Id
    private Long id;
    private String mac;
    @Generated(hash = 834858486)
    public Mac(Long id, String mac) {
        this.id = id;
        this.mac = mac;
    }
    @Generated(hash = 1427882915)
    public Mac() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMac() {
        return this.mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    
}
