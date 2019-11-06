package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDao {
    //添加用户
    public void insert(User user);
    //删除用户
    public void delete(String username);
    //修改用户
    public void update(User user);
    //查单个用户   用于登录  普通用户登录后展示
    public User selectOne(String username);
    //管理员登录 查所有用户
    public List<User> queryAll();
    //模糊哈寻一个人
    public List<User> queryUser(String username);

}
