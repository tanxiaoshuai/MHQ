package com.sobey.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GisUesr {

    /**
     * 主要用于直播 第三方id
     */
    private String uid;

    /**
     * 用户编码
     */
    private String usercode;
    /**
     * 用户名
     */
    private String username;
    /**
     * 经度
     */
    private String lprecision;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 地址
     */
    private String location;
    /**
     * 登陆系统
     */
    private String loginsystem;
    /**
     * 扩展字段
     */
    private String expand;
    /**
     * 登陆状态
     */
    private String lstatus;
    /**
     * 登陆设备
     */
    private String devicetype;
    /**
     * 坐标更新时间
     */
    private String updatetime;

    /**
     * 视频状态 0:未直播，1：直播
     */
    private String videostatus;

    /**
     * 视频地址
     */
    private String videoaddress;
    /**
     * 频道id
     */
    private String channelid;

    /**
     * 频道名称
     */
    private String channelname;

    /**
     * hive用户id
     */
    private String userid;

    /**
     * 电话
     */
    private String phonenum;

    /**
     * 部门
     */
    private String department;

    /**
     * 头像
     */
    private String userimg;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLprecision() {
        return lprecision;
    }

    public void setLprecision(String lprecision) {
        this.lprecision = lprecision;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLoginsystem() {
        return loginsystem;
    }

    public void setLoginsystem(String loginsystem) {
        this.loginsystem = loginsystem;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getLstatus() {
        return lstatus;
    }

    public void setLstatus(String lstatus) {
        this.lstatus = lstatus;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getVideostatus() {
        return videostatus;
    }

    public void setVideostatus(String videostatus) {
        this.videostatus = videostatus;
    }

    public String getVideoaddress() {
        return videoaddress;
    }

    public void setVideoaddress(String videoaddress) {
        this.videoaddress = videoaddress;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }
}
