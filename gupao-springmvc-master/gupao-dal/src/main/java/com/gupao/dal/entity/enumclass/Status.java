package com.gupao.dal.entity.enumclass;

/**
 * Created by 中国第一美男子 on 2018/3/7.
 * 帅哥,写点注释哦!!
 */
public enum  Status {

    A("可用"),B("锁定"),C("删除");
    private String status;
    Status(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
