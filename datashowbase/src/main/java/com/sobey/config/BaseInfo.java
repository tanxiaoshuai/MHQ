package com.sobey.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by TS on 2017/9/8.
 */
@Component
@ConfigurationProperties(prefix = "BaseInfo")
public class BaseInfo {

    private boolean switchmhq;

    private String sitecode;

    private String hivetoken;

    private String hxytoken;

    private String hiveloginname;

    private String hivepassword;

    public boolean isSwitchmhq() {
        return switchmhq;
    }

    public void setSwitchmhq(boolean switchmhq) {
        this.switchmhq = switchmhq;
    }

    public String getSitecode() {
        return sitecode;
    }

    public void setSitecode(String sitecode) {
        this.sitecode = sitecode;
    }

    public String getHivetoken() {
        return hivetoken;
    }

    public void setHivetoken(String hivetoken) {
        this.hivetoken = hivetoken;
    }

    public String getHxytoken() {
        return hxytoken;
    }

    public void setHxytoken(String hxytoken) {
        this.hxytoken = hxytoken;
    }

    public String getHiveloginname() {
        return hiveloginname;
    }

    public void setHiveloginname(String hiveloginname) {
        this.hiveloginname = hiveloginname;
    }

    public String getHivepassword() {
        return hivepassword;
    }

    public void setHivepassword(String hivepassword) {
        this.hivepassword = hivepassword;
    }
}
