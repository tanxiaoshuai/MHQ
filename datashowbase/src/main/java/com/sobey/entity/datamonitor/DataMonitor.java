package com.sobey.entity.datamonitor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by TS on 2017/9/19.
 */
@Component
@ConfigurationProperties(prefix = "DataMonitor")
public class DataMonitor {

    private String datamonitor_ip;//ip

    private String business_convergence;//业务监控 -- 汇聚接口

    private String business_make;

    private String business_channel;//业务监控 -- 发布渠道

    private String business_file;//业务监控 --统计归档文件数量

    private String business_file_count;//统计文件数量

    private String business_stroage_threed;//入库趋势

    private String business_date_add;//文件今日增量

    private String business_stroage_size;//仓库大小


    private String content_alltimelength;//节目和素材时长

    private String content_tagcloudresourcename;//视频标签

    private String content_tools;//内容分布图工具

    private String content_source;//素材内容数统计

    private String content_file_count;//文件总数


    private String system_ip;//业务监控ip

    private String system_resource;//#集群所有节点当前资源使⽤情况

    private String system_performance;//

    private String system_realtime;

    private String system_io;

    private String system_doc_status_num;//节点服务器统计

    private String system_file_size;//文件大小




    public String getDatamonitor_ip() {
        return StringUtils.isEmpty(datamonitor_ip) ? "" : datamonitor_ip;
    }

    public void setDatamonitor_ip(String datamonitor_ip) {
        this.datamonitor_ip = datamonitor_ip;
    }

    public String getBusiness_convergence() {
        return getDatamonitor_ip() + business_convergence;
    }

    public void setBusiness_convergence(String business_convergence) {
        this.business_convergence = business_convergence;
    }

    public String getBusiness_make() {
        return getDatamonitor_ip() + business_make;
    }

    public void setBusiness_make(String business_make) {
        this.business_make = business_make;
    }

    public String getBusiness_channel() {
        return getDatamonitor_ip() + business_channel;
    }

    public void setBusiness_channel(String business_channel) {
        this.business_channel = business_channel;
    }

    public String getBusiness_file() {
        return getDatamonitor_ip() + business_file;
    }

    public void setBusiness_file(String business_file) {
        this.business_file = business_file;
    }

    public String getBusiness_file_count() {
        return getDatamonitor_ip() + business_file_count;
    }

    public void setBusiness_file_count(String business_file_count) {
        this.business_file_count = business_file_count;
    }

    public String getBusiness_stroage_threed() {
        return getDatamonitor_ip() + business_stroage_threed;
    }

    public void setBusiness_stroage_threed(String business_stroage_threed) {
        this.business_stroage_threed = business_stroage_threed;
    }

    public String getBusiness_date_add() {
        return getDatamonitor_ip() + business_date_add;
    }

    public void setBusiness_date_add(String business_date_add) {
        this.business_date_add = business_date_add;
    }

    public String getContent_alltimelength() {
        return getDatamonitor_ip() + content_alltimelength;
    }

    public void setContent_alltimelength(String content_alltimelength) {
        this.content_alltimelength = content_alltimelength;
    }

    public String getContent_tagcloudresourcename() {
        return getDatamonitor_ip() + content_tagcloudresourcename;
    }

    public void setContent_tagcloudresourcename(String content_tagcloudresourcename) {
        this.content_tagcloudresourcename = content_tagcloudresourcename;
    }

    public String getBusiness_stroage_size() {
        return business_stroage_size;
    }

    public void setBusiness_stroage_size(String business_stroage_size) {
        this.business_stroage_size = business_stroage_size;
    }

    public String getContent_tools() {
        return getDatamonitor_ip() + content_tools;
    }

    public void setContent_tools(String content_tools) {
        this.content_tools = content_tools;
    }

    public String getContent_source() {
        return getDatamonitor_ip() + content_source;
    }

    public void setContent_source(String content_source) {
        this.content_source = content_source;
    }

    public String getContent_file_count() {
        return getDatamonitor_ip() + content_file_count;
    }

    public void setContent_file_count(String content_file_count) {
        this.content_file_count = content_file_count;
    }

    public String getSystem_ip() {
        return system_ip;
    }

    public void setSystem_ip(String system_ip) {
        this.system_ip = system_ip;
    }

    public String getSystem_resource() {
        return getSystem_ip() + system_resource;
    }

    public void setSystem_resource(String system_resource) {
        this.system_resource = system_resource;
    }

    public String getSystem_performance() {
        return getSystem_ip() + system_performance;
    }

    public void setSystem_performance(String system_performance) {
        this.system_performance = system_performance;
    }

    public String getSystem_realtime() {
        return getSystem_ip() + system_realtime;
    }

    public void setSystem_realtime(String system_realtime) {
        this.system_realtime = system_realtime;
    }

    public String getSystem_io() {
        return getSystem_ip() + system_io;
    }

    public void setSystem_io(String system_io) {
        this.system_io = system_io;
    }

    public String getSystem_doc_status_num() {
        return getSystem_ip() + system_doc_status_num;
    }

    public void setSystem_doc_status_num(String system_doc_status_num) {
        this.system_doc_status_num = system_doc_status_num;
    }

    public String getSystem_file_size() {
        return getDatamonitor_ip() + system_file_size;
    }

    public void setSystem_file_size(String system_file_size) {
        this.system_file_size = system_file_size;
    }
}
