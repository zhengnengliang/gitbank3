package cn.smbms.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.smbms.action.Action;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.role.RoleService;
import cn.smbms.service.role.RoleServiceImpl;
import cn.smbms.service.user.UserService;
import cn.smbms.service.user.UserServiceImpl;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;


/*System.out.println("method----> " + method);

if(method != null && method.equals("add")){
	//增加操作
	this.add(request, response);
}else if(method != null && method.equals("query")){
	this.query(request, response);
}else if(method != null && method.equals("getrolelist")){
	this.getRoleList(request, response);
}else if(method != null && method.equals("ucexist")){
	this.userCodeExist(request, response);
}else if(method != null && method.equals("deluser")){
	this.delUser(request, response);
}else if(method != null && method.equals("view")){
	this.getUserById1(request, response,"userview.jsp");
}else if(method != null && method.equals("modify")){
	this.getUserById2(request, response,"usermodify.jsp");
}else if(method != null && method.equals("modifyexe")){
	this.modify(request, response);
}else if(method != null && method.equals("pwdmodify")){
	this.getPwdByUserId(request, response);
}else if(method != null && method.equals("savepwd")){
	this.updatePwd(request, response);
}*/
@Controller
@RequestMapping("/user")
public class user {



	@Resource
	public UserService userService;
	@Resource
	public RoleService roleService;
	
