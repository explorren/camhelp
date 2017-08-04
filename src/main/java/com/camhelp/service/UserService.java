package com.camhelp.service;

import com.camhelp.dataobject.User;
import com.camhelp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jupiter on 2017/7/23.
 */


public interface UserService {
     User findOne(Integer id);
     void SaveUser(User user);
     User findUserByAccount(String account);
     User findUserByNickname(String nickName);
     void updatePasswordById(String password,int Id);
}
