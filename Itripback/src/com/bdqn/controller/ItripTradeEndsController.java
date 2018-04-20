package com.bdqn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.alibaba.fastjson.JSONArray;
import com.bdqn.pojo.ItripTradeEnds;
import com.bdqn.service.TradeEnds.ItripTradeEndsService;
import com.mysql.jdbc.StringUtils;

@Controller  
@RequestMapping("/admin/ItripTradeEnds")
public class ItripTradeEndsController {
	private Logger logger =Logger.getLogger(ItripTradeEndsController.class);
	@Resource
	private ItripTradeEndsService itripTradeEndsService;
	/**
	 * 支付宝交易成功中间表字典表管理
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/ItripTradeEnds.do")
	private String query3(
			Model model,
			@RequestParam(value = "Proid", required = false) String Proid) {
		if (StringUtils.isNullOrEmpty(Proid)) {
			Proid = "";
		}
		
		List<ItripTradeEnds> itripTradeEndsList = new ArrayList<ItripTradeEnds>();
		itripTradeEndsList = itripTradeEndsService.selectByPrimaryKey(Proid);
		model.addAttribute("ItripTradeEndsList", itripTradeEndsList);
		model.addAttribute("Proid", Proid);
		/*
		 * request.getRequestDispatcher("providerlist.jsp").forward(request,
		 * response);
		 */
		return "ItripTradeEnds/ItripTradeEndslist";
	}

	/**
	 * 支付宝交易成功中间表字典表增加页面，超连接get
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ItripTradeEndsadd.do", method = RequestMethod.GET)
	public String ItripTradeEndsadd(
			@ModelAttribute("ItripTradeEnds") ItripTradeEnds itripTradeEnds) {
		return "ItripTradeEnds/ItripTradeEndsadd";
	}

	/**
	 * 支付宝交易成功中间表字典表增加页面，form,post
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ItripTradeEndsadd.do", method = RequestMethod.POST)
	public String addItripTradeEndsSava(@Valid ItripTradeEnds itripTradeEnds,
			BindingResult bindingResult, HttpSession session) {
//		if (bindingResult.hasErrors()) {
//			logger.debug("add ItripTradeEnds validated has error====");
//			return "ItripTradeEndsadd";
//		}
		// ItripTradeEnds.setCreatedby(((ItripUser)session.getAttribute(USER_SESSION)).getId());
		//ItripTradeEnds.setCreationdate(new Date());
		if (itripTradeEndsService.insertSelective(itripTradeEnds) > 0) {
			return "redirect:/admin/ItripTradeEnds/ItripTradeEnds.do";
		}
		return "ItripTradeEnds/ItripTradeEndsadd";
	}

	/**
	 * 修改支付宝交易成功中间表字典表信息
	 * 
	 * @param uid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ItripTradeEndsmodify.do", method = RequestMethod.GET)
	public String getItripTradeEndsByName(@RequestParam  String id, Model model) {
		logger.debug("getItripTradeEndsByid id===================" + id);
		List<ItripTradeEnds> itripTradeEnds = itripTradeEndsService.selectByPrimaryKey(id);
		ItripTradeEnds ite = new ItripTradeEnds(itripTradeEnds.get(0).getId(),
				itripTradeEnds.get(0).getOrderno(),itripTradeEnds.get(0).getFlag());
		model.addAttribute(ite);
		return "ItripTradeEnds/ItripTradeEndsmodify";
	}

	@RequestMapping(value = "/ItripTradeEndsmodify.do", method = RequestMethod.POST)
	public String modifyUserSave(ItripTradeEnds itripTradeEnds,
			HttpSession session, HttpServletRequest request) {
		logger.debug("modifyUserSave itripTradeEndsid=============="
				+ itripTradeEnds.getId());
		// ItripTradeEnds.setCreatedby(((ItripUser)session.getAttribute(USER_SESSION)).getId());
		if (itripTradeEndsService.updateByPrimaryKeySelective(itripTradeEnds) > 0) {
			return "redirect:/admin/ItripTradeEnds/ItripTradeEnds.do";
		}
		return "ItripTradeEnds/ItripTradeEndsmodify";
	}

	/**
	 * 查看支付宝交易成功中间表字典表信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ItripTradeEndsview/{id}", method = RequestMethod.GET)
	public String ProviderView(@PathVariable String id, Model model) {
		logger.debug("view id=======================" + id);
		List<ItripTradeEnds> itripTradeEnds = itripTradeEndsService.selectByPrimaryKey(id);
		System.out.println("itripTradeEnds.size -----"+itripTradeEnds.size());
		ItripTradeEnds ite = new ItripTradeEnds(itripTradeEnds.get(0).getId(),
				itripTradeEnds.get(0).getOrderno(),itripTradeEnds.get(0).getFlag());
		model.addAttribute(ite);
		return "ItripTradeEnds/ItripTradeEndsview";
	}

	/**
	 * 删除支付宝交易成功中间表
	 * 
	 * @param billid
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/ItripTradeEndsDel.do", method = RequestMethod.GET)
	public void providerDell(String proid, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = proid;
		long pid = Integer.parseInt(id);
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(id)) {
			int flag = itripTradeEndsService.deleteByPrimaryKey(pid);
			if (flag == 1) {// 删除成功
				resultMap.put("delResult", "true");
			} else if (flag == -1) {// 删除失败
				resultMap.put("delResult", "false");
			} 
//			else if (flag > 0) {// 该供应商下有订单，不能删除，返回订单数
//				resultMap.put("delResult", String.valueOf(flag));
//			}
		} else {
			resultMap.put("delResult", "notexit");
		}
		// 把resultMap转换成json对象输出
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
}
