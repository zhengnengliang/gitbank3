package cn.smbms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.smbms.action.Action;
import cn.smbms.action.ActionFactory;

public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url=request.getRequestURI();
		String control=url.substring(url.lastIndexOf('/')+1,url.indexOf('.'));
		Action a=(Action) ActionFactory.factory(control);
		a.excute(request, response);
	}
}
