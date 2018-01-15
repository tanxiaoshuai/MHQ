package com.sobey.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by TS on 2017/7/26.
 */
@Component
@ConfigurationProperties(prefix = "ConfigUrl")
public class ConfigUrl {

    private String img_ip;

    private String tpp_ip;//tpp ip 地址

    private String hive_ip;// hive ip 地址

    private String pgc_ip;//pgc ip地址

    private String resource_upload_url;//手机上传地址

    private String upload_path_saerch;//查询上传图片地址列表

    private String internet_news_url;//查询互联网新新闻列表

    private String internet_news_saerchid;//查询互联网新闻详情

    private String hxy_login;//华西云登陆地址

    private String hive_login;//HIVE登陆地址

    private String sobeyhive_http_system; //hive登陆配置

    private String hot_news;//实时热点新闻

    private String topice_url;//选题查询url

    private String taskprogress_url;//采访轨迹查询

    private String interview_search_url;//采访任务列表查询

    private String topice_task_url;//选题轨迹

    private String serie_list_searchid_url_ns;//查询串联单详情ns

    private String serie_search_ns;//查询串联单列表ns

    private String serie_list_searchid_url_mch;//查询串联单详情mch

    private String serie_search_mch;//查询串联单列表ns

    private String pgc_getreports;//获取记者列表

    private String broke_news;//电话爆料

    private String broke_statistics;//爆料数据统计

    private String broke_fl;//爆料基础数据

    private String product_publish;

    private String product_newest;

    private String product_querybysql;

    private String serie_search;

    private String serie_list_searchid_url;

    public String getImg_ip() {
        return img_ip;
    }

    public void setImg_ip(String img_ip) {
        this.img_ip = img_ip;
    }

    public String getPgc_ip() {
        return pgc_ip;
    }

    public void setPgc_ip(String pgc_ip) {
        this.pgc_ip = pgc_ip;
    }

    public String getSerie_list_searchid_url_ns() {
        return serie_list_searchid_url_ns;
    }

    public void setSerie_list_searchid_url_ns(String serie_list_searchid_url_ns) {
        this.serie_list_searchid_url_ns = serie_list_searchid_url_ns;
    }

    public String getSerie_search_ns() {
        return serie_search_ns;
    }

    public void setSerie_search_ns(String serie_search_ns) {
        this.serie_search_ns = serie_search_ns;
    }

    public String getSerie_list_searchid_url_mch() {
        return serie_list_searchid_url_mch;
    }

    public void setSerie_list_searchid_url_mch(String serie_list_searchid_url_mch) {
        this.serie_list_searchid_url_mch = serie_list_searchid_url_mch;
    }

    public String getSerie_search_mch() {
        return serie_search_mch;
    }

    public void setSerie_search_mch(String serie_search_mch) {
        this.serie_search_mch = serie_search_mch;
    }

    public String getTopice_task_url() {
        return tpp_ip + topice_task_url;
    }

    public void setTopice_task_url(String topice_task_url) {
        this.topice_task_url = topice_task_url;
    }

    public String getInterview_search_url() {
        return tpp_ip + interview_search_url;
    }

    public void setInterview_search_url(String interview_search_url) {
        this.interview_search_url = interview_search_url;
    }

    public String getTaskprogress_url() {
        return tpp_ip + taskprogress_url;
    }

    public void setTaskprogress_url(String taskprogress_url) {
        this.taskprogress_url = taskprogress_url;
    }

    public String getTopice_url() {
        return tpp_ip + topice_url;
    }

    public void setTopice_url(String topice_url) {
        this.topice_url = topice_url;
    }

    public String getHot_news() {
        return hot_news;
    }

    public void setHot_news(String hot_news) {
        this.hot_news = hot_news;
    }

    public String getTpp_ip() {
        return tpp_ip;
    }

    public void setTpp_ip(String tpp_ip) {
        this.tpp_ip = tpp_ip;
    }

    public String getHive_ip() {
        return hive_ip;
    }

    public void setHive_ip(String hive_ip) {
        this.hive_ip = hive_ip;
    }

    //带有ip地址
    public String getResource_upload_url() {
        return tpp_ip + resource_upload_url;
    }

    public void setResource_upload_url(String resource_upload_url) {
        this.resource_upload_url = resource_upload_url;
    }

    public String getUpload_path_saerch() {
        return tpp_ip + upload_path_saerch;
    }

    public void setUpload_path_saerch(String upload_path_saerch) {
        this.upload_path_saerch = upload_path_saerch;
    }

    public String getInternet_news_url() {
        return internet_news_url;
    }

    public void setInternet_news_url(String internet_news_url) {
        this.internet_news_url = internet_news_url;
    }

    public String getInternet_news_saerchid() {
        return internet_news_saerchid;
    }

    public void setInternet_news_saerchid(String internet_news_saerchid) {
        this.internet_news_saerchid = internet_news_saerchid;
    }

    public String getHxy_login() {
        return hxy_login;
    }

    public void setHxy_login(String hxy_login) {
        this.hxy_login = hxy_login;
    }

    public String getHive_login() {
        return hive_ip + hive_login;
    }

    public void setHive_login(String hive_login) {
        this.hive_login = hive_login;
    }

    public String getSobeyhive_http_system() {
        return sobeyhive_http_system;
    }

    public void setSobeyhive_http_system(String sobeyhive_http_system) {
        this.sobeyhive_http_system = sobeyhive_http_system;
    }

    public String getPgc_getreports() {
        return pgc_ip + pgc_getreports;
    }

    public void setPgc_getreports(String pgc_getreports) {
        this.pgc_getreports = pgc_getreports;
    }

    public String getBroke_news() {
        return tpp_ip + broke_news;
    }

    public void setBroke_news(String broke_news) {
        this.broke_news = broke_news;
    }

    public String getBroke_statistics() {
        return tpp_ip + broke_statistics;
    }

    public void setBroke_statistics(String broke_statistics) {
        this.broke_statistics = broke_statistics;
    }

    public String getProduct_publish() {
        return !product_publish.contains("https://") ? product_publish : tpp_ip + product_publish;
    }

    public void setProduct_publish(String product_publish) {
        this.product_publish = product_publish;
    }

    public String getProduct_newest() {
        return !product_newest.contains("https://") ? product_newest : tpp_ip + product_newest;
    }

    public String getBroke_fl() {
        return broke_fl.contains("http://") ? broke_fl : tpp_ip + broke_fl;
    }

    public void setBroke_fl(String broke_fl) {
        this.broke_fl = broke_fl;
    }

    public void setProduct_newest(String product_newest) {
        this.product_newest = product_newest;
    }

    public String getProduct_querybysql() {
        return !product_querybysql.contains("https://") ? product_querybysql : tpp_ip + product_querybysql;
    }

    public void setProduct_querybysql(String product_querybysql) {
        this.product_querybysql = product_querybysql;
    }

    public String getSerie_search() {
        return serie_search;
    }

    public void setSerie_search(String serie_search) {
        this.serie_search = serie_search;
    }

    public String getSerie_list_searchid_url() {
        return serie_list_searchid_url;
    }

    public void setSerie_list_searchid_url(String serie_list_searchid_url) {
        this.serie_list_searchid_url = serie_list_searchid_url;
    }
}
