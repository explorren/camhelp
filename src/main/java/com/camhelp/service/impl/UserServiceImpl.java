package com.camhelp.service.impl;

import com.camhelp.dataobject.User;
import com.camhelp.repository.UserRepository;
import com.camhelp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
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


    @Override
    @Transactional
    public void updatePasswordById(String password,int id){
        userRepository.updatePasswordById(password,id);
    }

    @Override
    @Transactional
    public void updateNicknameById(String nickname, int id) {
        userRepository.updateNicknameById(nickname, id);
    }

    @Override
    @Transactional
    public void updateAddressById(String address, int id) {
        userRepository.updateAddressById(address,id);
    }

    @Override
    @Transactional
    public void updateAvatarById(String avatar, int id) {
        userRepository.updateAvatarById(avatar,id);
    }

    @Override
    @Transactional
    public void updateBirthdayById(String birthday, int id) {
        userRepository.updateBirthdayById(birthday,id);
    }

    @Override
    @Transactional
    public void updateEmailById(String email, int id) {
       userRepository.updateEmailById(email,id);
    }

    @Override
    @Transactional
    public void updateIntroById(String intro, int id) {
        userRepository.updateIntroById(intro,id);
    }

    @Override
    @Transactional
    public void updateSexById(String sex, int id) {
        userRepository.updateSexById(sex,id);
    }

    @Override
    @Transactional
    public void updateTelephoneById(String telephone, int id) {
        userRepository.updateTelephoneById(telephone, id);
    }

}
