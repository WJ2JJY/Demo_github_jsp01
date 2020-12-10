package com.dt95.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dt95.dao.impl.SelectImpl;
import com.dt95.entity.Newsinfo;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class JqueryServlet
 */
public class JqueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);
		
		
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		InputStream is = request.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		JSONObject js = JSONObject.fromObject(str);
		System.out.println(str);
		Newsinfo news = (Newsinfo)JSONObject.toBean(js, Newsinfo.class);
		SelectImpl si = new SelectImpl();
		int i = si.newsUpdate(news);
		if(i==1){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out= response.getWriter();
			out.write("ÐÞ¸Ä³É¹¦£¡");
			out.flush();
			out.close();
		}
	}

}
