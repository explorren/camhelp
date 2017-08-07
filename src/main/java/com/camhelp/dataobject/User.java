package com.camhelp.dataobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jupiter on 2017/7/22.
 */

@Entity
@Data

public class User {
        @Id
        @GeneratedValue
        /**用户id*/
        private Integer userID;
        /**账号*/
        private String account;
        /**密码*/
        private String password;
        /**昵称
         * 0-男，1-女,-1-保密*/
        private String nickname;
        /**性别*/
        private Integer sex;
        /**个人简介*/
        private String intro;
        /**个人头像地址*/
        private String avatar;
        /**用户电话*/
        private String telephone;
        /**邮箱*/
        private String email;
        /**地址
         * 利用_进行拼接*/
        private String address;
        /**生日
         * 暂采用String*/
        private String birthday;
        /**用户角色*/
        private Integer roleID;

        public void User(){

        }

}
