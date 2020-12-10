package com.dt95.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	protected Connection con = null;
	protected PreparedStatement pst =null;
	protected ResultSet rs = null;
	
	public Connection getCon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/news?useUnicode=true&characterEncoding=utf8&useSSL=true",
					"root","root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void release(Connection con,PreparedStatement pst,ResultSet rs){ 
		try {
			if(rs!=null){
				rs.close();
			}
			if(pst!=null){
				pst.close();
			}
            if(con!=null){
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
