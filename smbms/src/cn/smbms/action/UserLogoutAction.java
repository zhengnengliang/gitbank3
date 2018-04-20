package cn.smbms.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import cn.smbms.tools.Constants;
@Controller("logout")
public class UserLogoutAction implements Action{
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute(Constants.USER_SESSION);
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		
	}
}
