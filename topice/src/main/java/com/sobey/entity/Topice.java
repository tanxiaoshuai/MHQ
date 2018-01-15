package com.sobey.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Created by TS on 2017/9/9.
 */
@Component
@Scope("prototype")
public class Topice {

    private String contentId;//选题id

    private String createUserCode;//创建人code

    private String createUserName;//创建人名字

    private String createDate;//创建时间

    private Integer  examinestatus;//审核状态

    private List<MaterialList> materlist;//素材集合

    private Integer interview;//采访状态

    private Integer internation;//互联网状态

    private Integer assignstate;//指派状态

    private Integer info;//文稿状态

    private String title;//标题

    private Integer materialCount;//总数

    private String content;//内容

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getExaminestatus() {
        return examinestatus;
    }

    public void setExaminestatus(Integer examinestatus) {
        this.examinestatus = examinestatus;
    }

    public Integer getInterview() {
        return interview;
    }

    public void setInterview(Integer interview) {
        this.interview = interview;
    }

    public Integer getInternation() {
        return internation;
    }

    public void setInternation(Integer internation) {
        this.internation = internation;
    }

    public Integer getAssignstate() {
        return assignstate;
    }

    public void setAssignstate(Integer assignstate) {
        this.assignstate = assignstate;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Integer materialCount) {
        this.materialCount = materialCount;
    }

    public List<MaterialList> getMaterlist() {
        return materlist;
    }

    public void setMaterlist(List<MaterialList> materlist) {
        this.materlist = materlist;
    }
}
