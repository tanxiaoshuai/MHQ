package com.sobey.dao;

import com.sobey.model.WatchList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by TS on 2017/10/18.
 */
@Mapper
public interface WatchDao {

    /**
     * 查询值班列表
     * @return
     * @throws Exception
     */
    @Select("select * from t_watch")
    public List<WatchList> searchwatch() throws Exception;

    /**
     * 修改值班表
     * @param watchList
     * @throws Exception
     */
    @Update("update t_watch set watchman = #{watchman} , watchdata = #{watchdata} , updatetime = #{updatetime} , ondutyTitle = #{ondutyTitle} where uid = #{uid}")
    public void updatewatch(WatchList watchList) throws Exception;
}
