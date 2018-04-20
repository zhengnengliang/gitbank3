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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

import cn.smbms.pojo.User;
import cn.smbms.pojo.Role;
import cn.smbms.service.role.RoleService;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;

/*if(method != null && method.equals("add")){
	//���Ӳ���
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
@RequestMapping("/userfff")
public class UserController {
	public Logger logger=Logger.getLogger(UserController.class);
	@Resource
	public UserService userService;
	@Resource
	public RoleService roleService;
	//ooooooooo
	@RequestMapping(value="/useraddjsp")//������useradd.jsp��
	public String addjsp(){
		return "useradd";
		
	}
	
	@RequestMapping(value="/pwdmodifyjsp")//������pwdmodifyjsp
	public String pwdmodifyjsp(){
		return "pwdmodify";
	}
	
	
	@RequestMapping(value="/errorjsp")//������pwdmodifyjsp
	public String errorjsp(){
		return "error";
	}
	
	@RequestMapping(value="/billlistjsp")//������
	public String billlistjsp(){
		return "billlist";
	}
	

	@RequestMapping(value="/login.html")
	public String login(){
		logger.debug("UserCotroller welcome SMBMS=================");
		return "login";
	}
	
	
	
	
	@RequestMapping(value="/userlist")
	public  String getUserList(Model model,
			@RequestParam(value="queryname",required=false) String queryUserName,
			@RequestParam(value="queryUserRole",required=false) String queryUserRole,
			@RequestParam(value="pageIndex",required=false) String pageIndex
			){
		
		logger.info("getUserList--->queryUserName:"+queryUserName);
		logger.info("getUserList--->queryUserRole:"+queryUserRole);
		logger.info("getUserList--->pageIndex:"+pageIndex);
		int _queryUserRole1 = 0;
		List<User> userList1 = null;
		//����ҳ������
    	int pageSize = Constants.pageSize;
    	 //��ǰҳ��
    	int currentPageNo=1;
    	if(queryUserName ==null){
    		queryUserName="";
    	}
    	if(queryUserRole !=null && !queryUserRole.equals("")){
    		_queryUserRole1=Integer.parseInt(queryUserRole);
    	}
    	if(pageIndex !=null){
    		try {
				currentPageNo =Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				return "redirect:/userfff/syserror.html";
			}
    	}
    	//����������	
    	int totalCount	= userService.getUserCount(queryUserName,_queryUserRole1);
    	//��ҳ��
    	PageSupport pages=new PageSupport();
    	pages.setCurrentPageNo(currentPageNo);
    	pages.setPageSize(pageSize);
    	pages.setTotalCount(totalCount);
    	
    	int totalPageCount = pages.getTotalPageCount();
    	//������ҳ��βҳ
    	if(currentPageNo < 1){
    		currentPageNo = 1;
    	}else if(currentPageNo > totalPageCount){
    		currentPageNo = totalPageCount;
    	}
		
		
		userList1 = userService.getUserList(queryUserName,_queryUserRole1,currentPageNo, pageSize);
		model.addAttribute("userList1",userList1);
	   int y= userList1.size();
		List<Role> roleList =null;
		roleList=roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		model.addAttribute("queryUserName", queryUserName);
		model.addAttribute("queryUserRole", _queryUserRole1);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);		
    	return "userlist";
    	
		
	}
	
	
	
	
	
	@RequestMapping(value="/dologin.html",method=RequestMethod.POST)
	public String dologin(HttpServletRequest request, HttpServletResponse response,
		@RequestParam String userName,
		@RequestParam String userPassword){
		logger.debug("dologin====================");
		//����service�����������û�ƥ��
		HttpSession userSession=request.getSession();
		User user=userService.login(userName, userPassword);
		if(null!=user){
			//��¼�ɹ�
			//ҳ�����ã�frame.jsp��
			userSession.setAttribute(Constants.USER_SESSION, user);
			System.out.println(user.getUserName());
			return "redirect:/userfff/main.html";
			
		}else{
			//ҳ����ת��login.jsp��
			return "login";
		}
		}
	@RequestMapping(value="/main.html")
	public String main(){
		return "frame";
	}
	
	

	
	
	
	
	
	
	
	
	@RequestMapping(value="exlogin.html",method=RequestMethod.GET)
	public String exLogin(@RequestParam String userCode,
							@RequestParam String userPassword){
		logger.debug("exLogin=====================================");
		//����service���������û�ƥ��
		User user=userService.login(userCode, userPassword);
		if(null==user){
			//��¼ʧ��
			throw new RuntimeException("�û����������벻��ȷ");
		}
		return "redirect:/user/main.html";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/updatePwd")
	public ModelAndView updatePwd(HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		System.out.println("����");
		ModelAndView mav = new ModelAndView();
		Object o = request.getSession().getAttribute(Constants.USER_SESSION);
		String newpassword = request.getParameter("newpassword");
		boolean flag = false;
		if(o != null && !StringUtils.isNullOrEmpty(newpassword)){
			flag = userService.updatePwd(((User)o).getId(),newpassword);
			if(flag){
				mav.addObject(Constants.SYS_MESSAGE,"�޸�����ɹ�,���˳���ʹ�����������µ�¼��");
			//	request.setAttribute(Constants.SYS_MESSAGE, "�޸�����ɹ�,���˳���ʹ�����������µ�¼��");
				request.getSession().removeAttribute(Constants.USER_SESSION);//sessionע��
			}else{
				mav.addObject(Constants.SYS_MESSAGE,"�޸�����ʧ�ܣ�");
				//request.setAttribute(Constants.SYS_MESSAGE, "�޸�����ʧ�ܣ�");
			}
		}else{
			mav.addObject(Constants.SYS_MESSAGE, "�޸�����ʧ�ܣ�");
			//request.setAttribute(Constants.SYS_MESSAGE, "�޸�����ʧ�ܣ�");
		}
		mav.setViewName("frame");
		return  mav;
		//request.getRequestDispatcher("pwdmodify.jsp").forward(request, response);
	}
	
	
	
	
	@RequestMapping("/getPwdByUserId")
	public void getPwdByUserId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object o = request.getSession().getAttribute(Constants.USER_SESSION);
		String oldpassword = request.getParameter("oldpassword");
		Map<String, String> resultMap = new HashMap<String, String>();
		
		if(null == o ){//session����
			resultMap.put("result", "sessionerror");
		}else if(StringUtils.isNullOrEmpty(oldpassword)){//����������Ϊ��
			resultMap.put("result", "error");
		}else{
			String sessionPwd = ((User)o).getUserPassword();
			if(oldpassword.equals(sessionPwd)){
				resultMap.put("result", "true");
			}else{//���������벻��ȷ
				resultMap.put("result", "false");
			}
		}
		
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
	
	public String getUserPassword() {
		// TODO Auto-generated method stub
		return null;
	}




	@RequestMapping("/modify")//user
	public String  modify(HttpServletRequest request, HttpServletResponse response,Model model)
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
			return  "redirect:/userfff/query";
			//response.sendRedirect(request.getContextPath()+"/jsp/user.do?method=query");
		}else{
			model.addAttribute("user",user);
			return "usermodify";
			
			//request.getRequestDispatcher("usermodify.jsp").forward(request, response);
		}
	}
	
	




	@RequestMapping("/getUserById1")//user1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String getUserById1(HttpServletRequest request, HttpServletResponse response,String url,Model model)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		if(!StringUtils.isNullOrEmpty(id)){
			//���ú�̨�����õ�user����
			int uid=Integer.parseInt(id);
			User user1 = userService.getUserById(uid);
			model.addAttribute("user1", user1);
			return "userview";
			//request.setAttribute("user", user1);
			//request.getRequestDispatcher(url).forward(request, response);
		}
		return "";
		
	}
	
	
	
	

	@RequestMapping("/getUserById2")//user4!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String getUserById2(HttpServletRequest request, HttpServletResponse response,String url,Model model)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		if(!StringUtils.isNullOrEmpty(id)){
			//���ú�̨�����õ�user����
			int uid=Integer.parseInt(id);
			User user1 = userService.getUserById(uid);
			model.addAttribute("user4", user1);
			return "usermodify";
			//request.setAttribute("user", user1);
			//request.getRequestDispatcher(url).forward(request, response);
		}
		return "";
		
	}
	
	
	//ɾ���û�
	@RequestMapping("/delUser")
	public void delUser(HttpServletRequest request, HttpServletResponse response)
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
		
		//��resultMapת����json�������
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
	
	//oooooooooo
	@RequestMapping("/userCodeExist")
	public void userCodeExist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ж��û��˺��Ƿ����
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
		
		//��resultMapתΪjson�ַ�����json����ʽ���
		//���������ĵ��������
		response.setContentType("application/json");
		//��response�����л�ȡ���������writer����
		PrintWriter outPrintWriter = response.getWriter();
		//��resultMapתΪjson�ַ��� ���
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();//ˢ��
		outPrintWriter.close();//�ر���
	}
	
	
	@RequestMapping("/getRoleList")
	public void getRoleList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Role> roleList = null;
		roleList = roleService.getRoleList();
		//��roleListת����json�������
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(roleList));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
	
	
	
	@RequestMapping("/add")//user3
	public String add(HttpServletRequest request, HttpServletResponse response,Model model)
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
	
	
	@RequestMapping("/query")
	public String  query(HttpServletRequest request, HttpServletResponse response,Model model)
			throws ServletException, IOException {
		//��ѯ�û��б�
		String queryUserName = request.getParameter("queryname");
		String temp = request.getParameter("queryUserRole");
		String pageIndex = request.getParameter("pageIndex");
		int queryUserRole = 0;
		List<User> userList = null;
		//����ҳ������
    	int pageSize = Constants.pageSize;
    	//��ǰҳ��
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
    	//����������	
    	int totalCount	= userService.getUserCount(queryUserName,queryUserRole);
    	//��ҳ��
    	PageSupport pages=new PageSupport();
    	pages.setCurrentPageNo(currentPageNo);
    	pages.setPageSize(pageSize);
    	pages.setTotalCount(totalCount);
    	
    	int totalPageCount = pages.getTotalPageCount();
    	
    	//������ҳ��βҳ
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
	
}
