package com.ll.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ll.app.dao.UserDao;
import com.ll.app.dao.impl.UserDaoimpl;
import com.ll.app.entity.User;



/**
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User user=new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setRegistTime(dateFormat.format(now));
		UserDao userDao = new UserDaoimpl();
		boolean state = userDao.userRegist(user);
		if (state) {
			System.out.println("注册成功");
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			
			PrintWriter out = null;
			
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("status", "success");
			jsonObject.put("name", user.getUserName());
			jsonObject.put("time", dateFormat.format(now));
			JSONArray jsonArray=new JSONArray();
			jsonArray.put(jsonObject);
			try {
			    out = response.getWriter();
			    out.write(jsonArray.toString());
			} catch (IOException e) {
			    e.printStackTrace();
			} finally {
			    if (out != null) {
			        out.close();
			    }
			}
			
		} else {
			System.out.println("注册失败");
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			
			PrintWriter out = null;
			
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("status", "error");
			
			jsonObject.put("time", dateFormat.format(now));
			JSONArray jsonArray=new JSONArray();
			jsonArray.put(jsonObject);
			try {
			    out = response.getWriter();
			    out.write(jsonArray.toString());
			} catch (IOException e) {
			    e.printStackTrace();
			} finally {
			    if (out != null) {
			        out.close();
			    }
			}
			
		}
	}

	

}
