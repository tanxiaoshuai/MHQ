package com.sobey.dao;
import com.sobey.model.Ratings;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RatingsDao {

    @Insert("insert into t_ratings (ratname , rattype , ratings , trend) values (#{ratname} , #{rattype} , #{ratings} , #{trend})")
    public void insertratings(@Param("ratname") String ratname , @Param("rattype") String rattype , @Param("ratings") Double ratings , @Param("trend") Integer trend)throws Exception;

    @Select("select * from t_ratings where 1=1 order by ratings desc limit #{startpage} , #{endpage}")
    @Results({
            @Result(column = "ratname" , property = "name"),
            @Result(column = "rattype" , property = "type"),
            @Result(column = "ratings" , property = "ratings"),
            @Result(column = "trend" , property = "trend")
    })
    public List<Ratings> search_list(@Param("startpage") Long startpage , @Param("endpage")Integer endpage) throws Exception;

    @Select("select count(1) from t_ratings")
    public Long count() throws Exception;

    @Delete("delete from t_ratings")
    public void delete () throws Exception;
}
