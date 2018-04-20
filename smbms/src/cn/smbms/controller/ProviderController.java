package cn.smbms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.tools.Constants;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

//String method = request.getParameter("method");
//if(method != null && method.equals("query")){
//	this.query(request,response);
//}else if(method != null && method.equals("add")){
//	this.add(request,response);
//}else if(method != null && method.equals("view")){
//	this.getProviderById(request,response,"providerview.jsp");
//}else if(method != null && method.equals("modify")){
//	this.getProviderById(request,response,"providermodify.jsp");
//}else if(method != null && method.equals("modifysave")){
//	this.modify(request,response);
//}else if(method != null && method.equals("delprovider")){
//	this.delProvider(request,response);
//}
@Controller
@RequestMapping("/provider")
public class ProviderController {
	 private static Logger logger = Logger.getLogger(ProviderController.class);
	@Resource
	public ProviderService providerService;
	
	@RequestMapping("/delProvider")
	public void delProvider(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("proid");
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if(!StringUtils.isNullOrEmpty(id)){
			
			int flag = providerService.deleteProviderById(id);
			if(flag == 0){//閸掔娀娅庨幋鎰
				resultMap.put("delResult", "true");
			}else if(flag == -1){//閸掔娀娅庢径杈Е
				resultMap.put("delResult", "false");
			}else if(flag > 0){//鐠囥儰绶垫惔鏂挎櫌娑撳婀佺拋銏犲礋閿涘奔绗夐懗钘夊灩闂勩倧绱濇潻鏂挎礀鐠併垹宕熼弫锟�
				resultMap.put("delResult", String.valueOf(flag));
			}
		}else{
			resultMap.put("delResult", "notexit");
		}
		//閹跺esultMap鏉烆剚宕查幋鎭搒on鐎电钖勬潏鎾冲毉
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
	
	
	
	//跳转添加用户的页面
	@RequestMapping("/provideradd")//provider1
	public String   provideradd(){
		return  "provideradd";
	}
	
	
	
	@RequestMapping("/providermodify")//跳转到修改页面providermodify.jsp
	public String  providermodify(HttpServletRequest request, HttpServletResponse response,Model model){
		String  id=request.getParameter("proid");	
		Provider providermodify = new Provider();
		providermodify= providerService.getProviderById(id);
		model.addAttribute("providermodify",providermodify);
		return "providermodify";
	}
	
	@RequestMapping("/modify")//provider1
	public String modify(HttpServletRequest request, HttpServletResponse response,Model model)
			throws ServletException, IOException {
		String proContact = request.getParameter("proContact");
		String proPhone = request.getParameter("proPhone");
		String proAddress = request.getParameter("proAddress");
		String proFax = request.getParameter("proFax");
		String proDesc = request.getParameter("proDesc");
		String id = request.getParameter("id");
		Provider provider1 = new Provider();
		provider1.setId(Integer.valueOf(id));
		provider1.setProContact(proContact);
		provider1.setProPhone(proPhone);
		provider1.setProFax(proFax);
		provider1.setProAddress(proAddress);
		provider1.setProDesc(proDesc);
		provider1.setModifyBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
		provider1.setModifyDate(new Date());
		boolean flag = false;
		
		flag = providerService.modify(provider1);
		if(flag){
			return  "redirect:/provider/query";
			//response.sendRedirect(request.getContextPath()+"/jsp/provider.do?method=query");
		}else{
			model.addAttribute("provider1", provider1);
			return "providermodify";
			//request.getRequestDispatcher("providermodify.jsp").forward(request, response);
		}
	}
	
	
			@RequestMapping(value="/main.html")
			public String main(){
				return "providermodify";
			}
	
			@RequestMapping("/getProviderById1")
			public String getProviderById1(HttpServletRequest request, HttpServletResponse response,String url,Model model)
					throws ServletException, IOException {
				String id = request.getParameter("proid");
				if(!StringUtils.isNullOrEmpty(id)){
					
					Provider provider = null;
					provider = providerService.getProviderById(id);
					model.addAttribute("provider",provider);
					return "providerview";
					//request.setAttribute("provider", provider);
					//request.getRequestDispatcher(url).forward(request, response);
				}
				 logger.debug("#################################/getProviderById1#####"); 
				return "";
			}
			
			@RequestMapping("/getProviderById2")
			public String getProviderById2(HttpServletRequest request, HttpServletResponse response,String url,Model model)
					throws ServletException, IOException {
				String id = request.getParameter("proid");
				if(!StringUtils.isNullOrEmpty(id)){
					
					Provider provider = null;
					provider = providerService.getProviderById(id);
					model.addAttribute("provider",provider);
					return "providermodify";
					//request.setAttribute("provider", provider);
					//request.getRequestDispatcher(url).forward(request, response);
				}
				 logger.debug("#################################/getProviderById2#####");
				return "";
			}
			
			
			
			
			@RequestMapping("/add")//provider2
			public String add(HttpServletRequest request, HttpServletResponse response,Model model)
					throws ServletException, IOException {
				String proCode = request.getParameter("proCode");
				String proName = request.getParameter("proName");
				String proContact = request.getParameter("proContact");
				String proPhone = request.getParameter("proPhone");
				String proAddress = request.getParameter("proAddress");
				String proFax = request.getParameter("proFax");
				String proDesc = request.getParameter("proDesc");
				
				Provider provider2 = new Provider();
				provider2.setProCode(proCode);
				provider2.setProName(proName);
				provider2.setProContact(proContact);
				provider2.setProPhone(proPhone);
				provider2.setProFax(proFax);
				provider2.setProAddress(proAddress);
				provider2.setProDesc(proDesc);
				provider2.setCreatedBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
				provider2.setCreationDate(new Date());
				boolean flag = false;
				
				flag = providerService.add(provider2);
				if(flag){
					return "redirect:/provider/query";
					//response.sendRedirect(request.getContextPath()+"/jsp/provider.do?method=query");
				}else{
					model.addAttribute("provider2", provider2);
					return "provideradd";
					//request.getRequestDispatcher("provideradd.jsp").forward(request, response);
				}
			}
			
			
	
			@RequestMapping("/query")
			public String query(HttpServletRequest request, HttpServletResponse response,Model model)
					throws ServletException, IOException {
				String queryProName = request.getParameter("queryProName");
				String queryProCode = request.getParameter("queryProCode");
				if(StringUtils.isNullOrEmpty(queryProName)){
					queryProName = "";
				}
				if(StringUtils.isNullOrEmpty(queryProCode)){
					queryProCode = "";
				}
				List<Provider> providerList = new ArrayList<Provider>();
				
				providerList = providerService.getProviderList(queryProName,queryProCode);
				model.addAttribute("providerList", providerList);
				model.addAttribute("queryProName", queryProName);
				model.addAttribute("queryProCode", queryProCode);
				return "providerlist";
				/*request.setAttribute("providerList", providerList);
				request.setAttribute("queryProName", queryProName);
				request.setAttribute("queryProCode", queryProCode);
				request.getRequestDispatcher("providerlist.jsp").forward(request, response);*/
			}
			
}