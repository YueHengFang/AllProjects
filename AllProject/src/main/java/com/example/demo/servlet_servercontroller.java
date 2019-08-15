package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet_servercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
   {
 		String singnature=request.getParameter("signature");
		String timestamp=request.getParameter("timestamp");
		String nonce=request.getParameter("nonce");
		String echostr=request.getParameter("echostr");
		//校验验证
		if(service_Wxservice.check(singnature,timestamp,nonce)) {
		System.out.println("接入成功！");
		PrintWriter out= response.getWriter();
		out.print(echostr);
		out.flush();
		out.close();
 		}else {
			System.out.println("接入失败！");
 		}

   }
   protected void doPost(HttpServletRequest request,HttpServletResponse response)
   {
	   System.out.println("传入成功 程序已接受到服务器消息");
   }
	
}
