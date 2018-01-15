package com.sobey.dao;

import com.sobey.model.LayOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by TS on 2017/10/19.
 */
@Mapper
public interface LayOutDao {

    /**
     * 获取后台配置
     * @param layoutid
     * @return
     * @throws Exception
     */
    @Select("select * from t_layout where layoutid = #{layoutid}")
    public LayOut search_id(String layoutid) throws Exception;

    /**
     * 修改后台配置参数
     * @param layOut
     * @throws Exception
     */
    @Update("update t_layout set reqtime = #{reqtime} , carouseltime = #{carouseltime} , title = #{title} , staticdata = #{staticdata} , datatype = #{datatype}  , imgtype = #{imgtype} , extend = #{extend} where layoutid = #{layoutid}")
    public void updatelayout(LayOut layOut) throws Exception;

    /**
     * 修改后台配置参数
     * @param backgroundurl
     * @throws Exception
     */
    @Update("update t_layout set backgroundurl = #{backgroundurl} where layoutid = #{layoutid}")
    public void updateImg(@Param("backgroundurl") String backgroundurl , @Param("layoutid") String layoutid) throws Exception;

}
