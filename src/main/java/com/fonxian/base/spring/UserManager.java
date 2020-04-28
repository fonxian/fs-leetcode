package com.fonxian.base.spring;

/**
 * @author Michael Fang
 * @since 2020-04-02
 */
public interface UserManager {

    //新增用户抽象方法
    void addUser(String userName,String password);
    //删除用户抽象方法
    void delUser(String userName);

}
