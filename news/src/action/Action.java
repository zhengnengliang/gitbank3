package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����ӿڣ����������ʵ�ֽӿ���������Ʒ��
public interface Action {
		public void excute(HttpServletRequest request,HttpServletResponse response);

}
