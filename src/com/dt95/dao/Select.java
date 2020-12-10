package com.dt95.dao;

import java.util.ArrayList;
import java.util.List;

import com.dt95.entity.Newsinfo;
import com.dt95.entity.Page;
import com.dt95.entity.Userinfo;

public interface Select {
	
	//��ѯUser�û�����Ϣ��
	ArrayList<Userinfo> getAll(String sql,Object ...args);
	
	
	//��¼��֤��Ϣ��
	Boolean getInfo(String sql,Object ...args);
	
	
	//��ѯnews��Ϣ
	List<Newsinfo> getNews(String sql,Object ...args);
	
	
	//��ѯnews��Ϣ��ָ������
	List<Newsinfo> getInfo(Page page);
	
	
	
	//��ѯnews�ܹ��ж�������
	int getCount();
	
	int upDate(String sql,Object ...args);
	int newsUpdate(Newsinfo news);
}
