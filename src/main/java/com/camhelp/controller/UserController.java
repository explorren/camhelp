package com.camhelp.controller;

import com.camhelp.dataobject.User;
import com.camhelp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Jupiter on 2017/7/23.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/find/{id}")
    public String  FindOne(@PathVariable("id") Integer id){
        return userService.findOne(id).toString();
    }

    @RequestMapping("/login")
    public String  Login(@RequestParam("account") String account,@RequestParam("password") String password) throws Exception{

        User user=userService.findUserByAccount(account);
        if(account==null){

            return "1";
        }else if(!user.getPassword().equals(password)){
            return "2";

        }else if (user.getPassword().equals(password)){
             return "登陆成功！";
        }

        return "???";
    }

    @RequestMapping("register")
    public void Register(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
              System.out.println("???");
        }
        user.setAvatar(user.getAvatar());

        userService.SaveUser(user);
    }
}
