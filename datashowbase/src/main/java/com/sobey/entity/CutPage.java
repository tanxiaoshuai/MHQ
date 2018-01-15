package com.sobey.entity;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by TS on 2017/8/28.
 */
@Component
public class CutPage<T> {

    private Long count;

    private Long totalpage;

    private List<T> list;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(Long totalpage) {
        this.totalpage = totalpage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
