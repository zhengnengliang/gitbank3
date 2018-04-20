package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//定义接口，（让下面的实现接口来产生产品）
public interface Action {
		public void excute(HttpServletRequest request,HttpServletResponse response);

}
