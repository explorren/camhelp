
package com.camhelp.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;


/**
 * Created by Jupiter on 2017/8/2.
 */

@Entity
@Data
public class UserFollow {
    @Id
    @GeneratedValue
    private int gzwID;

    private int userID;
    private int type;

    public void UserFollow(){

    }
}

