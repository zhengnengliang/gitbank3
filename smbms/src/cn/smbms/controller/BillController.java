package cn.smbms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import cn.smbms.service.bill.BillService;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.tools.Constants;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/bill")
public class BillController  {
	/*String method = request.getParameter("method");
	if(method != null && method.equals("query")){
		this.query(request,response);
	}else if(method != null && method.equals("add")){
		this.add(request,response);
	}else if(method != null && method.equals("view")){
		this.getBillById1(request,response,"billview.jsp");
	}else if(method != null && method.equals("modify")){
		this.getBillById2(request,response,"billmodify.jsp");
	}else if(method != null && method.equals("modifysave")){
		this.modify(request,response);
	}else if(method != null && method.equals("delbill")){
		this.delBill(request,response);
	}else if(method != null && method.equals("getproviderlist")){
		this.getProviderlist(request,response);
	}
	*/
	@Resource
    public  BillService billService;
	@Resource
	public ProviderService providerService;
	
	
	@RequestMapping("/billadd")//跳转添加页面（billadd.jsp）
	public String billadd(){
		return "billadd";
	}
	
	@RequestMapping("/getProviderlist")
	public void getProviderlist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("getproviderlist ========================= ");
		
		List<Provider> providerList = new ArrayList<Provider>();
		providerList = providerService.getProviderList("","");
		//把providerList转换成json对象输出
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(providerList));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
	
	
	
	@RequestMapping("/getBillById1")
	public String getBillById1(HttpServletRequest request, HttpServletResponse response,String url, Model model)
			throws ServletException, IOException {
		String id = request.getParameter("billid");
		if(!StringUtils.isNullOrEmpty(id)){
			Bill bill1 = null;
			bill1 = billService.getBillById(id);
			model.addAttribute("bill1", bill1);
			return "billview";
			
			
//			request.setAttribute("bill", bill);
//			request.getRequestDispatcher(url).forward(request, response);
		}
		return "";
	}
	
	@RequestMapping("/getBillById2")//bill2
	public String  getBillById2(HttpServletRequest request, HttpServletResponse response,String url,Model model )
			throws ServletException, IOException {
		String id = request.getParameter("billid");
		if(!StringUtils.isNullOrEmpty(id)){
			Bill bill2 = null;
			bill2= billService.getBillById(id);
			model.addAttribute("bill2", bill2);
			return "billmodify";
			//request.setAttribute("bill", bill2);
			//request.getRequestDispatcher(url).forward(request, response);
		}
		return "";
	}
	
	
	
	@RequestMapping("/modify")//bill3
	private String modify(HttpServletRequest request, HttpServletResponse response,Model model)
			throws ServletException, IOException {
		System.out.println("modify===============");
		String id = request.getParameter("id");
		String productName = request.getParameter("productName");
		String productDesc = request.getParameter("productDesc");
		String productUnit = request.getParameter("productUnit");
		String productCount = request.getParameter("productCount");
		String totalPrice = request.getParameter("totalPrice");
		String providerId = request.getParameter("providerId");
		String isPayment = request.getParameter("isPayment");
		
		Bill bill3 = new Bill();
		bill3.setId(Integer.valueOf(id));
		bill3.setProductName(productName);
		bill3.setProductDesc(productDesc);
		bill3.setProductUnit(productUnit);
		bill3.setProductCount(new BigDecimal(productCount).setScale(2,BigDecimal.ROUND_DOWN));
		bill3.setIsPayment(Integer.parseInt(isPayment));
		bill3.setTotalPrice(new BigDecimal(totalPrice).setScale(2,BigDecimal.ROUND_DOWN));
		bill3.setProviderId(Integer.parseInt(providerId));
		
		bill3.setModifyBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
		bill3.setModifyDate(new Date());
		boolean flag = false;
		flag = billService.modify(bill3);
		if(flag){
			return  "redirect:/bill/query";
			//response.sendRedirect(request.getContextPath()+"/jsp/bill.do?method=query");
		}else{
			model.addAttribute("bill3", bill3);
			return "billmodify";
			//request.getRequestDispatcher("billmodify.jsp").forward(request, response);
		}
	}
	
	
	@RequestMapping("/delBill")
	public void delBill(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("billid");
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if(!StringUtils.isNullOrEmpty(id)){
			boolean flag = billService.deleteBillById(id);
			if(flag){//删除成功
				resultMap.put("delResult", "true");
			}else{//删除失败
				resultMap.put("delResult", "false");
			}
		}else{
			resultMap.put("delResult", "notexit");
		}
		//把resultMap转换成json对象输出
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
	
	
	@RequestMapping("add")//bill4
	public String add(HttpServletRequest request, HttpServletResponse response,Model model)
			throws ServletException, IOException {
		String billCode = request.getParameter("billCode");
		String productName = request.getParameter("productName");
		String productDesc = request.getParameter("productDesc");
		String productUnit = request.getParameter("productUnit");
		
		String productCount = request.getParameter("productCount");
		String totalPrice = request.getParameter("totalPrice");
		String providerId = request.getParameter("providerId");
		String isPayment = request.getParameter("isPayment");
		
		Bill bill4 = new Bill();
		bill4.setBillCode(billCode);
		bill4.setProductName(productName);
		bill4.setProductDesc(productDesc);
		bill4.setProductUnit(productUnit);
		bill4.setProductCount(new BigDecimal(productCount).setScale(2,BigDecimal.ROUND_DOWN));
		bill4.setIsPayment(Integer.parseInt(isPayment));
		bill4.setTotalPrice(new BigDecimal(totalPrice).setScale(2,BigDecimal.ROUND_DOWN));
		bill4.setProviderId(Integer.parseInt(providerId));
		bill4.setCreatedBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
		bill4.setCreationDate(new Date());
		boolean flag = false;
		flag = billService.add(bill4);
		System.out.println("add flag -- > " + flag);
		if(flag){
			return   "redirect:/bill/query";
			//response.sendRedirect(request.getContextPath()+"/jsp/bill.do?method=query");
		}else{
			model.addAttribute("bill4", bill4);
			return "billadd";
			//request.getRequestDispatcher("billadd.jsp").forward(request, response);
		}
		
	}
	
		
	
	
	
	
	@RequestMapping("/query")
	public String query(HttpServletRequest request, HttpServletResponse response,Model model)
			throws ServletException, IOException {
		
		List<Provider> providerList = new ArrayList<Provider>();
		providerList = providerService.getProviderList("","");
		request.setAttribute("providerList", providerList);
		
		String queryProductName = request.getParameter("queryProductName");
		String queryProviderId = request.getParameter("queryProviderId");
		String queryIsPayment = request.getParameter("queryIsPayment");
		if(StringUtils.isNullOrEmpty(queryProductName)){
			queryProductName = "";
		}
		
		List<Bill> billList = new ArrayList<Bill>();
		Bill bill = new Bill();
		if(StringUtils.isNullOrEmpty(queryIsPayment)){
			bill.setIsPayment(0);
		}else{
			bill.setIsPayment(Integer.parseInt(queryIsPayment));
		}
		
		if(StringUtils.isNullOrEmpty(queryProviderId)){
			bill.setProviderId(0);
		}else{
			bill.setProviderId(Integer.parseInt(queryProviderId));
		}
		bill.setProductName(queryProductName);
		billList = billService.getBillList(bill);
		model.addAttribute("billList", billList);
		model.addAttribute("queryProductName", queryProductName);
		model.addAttribute("queryProviderId", queryProviderId);
		model.addAttribute("queryIsPayment", queryIsPayment);
		return "billlist";
		
//		request.setAttribute("billList", billList);
//		request.setAttribute("queryProductName", queryProductName);
//		request.setAttribute("queryProviderId", queryProviderId);
//		request.setAttribute("queryIsPayment", queryIsPayment);
//		request.getRequestDispatcher("billlist.jsp").forward(request, response);
//		
	}
	
	
	public static void main(String[] args) {
		System.out.println(new BigDecimal("23.235").setScale(2,BigDecimal.ROUND_HALF_DOWN));
	}


}
