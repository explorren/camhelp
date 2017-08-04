package com.camhelp.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jupiter on 2017/8/4.
 */
@Entity
@Data
public class Experience {
    @Id
    @GeneratedValue
    /**活动ID*/
    private int expID;
    /**活动标题*/
    private String expTitle;
    /**活动简介*/
    private String expIntro;
    /**活动内容*/
    private String expContent;
    /**活动图片1*/
    private String expPic1;
    /**活动图片2*/
    private String expPic2;
    /**活动图片3*/
    private String expPic3;
    /**活动图片4*/
    private String expPic4;
    /**活动开始时间*/
    private String expStartTime;
    /**活动结束时间*/
    private String expEndTime;
    /**活动创建时间*/
    private String createtime;
    /**活动关注数*/
    private String praisenum;
    /**活动浏览量*/
    private String browsenum;
    /**发布者ID*/
    private int userID;

    public Experience() {
    }
}
