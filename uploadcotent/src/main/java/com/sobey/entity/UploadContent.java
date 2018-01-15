package com.sobey.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by TS on 2017/9/9.
 */
@Component
@Scope("prototype")
public class UploadContent {

    private String clipsource;//上传类型

    private String fileType;//文件类型

    private String createUser;//创建者

    private String name;//标题

    private Integer fileCount;//文件总数

    private String contentId;//素材id

    private String lastUpdateDate;//最后上传时间

    private List<String> pathList;//图片集合

    public String getClipsource() {
        return clipsource;
    }

    public void setClipsource(String clipsource) {
        this.clipsource = clipsource;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFileCount() {
        return fileCount;
    }

    public void setFileCount(Integer fileCount) {
        this.fileCount = fileCount;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<String> getPathList() {
        return pathList;
    }

    public void setPathList(List<String> pathList) {
        this.pathList = pathList;
    }
}
