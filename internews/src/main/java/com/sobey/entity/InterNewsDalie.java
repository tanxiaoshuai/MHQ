package com.sobey.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by TS on 2017/9/9.
 */
@Component
@Scope("prototype")
public class InterNewsDalie {

    private String summary;	 //描述

    private String fullText;	//内容

    private String title;	 //标题

    private String collectTimel;	 //收藏时间

    private String keywords;	 //关键词

    private String materials;	 //图片

    private String sitename;	 //站点

    private String nid;	 //id

    private String from;	 //来源

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollectTimel() {
        return collectTimel;
    }

    public void setCollectTimel(String collectTimel) {
        this.collectTimel = collectTimel;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
