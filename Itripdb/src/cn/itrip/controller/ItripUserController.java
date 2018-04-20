package cn.itrip.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.service.itriphotel.ItripUserService;
import cn.itrip.tools.Constants;



@Controller
@RequestMapping("/login")
public class ItripUserController {
	private Logger logger =Logger.getLogger(ItripUserController.class);
	@Resource
	private ItripUserService itripUserService;
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping(value="/login.html")
	public String login(){
		return "login";
	}
	
	
	/**
	 * 主页面
	 * @return
	 */
	@RequestMapping(value="/index.html")
	public String index(){
		return "index";
	}
	
	/**
	 * 进入注册页面
	 * @return
	 */
	@RequestMapping(value="/register.html")
	public String register(){
		
		return "register";
	}
	
	/**
	 * 进入旅游页面
	 * @return
	 */
	@RequestMapping(value="/methodDetail.html")
	public String methodDetail(){
		
		return "methodDetail";
	}
	
	/**
	 * 进入攻略页面
	 * @return
	 */
	@RequestMapping(value="/strategyindex.html")
	public String travelindex(){
		
		return "/strategy/index";
	}
	
	/**
	 * 新增手机用户
	 * @return
	 *//*
	@RequestMapping(value="/addregister1.html")
	public String addregister1(@RequestParam String userCode1,@RequestParam String userPassword1,HttpSession session,HttpServletRequest request){
		//调用service方法，进行用户匹配
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println(userCode1+"                       "+userPassword1);
				int i = itripUserService.addItripUser(userCode1, userPassword1);
				System.out.println(user.getUserCode());
				System.out.println(user.getUserPassword());
				if(i>0){	//新增失败	
					request.setAttribute("error", "用户名不存在");	
					return "login";		
					return "redirect:/login/login.html";
				}
				return "register";
	}*/
	
	/**
	 * 新增手机用户
	 * @return
	 */
	@RequestMapping(value="/addregister1.html")
	public String addregister1(ItripUser itripUser,HttpSession session,HttpServletRequest request){
		//调用service方法，进行用户匹配
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		itripUser.setUserType("0");
		itripUser.setCreationDate(new Date());
		itripUser.setActivated(1);
				int i = itripUserService.addItripUser(itripUser);
				/*System.out.println(user.getUserCode());
				System.out.println(user.getUserPassword());*/
				if(i>0){	//新增失败	
					/*request.setAttribute("error", "用户名不存在");	
					return "login";*/		
					return "redirect:/login/login.html";
				}
				return "register";
	}
	
	/**
	 * 新增邮箱用户
	 * @return
	 *//*
	@RequestMapping(value="/addregister.html")
	public String addregister(@RequestParam String userCode,@RequestParam String userPassword,HttpSession session,HttpServletRequest request){
		//调用service方法，进行用户匹配
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println(userCode+"                       "+userPassword);
				int i = itripUserService.addItripUser(userCode, userPassword);
				System.out.println(user.getUserCode());
				System.out.println(user.getUserPassword());
				if(i>0){	//登录失败	
					request.setAttribute("error", "用户名不存在");	
					return "login";		
					return "redirect:/login/login.html";
				}
				return "register";
	}*/
	
	/**
	 * 新增邮箱用户
	 * @return
	 */
	@RequestMapping(value="/addregister.html")
	public String addregister(ItripUser itripUser,HttpSession session,HttpServletRequest request){
		//调用service方法，进行用户匹配
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		itripUser.setUserType("0");
		itripUser.setCreationDate(new Date());
		itripUser.setActivated(1);
				int i = itripUserService.addItripUser(itripUser);
				/*System.out.println(user.getUserCode());
				System.out.println(user.getUserPassword());*/
				if(i>0){	//登录失败	
					/*request.setAttribute("error", "用户名不存在");	
					return "login";*/		
					return "redirect:/login/login.html";
				}
				return "register";
	}
	
	
	/**
	 * 登录验证
	 * @param userCode
	 * @param userPassword
	 * @param session
	 * @param request
	 * @return
	 */
	
	@RequestMapping(value="/dologin.html",method=RequestMethod.POST)
	public String doLogin(@RequestParam String userCode,@RequestParam String userPassword,HttpSession session,HttpServletRequest request) {
		logger.debug("doLogin==========================================");
		
		//调用service方法，进行用户匹配
		System.out.println(userCode+"                       "+userPassword);
		ItripUser user = itripUserService.login(userCode, userPassword);
		userPassword=userPassword;
		/*System.out.println(user.getUserCode());
		System.out.println(user.getUserPassword());*/
		if(null==user){	//登录失败	
			/*request.setAttribute("error", "用户名不存在");	
			return "login";*/		
			throw new RuntimeException("该用户不存在!");
		}else if(!userPassword.equals(user.getUserPassword())){
			//页面跳转（login.jsp）带出提示信息一一转发
			/*request.setAttribute("error", "密码不正确");
			return "login";*/
			throw new RuntimeException("密码不正确！");
		}else{
			//放入session
			session.setAttribute(Constants.USER_SESSION, user);
			//页面跳转（frame.jsp）
			return "redirect:/login/index.html";
			//response.sendRedirect(jsp/frame.jsp);
		}
	}
	
	/**
	 * 检测手机号和邮箱号是否已经注册过
	 * @param userCode
	 * @param userPassword
	 * @param session
	 * @param request
	 * @return
	 */
	
	@RequestMapping(value="/getName.html",method=RequestMethod.GET)
	@ResponseBody
	public String getNamr(@RequestParam String name,HttpSession session,HttpServletRequest request) {
		System.out.println("||||||||||||||||||||||||||||||||||||||||||");
		String tr="false";
		ItripUser user = itripUserService.login(name, name);
		if(user!=null){
			tr="true";
		}
		System.out.println(tr);
		return tr;
	}
}
