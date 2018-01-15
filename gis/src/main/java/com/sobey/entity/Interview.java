package com.sobey.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by TS on 2017/9/10.
 */
@Component
@Scope("prototype")
public class Interview {

    private String imgip;//图片ip
    private String position;//经纬度
    private String createTime;//创建时间
    private Integer status;//状态
    private String createUserCode;//创建人code
    private String newsUsesName;
    private String statusName;
    private String columnCode;
    private List<String> resMaterial;//图片集合
    private String executorCode;
    private String beginTime;
    private List<Taskprogress> taskprogress;//任务轨迹
    private String endTime;
    private String siteCode;
    private String content;//内容
    private String createUserName;
    private String title;
    private String newsSourceName;
    private String columnName;
    private String uuid;
    private String completedExecutorCode;
    private String positionName;//地址
    private String executorName;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public String getNewsUsesName() {
        return newsUsesName;
    }

    public void setNewsUsesName(String newsUsesName) {
        this.newsUsesName = newsUsesName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public List<String> getResMaterial() {
        return resMaterial;
    }

    public void setResMaterial(List<String> resMaterial) {
        this.resMaterial = resMaterial;
    }

    public String getExecutorCode() {
        return executorCode;
    }

    public void setExecutorCode(String executorCode) {
        this.executorCode = executorCode;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public List<Taskprogress> getTaskprogress() {
        return taskprogress;
    }

    public void setTaskprogress(List<Taskprogress> taskprogress) {
        this.taskprogress = taskprogress;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsSourceName() {
        return newsSourceName;
    }

    public void setNewsSourceName(String newsSourceName) {
        this.newsSourceName = newsSourceName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCompletedExecutorCode() {
        return completedExecutorCode;
    }

    public void setCompletedExecutorCode(String completedExecutorCode) {
        this.completedExecutorCode = completedExecutorCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public String getImgip() {
        return imgip;
    }

    public void setImgip(String imgip) {
        this.imgip = imgip;
    }
}
