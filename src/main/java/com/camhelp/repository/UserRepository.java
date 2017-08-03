package com.camhelp.repository;

import com.camhelp.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Jupiter on 2017/7/22.
 */
public interface UserRepository  extends JpaRepository<User,Integer>{
         public User findByLoginName(String loginName);
         public User findByNickname(String nickName);

    /**
     * 要加事务管理
     * @param password
     * @param userID
     * @return
     */
         @Modifying
         @Query("update User a set a.password=?1 where a.userID=?2")
         public void updatePasswordById(String password,int userID);

}
