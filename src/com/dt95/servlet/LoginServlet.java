package com.dt95.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = "select * from user_info where username=? and password=?";
		SelectImpl si = new SelectImpl();
		boolean flag = si.getInfo(sql, name,password);
		if(flag){
			HttpSession session = request.getSession();
			Page page = new Page();
			page.setCurrentPage(1);
			page.setLimitPage(3);
			page.setSunPage(si.getCount());
			List<Newsinfo> news = si.getInfo(page);
			request.setAttribute("list", news);
			session.setAttribute("numpage",page.getLastPage());
			request.setAttribute("now", page.getCurrentPage());
			session.setAttribute("uname", name);
			request.setAttribute("pg", page);
			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		}else{
            response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print("<script language='javascript'>alert('你输入的用户名和密码错误！');window.location='FitterServlet'</script>");
			pw.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
