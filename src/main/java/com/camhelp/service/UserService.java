package com.camhelp.service;

import com.camhelp.dataobject.User;
import com.camhelp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jupiter on 2017/7/23.
 */


public interface UserService {
     //查询id对应的用户
     User findOne(Integer id);
     //查询所有用户
     List<User> findAllUser();
     void SaveUser(User user);
     User findUserByAccount(String account);
     User findUserByNickname(String nickName);

     //更新操作
     void updatePasswordById(String password,int Id);

     void updateNicknameById(String nickname,int Id);

     void updateAddressById(String address,int Id);

     void updateAvatarById(String avatar,int Id);

     void updateBirthdayById(String birthday,int Id);

     void updateEmailById(String email,int Id);

     void updateIntroById(String intro,int Id);

     void updateSexById(String sex,int Id);

     void updateTelephoneById(String telephone,int Id);

}
