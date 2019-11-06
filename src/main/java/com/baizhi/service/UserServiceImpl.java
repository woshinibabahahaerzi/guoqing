package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void regist(User user) {
        User user1 = userDao.selectOne(user.getUsername());
        if(user1!=null){
            throw new RuntimeException("该用户已存在");
        }else{
            user.setStatus("激活");
            user.setRole("普通用户");
            userDao.insert(user);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public User login(User user) {
        User selectOne = userDao.selectOne(user.getUsername());
        if (selectOne==null)throw new RuntimeException("该用户不存在");
        if(!user.getPassword().equals(selectOne.getPassword()))throw new RuntimeException("密码错误");
        System.out.println(selectOne.getRole()+"qqqqqqq");
        System.out.println(user.getRole());
        if(!selectOne.getRole().equals(user.getRole()))throw new RuntimeException("身份信息错误");

        return selectOne;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<User> showAllUser() {
        List<User> list = userDao.queryAll();

        return list;
    }

    @Override
    public void update(User user) {
        if(user.getStatus().equals(null)){
            userDao.update(user);
        }else {
            if(user.getStatus().equals("激活")){
                user.setStatus("冻结");
            }else {
                user.setStatus("激活");
            }
            userDao.update(user);
        }
    }

    @Override
    public void delete(String username) {
        userDao.delete(username);
    }

    @Override
    public void addUser(User user) {
        user.setRole("普通用户");
        userDao.insert(user);
    }

    @Override
    public List<User> selectByNameOneUser(String username) {
        List<User> list = userDao.queryUser("%"+username+"%");
        return list;
    }

    @Override
    public User selectOneInfo(String username) {
        User user = userDao.selectOne(username);
        return user;
    }

    @Override
    public void updateOneInfo(User user) {
        userDao.update(user);
    }

}
