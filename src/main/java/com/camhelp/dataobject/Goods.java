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
public class Goods {
    @Id
    @GeneratedValue
    /**物品ID*/
    private int goodsID;
    /**物品类型*/
    private String goodsType;
    /**物品名字*/
    private String goodsName;
    /**物品标题*/
    private String goodsTitle;
    /**物品内容*/
    private String goodsContent;
    /**物品简介*/
    private String goodsIntro;
    /**物品图片1*/
    private String goodsPic1;
    /**物品图片2*/
    private String goodsPic2;
    /**物品图片3*/
    private String goodsPic3;
    /**物品图片4*/
    private String goodsPic4;
    /**创建时间*/
    private String createtime;
    /**关注量*/
    private int praisenum;
    /**浏览量*/
    private int browsenum;

    /**发布者ID*/
    private int UserID;
    public Goods() {
    }
}

