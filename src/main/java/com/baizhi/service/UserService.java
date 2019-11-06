package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //注册
    public void regist(User user);
    //登录
    public User login(User user);
    //展示用户
    public List<User> showAllUser();
    //修改状态
    public void update(User user);
    //删除
    public void delete(String username);
    //addUser
    public void addUser(User user);
    //模糊查询一个人
    public List<User> selectByNameOneUser(String username);
    //查一个人信息
    public User selectOneInfo(String username);
    //修改其它
    public void updateOneInfo(User user);
}
