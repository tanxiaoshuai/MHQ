package com.sobey.model;

/**
 * Created by TS on 2017/10/18.
 */
public class LayOut {

    private String layoutid;

    private String ip;

    private Integer lport;

    private Integer reqtime;

    private Integer carouseltime;

    private String title;

    private String staticdata;

    private Integer datatype;

    private String backgroundurl;

    private String extend;
    /**
     * 0默认图片 1自定义
     */
    private Integer imgtype;

    public String getLayoutid() {
        return layoutid;
    }

    public void setLayoutid(String layoutid) {
        this.layoutid = layoutid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getLport() {
        return lport;
    }

    public void setLport(Integer lport) {
        this.lport = lport;
    }

    public Integer getReqtime() {
        return reqtime;
    }

    public void setReqtime(Integer reqtime) {
        this.reqtime = reqtime;
    }

    public Integer getCarouseltime() {
        return carouseltime;
    }

    public void setCarouseltime(Integer carouseltime) {
        this.carouseltime = carouseltime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStaticdata() {
        return staticdata;
    }

    public void setStaticdata(String staticdata) {
        this.staticdata = staticdata;
    }

    public Integer getDatatype() {
        return datatype;
    }

    public void setDatatype(Integer datatype) {
        this.datatype = datatype;
    }

    public String getBackgroundurl() {
        return backgroundurl;
    }

    public void setBackgroundurl(String backgroundurl) {
        this.backgroundurl = backgroundurl;
    }

    public Integer getImgtype() {
        return imgtype;
    }

    public void setImgtype(Integer imgtype) {
        this.imgtype = imgtype;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}
