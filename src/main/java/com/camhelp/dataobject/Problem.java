package com.camhelp.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Jupiter
 * @description
 * @create 2017-08-04-11:35
 */
@Entity
@Data
public class Problem {
    @Id
    @GeneratedValue
    /**问题ID*/
    private int probID;
    /**问题类型*/
    private int probType;
    /**问题标题*/
    private String probTitle;
    /**问题简介*/
    private String probIntro;
    /**问题内容*/
    private String probContent;
    /**问题图片1*/
    private String probPic1;
    /**问题图片2*/
    private String probPic2;
    /**问题图片3*/
    private String probPic3;
    /**问题图片4*/
    private String probPic4;
    /**问题创建时间*/
    private String createtime;
    /**关注量*/
    private int praisenum;
    /**浏览量*/
    private int browsernum;
    /**发布人ID*/
    private int userID;

    private String time;

    public Problem() {
    }
}

