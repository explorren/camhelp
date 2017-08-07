package com.camhelp.repository;

import com.camhelp.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Created by Jupiter on 2017/7/22.
 */
public interface UserRepository  extends JpaRepository<User,Integer>{
         public User findByAccount(String account);
         public User findByNickname(String nickName);

    /**
     * 要加事务管理
     * @param password
     * @param userID
     * @return
     */

    //单个更新操作
    @Modifying
    @Query("update User user set user.password=?1 where user.userID=?2")
    public void updatePasswordById(String password,int userID);

    @Modifying
    @Query("update User user set user.nickname=?1 where user.userID=?2")
    public  void updateNicknameById(String nickname,Integer userID);

    @Modifying
    @Query("update  User user set user.address=?1 where user.userID=?2")
    public void updateAddressById(String address,Integer userID);

    @Modifying
    @Query("update  User user set user.avatar=?1 where user.userID=?2")
    public void updateAvatarById(String avatar,Integer userID);

    @Modifying
    @Query("update  User user set user.birthday=?1 where user.userID=?2")
    public void updateBirthdayById(String birthday,Integer userID);

    @Modifying
    @Query("update  User user set user.email=?1 where user.userID=?2")
    public void updateEmailById(String email,Integer userID);

    @Modifying
    @Query("update  User user set user.intro=?1 where user.userID=?2")
    public void updateIntroById(String intro,Integer userID);

    @Modifying
    @Query("update  User user set user.sex=?1 where user.userID=?2")
    public void updateSexById(String sex,Integer userID);

    @Modifying
    @Query("update  User user set user.telephone=?1 where user.userID=?2")
    public void updateTelephoneById(String telephone,Integer userID);


}
