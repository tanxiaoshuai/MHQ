package com.sobey.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by TS on 2017/9/9.
 */
@Component
@Scope("prototype")
public class InterNews {

    private String title;	 //标题

    private String keywords;	 //关键词

    private String collectTimel;	 //时间

    private String materials;	 //地址

    private String sitename;	 //站点

    private String keyframeurl;	 //首帧

    private String nid;	 //id

    private String from;	 //来源

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCollectTimel() {
        return collectTimel;
    }

    public void setCollectTimel(String collectTimel) {
        this.collectTimel = collectTimel;
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

    public String getKeyframeurl() {
        return keyframeurl;
    }

    public void setKeyframeurl(String keyframeurl) {
        this.keyframeurl = keyframeurl;
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
