package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("login")
public class UserAction {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //注册
    @RequestMapping("/regist")
    public String regist(User user, Model model) throws Exception{

       try {
           userService.regist(user);
           return "redirect:/login.jsp";
       }catch (Exception e){
           String message = e.getMessage();
           model.addAttribute("message",message);
           return "userRegist";
       }
    }


    //denglu
    @RequestMapping("/login")
    public String login(User user ,Model model)throws Exception{
        try {
            User login = userService.login(user);

            model.addAttribute("login",login);
            if(login.getRole().equals("普通用户")) {
                return "userlist";
            }else {
               return "redirect:/show.do";
            }
        }catch (Exception e){
            String message = e.getMessage();
            model.addAttribute("message",message);
            return "login";
        }

    }
    //退出
    @RequestMapping("/exit")
    public String exit(HttpSession session)throws Exception{
        session.removeAttribute("login");

        return "redirect:/login.jsp";
    }
    //展示所有
    @RequestMapping("/show")
    public String show(Model model)throws Exception{
        List<User> list = userService.showAllUser();
        model.addAttribute("list",list);
        return "admin";
    }
    //修改
    @RequestMapping("/update")
    public String update(User user){

        userService.update(user);
        return "redirect:/show.do";
    }
    //delete
    @RequestMapping("/delete")
    public String deleteUser(String username)throws Exception{

        userService.delete(username);
        return "redirect:/show.do";
    }
    //addUser
    @RequestMapping("/add")
    public String addUser(User user){

        userService.addUser(user);
        return "redirect:/show.do";
    }
    //模糊查询
    @RequestMapping("/selectByname")
    public String selectOneByName(User user,Model model){

        List<User> list = userService.selectByNameOneUser(user.getUsername());
        model.addAttribute("list",list);

        return "admin";
    }
    //查一个人具体信息
    @RequestMapping("/selectOneInfo")
    @ResponseBody
    public User selectOneInfo(String username)throws Exception{
        User user = userService.selectOneInfo(username);

        return user;
    }
    //修改其他信息
    @RequestMapping("/updateInfo")
    public String updateinfo(User user)throws Exception{
        System.out.println("1111111111"+user);
        userService.updateOneInfo(user);
        return "redirect:/show.do";
    }

}
