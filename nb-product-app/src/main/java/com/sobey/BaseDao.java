package com.sobey;

import com.sobey.dao.ProductAppDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class BaseDao {

	public static Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);
	
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	public void setConnection(){
		Properties pro = new Properties();
		String driver = null;
		String url = null;
		String userName = null;
		String passWord = null;
		
		try {
			
			pro.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));
			
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			userName = pro.getProperty("userName");
			passWord = pro.getProperty("passWord");
			Class.forName(driver);
			con = DriverManager.getConnection(url,userName,passWord);
			LOGGER.info("驱动连接：" + con.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void closeConnection(){
		
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void main(String[] args) {
		new BaseDao().setConnection();
	}
}
