package cn.smbms.interceptor;


import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.smbms.pojo.User;

public class AccessInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		User userSession = (User)request.getSession().getAttribute("userSession");

		String[] noInterceptot={"/userfff/dologin.html","/userfff/login.html","/userfff/errorjsp"};
		String path=request.getServletPath();
		if(!Arrays.asList(noInterceptot).contains(path)){
	if(null == userSession){
		response.sendRedirect("userfff/errorjsp");
			return false;
		}else{
			return true;
		}
		
	}
		return false;
		}

}
