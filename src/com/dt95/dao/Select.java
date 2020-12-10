package com.dt95.dao;

import java.util.ArrayList;
import java.util.List;

import com.dt95.entity.Newsinfo;
import com.dt95.entity.Page;
import com.dt95.entity.Userinfo;

public interface Select {
	
	//查询User用户的信息！
	ArrayList<Userinfo> getAll(String sql,Object ...args);
	
	
	//登录验证信息！
	Boolean getInfo(String sql,Object ...args);
	
	
	//查询news信息
	List<Newsinfo> getNews(String sql,Object ...args);
	
	
	//查询news信息的指定条数
	List<Newsinfo> getInfo(Page page);
	
	
	
	//查询news总共有多少条！
	int getCount();
	
	int upDate(String sql,Object ...args);
	int newsUpdate(Newsinfo news);
}
