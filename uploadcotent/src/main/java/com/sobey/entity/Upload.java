package com.sobey.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by TS on 2017/9/11.
 */
@Component
@Scope("prototype")
public class Upload {

    private Integer total;

    private List<UploadContent> result;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<UploadContent> getResult() {
        return result;
    }

    public void setResult(List<UploadContent> result) {
        this.result = result;
    }
}
