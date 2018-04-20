package cn.smbms.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.smbms.pojo.User;

public class SysFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
//		System.out.println("TestFilter init()===========");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("SysFilter doFilter()===========");
		/*
		HttpServletRequest rq = (HttpServletRequest)request;
		HttpServletResponse rp = (HttpServletResponse)response;*/
		User userSession = (User)((HttpServletRequest) request).getSession().getAttribute("userSession");
		
		String[] noInterceptot={"/userfff/dologin.html","/userfff/login.html","/userfff/errorjsp"};
		String path=((HttpServletRequest) request).getServletPath();
		if(!Arrays.asList(noInterceptot).contains(path)){
			//判断noIntercepot中是否包括path对象，如果有的情况下，就返回true没有的情况就返回flase
		if(null == userSession){
			//((HttpServletResponse) response).sendRedirect("userfff/errorjsp");
		((HttpServletResponse) response).sendRedirect("userfff/login.html");
		}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
//		System.out.println("TestFilter destroy()===========");
	}

}
