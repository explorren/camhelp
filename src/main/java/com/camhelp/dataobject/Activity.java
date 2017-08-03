
package com.camhelp.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Created by Jupiter on 2017/8/2.
 */

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue
    private int actID;

    private int assID;
    private String actName;
    private String actTime;
    private String actAddress;
    private String actDetail;
    private String time;
    private String actPic;

    public void Activity(){

    }
}

