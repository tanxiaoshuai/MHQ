package com.sobey.dao;
import com.sobey.model.GisUesr;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GisUserDao {

    /**
     * 添加用户
     * @throws Exception
     */
    @Insert("insert into gis_user (uid , phonenum , userimg , userid, usercode , username , department , lprecision , latitude , location , loginsystem , lstatus , devicetype , updatetime , videostatus , videoaddress , channelid , channelname , expand) values (#{uid} , #{phonenum} , #{userimg} , #{userid}, #{usercode} , #{username} , #{department} , #{lprecision} , #{latitude} , #{location} , #{loginsystem} , #{lstatus} , #{devicetype} , #{updatetime} , #{videostatus} , #{videoaddress} , #{channelid} , #{channelname} , #{expand})")
    public void insertuser(GisUesr user) throws Exception;

    /**
     * 查询所有在线用户
     * @return
     * @throws Exception
     */
    @Select("select * from gis_user where lstatus = 1")
    public List<GisUesr> search() throws Exception;

    /**
     * 查询在线用户
     * @param updatetime
     * @return
     * @throws Exception
     */
    @Select("select * from gis_user where lstatus = 1 and updatetime < #{updatetime}")
    public List<GisUesr> search_heart(String updatetime) throws Exception;

    /**
     * 判断用户是否存在
     * @param usercode
     * @return
     * @throws Exception
     */
    @Select("select count(1) from gis_user where usercode = #{usercode}")
    public int count(String usercode)throws Exception;

    @Update("<script> update gis_user " +
            "<set>" +
            "<if test=\" uid != null \"> uid = #{uid} ,</if>" +
            "<if test=\" phonenum != null \"> phonenum = #{phonenum} ,</if>" +
            "<if test=\" userimg != null \"> userimg = #{userimg} ,</if>" +
            "<if test=\" userid != null \"> userid = #{userid} ,</if>" +
            "<if test=\" username != null \"> username = #{username} ,</if>" +
            "<if test=\" department != null \"> department = #{department} ,</if>" +
            "<if test=\" latitude != null \"> latitude = #{latitude} ,</if>" +
            "<if test=\" location != null \"> location = #{location} ,</if>" +
            "<if test=\" lprecision != null \"> lprecision = #{lprecision} ,</if>" +
            "<if test=\" loginsystem != null \"> loginsystem = #{loginsystem} ,</if>" +
            "<if test=\" devicetype != null \"> devicetype = #{devicetype} ,</if>" +
            "<if test=\" updatetime != null \"> updatetime = #{updatetime} ,</if>" +
            "<if test=\" channelid != null \"> channelid = #{channelid} ,</if>" +
            "<if test=\" channelname != null \"> channelname = #{channelname} ,</if>" +
            "<if test=\" videostatus != null \"> videostatus = #{videostatus} ,</if>" +
            "<if test=\" videoaddress != null \"> videoaddress = #{videoaddress} ,</if>" +
            "<if test=\" lstatus != null \"> lstatus = #{lstatus} ,</if>" +
            "<if test=\" expand != null \"> expand = #{expand}</if>" +
            "</set>"+
            " <where> " +
            "<if test=\" usercode != null \"> usercode = #{usercode}</if>" +
            " </where> " +
            "</script> ")
    public void update(GisUesr user) throws Exception;



}
