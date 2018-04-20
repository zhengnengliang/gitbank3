package cn.smbms.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.service.user.UserServiceImpl;
import cn.smbms.tools.Constants;
@Controller("login")
public class UserLoginAction  implements Action {
	@Resource 
	UserService userService;
	
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login ============ " );
		//��ȡ�û���������
		String userCode = request.getParameter("userCode");
		String userPassword = request.getParameter("userPassword");
		//����service�����������û�ƥ��
		User user = userService.login(userCode,userPassword);
		if(null != user){//��¼�ɹ�
			//����session
			request.getSession().setAttribute(Constants.USER_SESSION, user);
			//ҳ����ת��frame.jsp��
			response.sendRedirect("jsp/frame.jsp");
		}else{
			//ҳ����ת��login.jsp��������ʾ��Ϣ--ת��
			request.setAttribute("error", "�û��������벻��ȷ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}
}