package com.camhelp.dataobject;

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
        private Integer userID;

        private String loginName;

        private String password;

        private String nickname;

        private String sex;

        private String intro;

        private String avatar;

        private Integer roleID;

        private String phone;

        public void User(){

        }

}
