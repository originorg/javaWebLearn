package com.hb.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.bean.User;
import com.hb.dao.UserDao;


@WebServlet("/deleteUserServlet")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UserDao userDao;
    public DeleteUser() { 	
        super();
        this.userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String haveLogin = (String) request.getSession(true).getAttribute("haveLogin");//�û���¼���
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if(haveLogin!=null&&haveLogin.equals("yes"))
		{
			if(request.getParameter("id")!=null)
			{
				int id = Integer.parseInt(request.getParameter("id"));
				User user = (User) request.getSession().getAttribute("user");//��ȡuser��Ϣ
				if(id!=user.getId())
				{
					response.getWriter().print("<script>"
							+ "alert('�Ƿ�ɾ��');"
							+ "window.history.back()"
							+ "</script>");
					return;
				}
				
				try {
					userDao.deleteUser(id);
					response.getWriter().print("<script>"
							+ "alert('ɾ���ɹ�');"
							+ "window.history.back()"
							+ "</script>");
				} catch (Exception e) {
					
					e.printStackTrace();
					response.getWriter().print("ϵͳ����");
				}
				
			}
			else
			{
				
			
				response.getWriter().print("<script>"
						+ "alert('��������');"
						+ "window.history.back()"
						+ "</script>");
			}
		}
		else
		{
			request.setAttribute("message", "���¼�����");
			request.getRequestDispatcher("login.jsp").forward(request, response);//�û�δ��¼��ת
		}
		
	}

}