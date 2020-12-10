package com.dt95.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt95.dao.impl.SelectImpl;
import com.dt95.entity.Newsinfo;
import com.dt95.entity.Page;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectImpl si = new SelectImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		File file;
		try {
			su.setCharset("utf-8");
			su.setAllowedFilesList("jpg,png,txt");
			su.setDeniedFilesList("exe,excl");
			su.setMaxFileSize(10*1024*1024);
			Request req = su.getRequest();
			su.upload();
			Files files = su.getFiles();
			file= files.getFile(0);
			String filename = "";
			String pathname = "";
			
			String ntid = req.getParameter("ntid");
			int typeid = Integer.valueOf(ntid).intValue();
			String newsid = req.getParameter("newsid");
			int newid = Integer.valueOf(newsid).intValue();
			String ntitle = req.getParameter("ntitle");
			String nauthor = req.getParameter("nauthor");
			String nsummary = req.getParameter("nsummary");
			String ncontent = req.getParameter("ncontent");
			String sql = "UPDATE news_info SET type_id=?, news_title=?,news_author=?,news_summary=?,news_content=?,news_pic=? WHERE news_id=?";
			InputStream is = null;
			if (!file.isMissing()) {
				filename = file.getFileName();
				pathname = "img/"+UUID.randomUUID().toString()+filename.substring(filename.indexOf("."));
				file.saveAs(pathname, file.SAVEAS_VIRTUAL);
				String path =request.getRealPath("img")+pathname.substring(pathname.indexOf("/"));
				is = new FileInputStream(new java.io.File(path));
			}
			si.upDate(sql,typeid,ntitle,nauthor,nsummary,ncontent,is,newid);
			request.getRequestDispatcher("page").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
























/*int newid = Integer.valueOf(newsid).intValue();
if("true".equals(flag)){
	String sql1 = "delete from news_info where news_id=?";
	si.upDate(sql1,newid);
}else{
	InputStream is = null;
	
	String ntid = req.getParameter("ntid");
	int typeid = Integer.valueOf(ntid).intValue();
	String ntitle = req.getParameter("ntitle");
	String nauthor = req.getParameter("nauthor");
	String nsummary = req.getParameter("nsummary");
	String ncontent = req.getParameter("ncontent");
	String sql = "UPDATE news_info SET type_id=?, news_title=?,news_author=?,news_summary=?,news_content=? WHERE news_id=?";
	si.upDate(sql,typeid,ntitle,nauthor,nsummary,ncontent,newid);
}
request.getRequestDispatcher("page").forward(request, response);*/