package com.sobey.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.BaseDao;
import org.springframework.stereotype.Component;
import java.util.Properties;

@Component
public class ProductAppDao extends BaseDao{
    public JSONArray find(Integer type){
        this.setConnection();
        JSONArray array = new JSONArray();
        try {
            Properties pro = new Properties();
            pro.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));
            String sql = pro.getProperty("sql_f");
            LOGGER.info("数据库连接加载成功：" + pro.getProperty("url"));
            if(type == 1){
                sql = pro.getProperty("sql_f");
            }
            if(type == 2){
                sql = pro.getProperty("sql_d");
            }
            LOGGER.info("数据库SQL：" + sql);
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                JSONObject object = new JSONObject();
                object.put("AddUser" , rs.getString("AddUser"));
                object.put("total" , rs.getString("total"));
                array.add(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.closeConnection();
        }
        return array;
    }

    public static void main(String[] args){
        System.out.println(new ProductAppDao().find(1));
    }
}
