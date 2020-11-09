package com.hb.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.bean.User;
import com.hb.dao.UserDao;


@WebServlet("/updateUserServlet") 
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDao;
    public UpdateUser() {
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
			User user = (User) request.getSession().getAttribute("user");
			if(user!=null){
			
				String name = request.getParameter("userName");
				String pwd = request.getParameter("password");
				String email = request.getParameter("email")==null?"":request.getParameter("email");
				String phone = request.getParameter("phone")==null?"":request.getParameter("phone");
				String address = request.getParameter("address")==null?"":request.getParameter("address");
				
				
				user.setEmail(email);
				user.setPhone(phone);
				user.setAddress(address);
				try {
					userDao.updateUser(user);
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print("��Ϣ�޸ĳɹ�");
					response.getWriter().print(user.toString());
					response.getWriter().print("<script>"
							+ "alert('�޸ĳɹ�');"
							+ "window.history.back()"
							+ "</script>");
				} catch (Exception e) {
					response.getWriter().print("ϵͳ����");
					e.printStackTrace();
				}
			}
			else
			{
				response.getWriter().print("�Ƿ��޸�");
				response.getWriter().print("<script>"
						+ "alert('�Ƿ��޸�');"
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