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
 * Servlet implementation class FitterServlet
 */
public class FitterServlet extends HttpServlet {
	Page page = new Page();
	SelectImpl si = new SelectImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "SELECT * FROM news_info";
		
		List<Newsinfo> news = si.getNews(sql);
	    request.setAttribute("list", news);
	    request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
