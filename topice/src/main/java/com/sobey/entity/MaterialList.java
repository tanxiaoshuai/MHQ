package com.sobey.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by TS on 2017/9/9.
 */
@Component
@Scope("prototype")
public class MaterialList {

    private List keyFrameUrl;

    private List streamMediaUrl;

    private String name;

    private String type;

    private String contentId;

    public List getKeyFrameUrl() {
        return keyFrameUrl;
    }

    public void setKeyFrameUrl(List keyFrameUrl) {
        this.keyFrameUrl = keyFrameUrl;
    }

    public List getStreamMediaUrl() {
        return streamMediaUrl;
    }

    public void setStreamMediaUrl(List streamMediaUrl) {
        this.streamMediaUrl = streamMediaUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
}
