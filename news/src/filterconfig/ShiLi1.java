package filterconfig;

import java.io.IOException;



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;



public class ShiLi1 implements Filter {
	private final Logger log=Logger.getLogger(ShiLi1.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
			log.info("��ʼ");
		    arg0.setCharacterEncoding("UTF-8");
			arg1.setCharacterEncoding("UTF-8");
		    arg2.doFilter(arg0, arg1);
		    System.out.println("�˳�");
	        log.info("�˳�C");
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