	@RequestMapping("/updatePwd")
	private ModelAndView updatePwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mav = new ModelAndView();
		Object o = request.getSession().getAttribute(Constants.USER_SESSION);
		String newpassword = request.getParameter("newpassword");
		boolean flag = false;
		if(o != null && !StringUtils.isNullOrEmpty(newpassword)){
			flag = userService.updatePwd(((User)o).getId(),newpassword);
			if(flag){
				mav.addObject(Constants.SYS_MESSAGE,"修改密码成功,请退出并使用新密码重新登录！");
			//	request.setAttribute(Constants.SYS_MESSAGE, "修改密码成功,请退出并使用新密码重新登录！");
				request.getSession().removeAttribute(Constants.USER_SESSION);//session注销
			}else{
				mav.addObject(Constants.SYS_MESSAGE,"修改密码失败！");
				//request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
			}
		}else{
			mav.addObject(Constants.SYS_MESSAGE, "修改密码失败！");
			//request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
		}
		mav.setViewName("pwdmodify.jsp");
		return  mav;
		//request.getRequestDispatcher("pwdmodify.jsp").forward(request, response);
	}
	
	
	
	
	
	
	
	@RequestMapping("/getPwdByUserId")
	private void getPwdByUserId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object o = request.getSession().getAttribute(Constants.USER_SESSION);
		String oldpassword = request.getParameter("oldpassword");
		Map<String, String> resultMap = new HashMap<String, String>();
		
		if(null == o ){//session过期
			resultMap.put("result", "sessionerror");
		}else if(StringUtils.isNullOrEmpty(oldpassword)){//旧密码输入为空
			resultMap.put("result", "error");
		}else{
			String sessionPwd = ((User)o).getUserPassword();
			if(oldpassword.equals(sessionPwd)){
				resultMap.put("result", "true");
			}else{//旧密码输入不正确
				resultMap.put("result", "false");
			}
		}
		
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
	
	
	
	@RequestMapping("/modify")//user!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	private String  modify(HttpServletRequest request, HttpServletResponse response,Model model)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String userRole = request.getParameter("userRole");
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setUserName(userName);
		user.setGender(Integer.valueOf(gender));
		try {
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setPhone(phone);
		user.setAddress(address);
		user.setUserRole(Integer.valueOf(userRole));
		user.setModifyBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
		user.setModifyDate(new Date());
		
		if(userService.modify(user)){
			return  "redirect:/user/query";
			//response.sendRedirect(request.getContextPath()+"/jsp/user.do?method=query");
		}else{
			model.addAttribute("user",user);
			return "usermodify";
			
			//request.getRequestDispatcher("usermodify.jsp").forward(request, response);
		}
	}
	
	
	@RequestMapping("/getUserById")//user1
	private String getUserById1(HttpServletRequest request, HttpServletResponse response,String url,Model model)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		if(!StringUtils.isNullOrEmpty(id)){
			//调用后台方法得到user对象
			int uid=Integer.parseInt(id);
			User user1 = userService.getUserById(uid);
			model.addAttribute("user1", user1);
			return "userview";
			//request.setAttribute("user", user1);
			//request.getRequestDispatcher(url).forward(request, response);
		}
		return "";
		
	}
	
	
	
	@RequestMapping("/delUser")//!!!!!!!!!!!!!!!!!!
	private void delUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		Integer delId = 0;
		try{
			delId = Integer.parseInt(id);
		}catch (Exception e) {
			// TODO: handle exception
			delId = 0;
		}
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if(delId <= 0){
			resultMap.put("delResult", "notexist");
		}else{
			if(userService.deleteUserById(delId)){
				resultMap.put("delResult", "true");
			}else{
				resultMap.put("delResult", "false");
			}
		}
		
		//把resultMap转换成json对象输出
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
	
	
	@RequestMapping("/userCodeExist")//!!!!!!!!!!!!!!!
	private void userCodeExist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断用户账号是否可用
		String userCode = request.getParameter("userCode");
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if(StringUtils.isNullOrEmpty(userCode)){
			//userCode == null || userCode.equals("")
			resultMap.put("userCode", "exist");
		}else{
			User user = userService.selectUserCodeExist(userCode);
			if(null != user){
				resultMap.put("userCode","exist");
			}else{
				resultMap.put("userCode", "notexist");
			}
		}
		
		//把resultMap转为json字符串以json的形式输出
		//配置上下文的输出类型
		response.setContentType("application/json");
		//从response对象中获取往外输出的writer对象
		PrintWriter outPrintWriter = response.getWriter();
		//把resultMap转为json字符串 输出
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();//刷新
		outPrintWriter.close();//关闭流
	}
	
	
	@RequestMapping("/getRoleList")//!!!!!!!!!!!!!!!!!!!!
	private void getRoleList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Role> roleList = null;
		roleList = roleService.getRoleList();
		//把roleList转换成json对象输出
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(roleList));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
	
	
	
	
	@RequestMapping("/query")//!!!!!!
	private String  query(HttpServletRequest request, HttpServletResponse response,Model model)
			throws ServletException, IOException {
		//查询用户列表
		String queryUserName = request.getParameter("queryname");
		String temp = request.getParameter("queryUserRole");
		String pageIndex = request.getParameter("pageIndex");
		int queryUserRole = 0;
		List<User> userList = null;
		//设置页面容量
    	int pageSize = Constants.pageSize;
    	//当前页码
    	int currentPageNo = 1;
		/**
		 * http://localhost:8090/SMBMS/userlist.do
		 * ----queryUserName --NULL
		 * http://localhost:8090/SMBMS/userlist.do?queryname=
		 * --queryUserName ---""
		 */
		System.out.println("queryUserName servlet--------"+queryUserName);  
		System.out.println("queryUserRole servlet--------"+queryUserRole);  
		System.out.println("query pageIndex--------- > " + pageIndex);
		if(queryUserName == null){
			queryUserName = "";
		}
		if(temp != null && !temp.equals("")){
			queryUserRole = Integer.parseInt(temp);
		}
		
    	if(pageIndex != null){
    		try{
    			currentPageNo = Integer.valueOf(pageIndex);
    		}catch(NumberFormatException e){
    			return "error";
    			//response.sendRedirect("error.jsp");
    		}
    	}	
    	//总数量（表）	
    	int totalCount	= userService.getUserCount(queryUserName,queryUserRole);
    	//总页数
    	PageSupport pages=new PageSupport();
    	pages.setCurrentPageNo(currentPageNo);
    	pages.setPageSize(pageSize);
    	pages.setTotalCount(totalCount);
    	
    	int totalPageCount = pages.getTotalPageCount();
    	
    	//控制首页和尾页
    	if(currentPageNo < 1){
    		currentPageNo = 1;
    	}else if(currentPageNo > totalPageCount){
    		currentPageNo = totalPageCount;
    	}
		
		
		userList = userService.getUserList(queryUserName,queryUserRole,currentPageNo, pageSize);
		model.addAttribute("userList", userList);
		//request.setAttribute("userList", userList);
		List<Role> roleList = null;
		roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		model.addAttribute("queryUserName", queryUserName);
		model.addAttribute("queryUserRole", queryUserRole);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
        return "userlist";		
//		request.setAttribute("roleList", roleList);
//		request.setAttribute("queryUserName", queryUserName);
//		request.setAttribute("queryUserRole", queryUserRole);
//		request.setAttribute("totalPageCount", totalPageCount);
//		request.setAttribute("totalCount", totalCount);
//		request.setAttribute("currentPageNo", currentPageNo);
//		request.getRequestDispatcher("userlist.jsp").forward(request, response);
	}
	
	
	
	@RequestMapping("/add")//user3!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	private String add(HttpServletRequest request, HttpServletResponse response,Model model)
			throws ServletException, IOException {
		System.out.println("add()================");
		String userCode = request.getParameter("userCode");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String userRole = request.getParameter("userRole");
		
		User user3 = new User();
		user3.setUserCode(userCode);
		user3.setUserName(userName);
		user3.setUserPassword(userPassword);
		user3.setAddress(address);
		try {
			user3.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user3.setGender(Integer.valueOf(gender));
		user3.setPhone(phone);
		user3.setUserRole(Integer.valueOf(userRole));
		user3.setCreationDate(new Date());
		user3.setCreatedBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
		
		if(userService.add(user3)){
			return  "redirect:/user/query";
			//response.sendRedirect(request.getContextPath()+"/jsp/user.do?method=query");
		}else{
			model.addAttribute("user3", user3);
			return "useradd";
			//request.getRequestDispatcher("useradd.jsp").forward(request, response);
		}
	}
}
