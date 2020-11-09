package com.hb.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.util.VerifyCode;

@WebServlet("/getVerifyCode") 
public class GetVerifyCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetVerifyCode() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 
            int width=200;
            int height=69;
            BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            //���ɶ�Ӧ��ߵĳ�ʼͼƬ
			String randomText = VerifyCode.drawRandomText(width,height,verifyImg);
			//������һ���෽�������ڴ��븴�ÿ��ǣ������˷�װ��
			//������������֤���ַ���������㣬�����ߣ�����ֵΪ��֤���ַ�                   
			request.getSession().setAttribute("verifyCode", randomText);
			response.setContentType("image/png");//����������Ӧ��������ΪͼƬ������ǰ̨��ʶ��
			OutputStream os = response.getOutputStream(); //��ȡ�ļ������    
			ImageIO.write(verifyImg,"png",os);//���ͼƬ��
			os.flush();
			os.close();//�ر���

   } catch (IOException e) {

				
				e.printStackTrace();

   			}

	}

}
