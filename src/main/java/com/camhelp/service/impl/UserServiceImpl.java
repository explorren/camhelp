package com.camhelp.service.impl;

import com.camhelp.dataobject.User;
import com.camhelp.repository.UserRepository;
import com.camhelp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Jupiter on 2017/7/24.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Transactional
    @Override
    public void SaveUser(User user){
        if(userRepository.findByAccount(user.getAccount())==null) {
            userRepository.save(user);
        }
    }
    @Transactional
    @Override
    public User findUserByAccount(String account){
        return userRepository.findByAccount(account);
    }
    @Transactional
    @Override
    public User findUserByNickname(String nickName){
        return userRepository.findByNickname(nickName);
    }
    @Transactional
    @Override
    public void updatePasswordById(String password,int id){
        userRepository.updatePasswordById(password,id);
    }

}
