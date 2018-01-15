package com.sobey.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by TS on 2017/9/9.
 */
@Component
@Scope("prototype")
public class HotNews {

    private String mediaCat;	 //WEB,

    private String dt;	 //时间

    private String title;	//标题

    private String eventCat;	 //未分类,

    private String eventId;	 //事件id,

    private Integer docCount;	 //总数167,

    private String province;	 //地点香港,

    private Double emotionScore;

    private Integer emotionTendency;

    private String country;	 //国家,

    private String city;	 //城市

    public String getMediaCat() {
        return mediaCat;
    }

    public void setMediaCat(String mediaCat) {
        this.mediaCat = mediaCat;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventCat() {
        return eventCat;
    }

    public void setEventCat(String eventCat) {
        this.eventCat = eventCat;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Integer getDocCount() {
        return docCount;
    }

    public void setDocCount(Integer docCount) {
        this.docCount = docCount;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getEmotionScore() {
        return emotionScore;
    }

    public void setEmotionScore(Double emotionScore) {
        this.emotionScore = emotionScore;
    }

    public Integer getEmotionTendency() {
        return emotionTendency;
    }

    public void setEmotionTendency(Integer emotionTendency) {
        this.emotionTendency = emotionTendency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
