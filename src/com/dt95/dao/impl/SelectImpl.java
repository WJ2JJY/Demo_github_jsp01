package com.dt95.dao.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dt95.dao.BaseDao;
import com.dt95.dao.Select;
import com.dt95.entity.Newsinfo;
import com.dt95.entity.Page;
import com.dt95.entity.Userinfo;

public class SelectImpl extends BaseDao implements Select{

	@Override
	public ArrayList<Userinfo> getAll(String sql, Object... args) {
		// TODO Auto-generated method stub
		con = getCon();
		ArrayList<Userinfo> list =new ArrayList<Userinfo>();
		try {
			pst = con.prepareStatement(sql);
			if(args.length>0&&args!=null){
				for(int i =0;i<args.length;i++){
					pst.setObject(i+1, args[i]);
				}
			}
			rs = pst.executeQuery();
			while(rs.next()){
				Userinfo user = new Userinfo();
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			release(con, pst, rs);
		}
		return null;
	}

	@Override
	public Boolean getInfo(String sql, Object... args) {
		// TODO Auto-generated method stub
		boolean flag = false;
		con = getCon();
		try {
			pst = con.prepareStatement(sql);
			if(args.length>0&&args!=null){
				for(int i =0;i<args.length;i++){
					pst.setObject(i+1, args[i]);
				}
			}
			rs = pst.executeQuery();
			if(rs.next()){
				flag = true;
			}
			
			return flag;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			release(con, pst, rs);
		}
		return flag;
	}

	@Override
	public List<Newsinfo> getNews(String sql, Object... args) {
		// TODO Auto-generated method stub
		con = getCon();
		List<Newsinfo> list =new ArrayList<Newsinfo>();
		try {
			pst = con.prepareStatement(sql);
			if(args.length>0&&args!=null){
				for(int i =0;i<args.length;i++){
					pst.setObject(i+1, args[i]);
				}
			}
			rs = pst.executeQuery();
			while(rs.next()){
				Newsinfo news = new Newsinfo();
				news.setNewsid(rs.getInt(1));
				news.setTypeid(rs.getInt(2));
				news.setNewstitle(rs.getString(3));
				news.setNewsauthor(rs.getString(4));
				news.setNewsummary(rs.getString(5));
				news.setNewscontent(rs.getString(6));
				news.setNewspic(rs.getBlob(7));
				news.setReleasetime(rs.getDate(8));
				list.add(news);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			release(con, pst, rs);
		}
		return null;
	}

	@Override
	public List<Newsinfo> getInfo(Page page) {
		// TODO Auto-generated method stub
		String sql = "select * from news_info limit ?,?";
		List<Newsinfo> list = new ArrayList<>();
		try {
		   pst = getCon().prepareStatement(sql);
		   pst.setInt(1, (page.getCurrentPage()-1)*page.getLimitPage());
		   pst.setInt(2, page.getLimitPage());
		   rs = pst.executeQuery();
		   while(rs.next()){
				Newsinfo news = new Newsinfo();
				news.setNewsid(rs.getInt(1));
				news.setTypeid(rs.getInt(2));
				news.setNewstitle(rs.getString(3));
				news.setNewsauthor(rs.getString(4));
				news.setNewsummary(rs.getString(5));
				news.setNewscontent(rs.getString(6));
				news.setNewspic(rs.getBlob(7));
				news.setReleasetime(rs.getDate(8));
				list.add(news);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			release(con, pst, rs);
		}
		return list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM news_info";
		int count = 0;
		try {
			pst = getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			release(con, pst, rs);
		}
		return 0;
	}

	@Override
	public int upDate(String sql, Object... args) {
		// TODO Auto-generated method stub
		int index = 0;
		try {
			pst = getCon().prepareStatement(sql);
			if(args!=null&&args.length>0){
				for (int i = 0; i < args.length; i++) {
					if(i==5){
						pst.setBlob(i+1, (InputStream)args[i]);
					}else{
						pst.setObject(i+1, args[i]);
					}
				}
			index = pst.executeUpdate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			release(con,pst,rs);
		}
		return index;
	}

	@Override
	public int newsUpdate(Newsinfo news) {
		// TODO Auto-generated method stub
		String sql = "UPDATE news_info SET type_id=?, news_title=?,news_author=?,news_summary=?,news_content=?,news_pic=? WHERE news_id=?";
		
		try {
			pst = getCon().prepareStatement(sql);
			pst.setInt(1, news.getTypeid());
			pst.setString(2, news.getNewstitle());
			pst.setString(3, news.getNewsauthor());
			pst.setString(4, news.getNewsummary());
			pst.setString(5, news.getNewscontent());
			pst.setBlob(6, news.getNewspic());
			pst.setInt(7,news.getNewsid());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
}
