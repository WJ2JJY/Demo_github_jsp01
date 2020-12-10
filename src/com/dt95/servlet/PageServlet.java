package com.dt95.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt95.dao.impl.SelectImpl;
import com.dt95.entity.Newsinfo;
import com.dt95.entity.Page;

/**
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	Page page = new Page();
	SelectImpl si = new SelectImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentPage =request.getParameter("currentPage");
		page.setLimitPage(3);
		int pageNum=0;
		page.setSunPage(si.getCount());
		if(currentPage==null){
			pageNum=page.getCurrentPage();
		}else{
			pageNum = Integer.valueOf(currentPage).intValue();
		}
		if(pageNum<1){
			pageNum=1;
		}else if(pageNum>page.getLastPage()){
			pageNum=page.getLastPage();
		}
		page.setCurrentPage(pageNum);
		List<Newsinfo> news = si.getInfo(page);
		request.getSession().setAttribute("numpage", page.getLastPage());
		request.setAttribute("now", page.getCurrentPage());
	    request.setAttribute("list", news);
	    request.setAttribute("pg", page);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	}

}
