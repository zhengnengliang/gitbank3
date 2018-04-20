package cn.smbms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.role.RoleService;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;


@Controller
@RequestMapping("/user")
public class UserController1 {
	
		private Logger logger=Logger.getLogger(UserController1.class);
		@Resource
		private UserService userService;
		
		@Resource
		public RoleService roleService;
		
	
		
		
		@RequestMapping(value="/login.html")
		public String login(){
			logger.debug("UserCotroller welcome SMBMS=================");
			return "login";
		}
		
		@RequestMapping(value="/dologin.html",method=RequestMethod.POST)
		public String dologin(
			@RequestParam String userCode,
			@RequestParam String userPassword){
			logger.debug("dologin====================");
			//调用service方法，进行用户匹配
			User user=userService.login(userCode, userPassword);
			if(null!=user){
				//登录成功
				//页面条用（frame.jsp）
				return "redirect:/user/main.html";
				
			}else{
				//页面跳转（login.jsp）
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
			//调用service方法进行用户匹配
			User user=userService.login(userCode, userPassword);
			if(null==user){
				//登录失败
				throw new RuntimeException("用户名或者密码不正确");
			}
			return "redirect:/user/main.html";
		}
		
		//局部异常处理
		/*@ExceptionHandler(value={RuntimeException.class})
		public String handlerException(RuntimeException e,HttpServletRequest req){
			req.setAttribute("e", e);
			return "error";
		}*/
		
		
		//添加用户方法
		@RequestMapping(value="/useradd.html",method=RequestMethod.GET)
		public  String addUser(@ModelAttribute("user") User user){
			return "useradd";
		}
		
		
		//添加用户信息
		@RequestMapping(value="/addsave.html",method=RequestMethod.POST)
		public String addUserSave( User user,HttpSession session){
			user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
			user.setCreationDate(new Date());
			if(userService.add(user)){
				return "redirect:/user/userlist.html";
			}
			return "useradd";
		}
		
		@RequestMapping(value="/add.html",method=RequestMethod.GET)
		public String add(@ModelAttribute("user") User user){
			return "user/useradd";
		}
//		@RequestMapping(value="/add.html",method=RequestMethod.POST)//!!!!!!!!!!!!!!!!
//		public String add(@Valid User user,HttpSession session){
//			user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
//			user.setCreationDate(new Date());
//			if(userService.add(user)){
//				return "redirect:/user/userlist.html";
//			}
//			return "user/useradd";
//		}
		
	   //表单验证
		@RequestMapping(value="/add .html",method=RequestMethod.POST)//!!!!!!!!!!!!
		public String addsave(@Valid User user,BindingResult bindingResult,HttpSession session){
			if(bindingResult.hasErrors()){
				logger.debug("add user validated has error======");
				return "user/useradd";
			}
			user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
			user.setCreationDate(new Date());
			if(userService.add(user)){
				return "redirect:/user/userlist.html";
			}
			return "user/useradd";
		}
		
		//根据用户id获取用户信息
		@RequestMapping(value="/usermodify.html",method=RequestMethod.GET)
		public String getUserById(@RequestParam String uid,Model model){
			logger.debug("getUserById uid========="+uid);
			  int a=Integer.parseInt(uid);
			User user=userService.getUserById(a);
			model.addAttribute(user);
			return "usermodify";
		}
		//根据用户id保存修改用户的信息
		@RequestMapping(value="/usermodifysave.html",method=RequestMethod.POST)
		public String modifyUserSave(User user,HttpSession session){
			logger.debug("modifyUserSave userid========"+user.getId());
			user.setModifyBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
			user.setModifyDate(new Date());
			if(userService.modify(user)){
				return "redirect:user/userlist.html";
			}
			
			return "usermodify";
		}
		
		
		
		
		
		
		
		//根据用户id查看用户明细功能
		@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
		public String view(@PathVariable String id,Model model){
			logger.debug("view id=========="+id);
			 int a=Integer.parseInt(id);
			User user=userService.getUserById(a);
			model.addAttribute(user);
			return "userview";
		}
		@RequestMapping(value="/userlist.html")
		public  String getUserList(Model model,
				@RequestParam(value="queryname",required=false) String queryUserName,
				@RequestParam(value="queryUserRole",required=false) String queryUserRole,
				@RequestParam(value="pageIndex",required=false) String pageIndex
				){
			
			logger.info("getUserList--->queryUserName:"+queryUserName);
			logger.info("getUserList--->queryUserRole:"+queryUserRole);
			logger.info("getUserList--->pageIndex:"+pageIndex);
			int _queryUserRole1 = 0;
			List<User> userList = null;
			//设置页面容量
	    	int pageSize = Constants.pageSize;
	    	 //当前页码
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
					return"redirect:/user/syserror.html";
				}
	    	}
	    	//总数量（表）	
	    	int totalCount	= userService.getUserCount(queryUserName,_queryUserRole1);
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
			
			
			userList = userService.getUserList(queryUserName,_queryUserRole1,currentPageNo, pageSize);
			model.addAttribute("userList",userList);
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
		
	}


