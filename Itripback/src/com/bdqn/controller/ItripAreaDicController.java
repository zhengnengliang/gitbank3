package com.bdqn.controller;

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
import com.bdqn.pojo.ItripAreaDic;
import com.bdqn.service.areadic.ItripAreaDicService;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/admin/ItripAreaDic")
public class ItripAreaDicController {
	private Logger logger = Logger.getLogger(ItripAreaDicController.class);
	@Resource
	private ItripAreaDicService itripAreaDicService;

	/**
	 * 区域字典表管理
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/ItripAreaDic.do")
	private String query3(
			Model model,
			@RequestParam(value = "queryProName", required = false) String queryProName) {
		if (StringUtils.isNullOrEmpty(queryProName)) {
			queryProName = "";
		}
		
		List<ItripAreaDic> itripAreaDicList = new ArrayList<ItripAreaDic>();
		itripAreaDicList = itripAreaDicService.selectByName(queryProName);
		model.addAttribute("itripAreaDicList", itripAreaDicList);
		model.addAttribute("queryProName", queryProName);
		/*
		 * request.getRequestDispatcher("providerlist.jsp").forward(request,
		 * response);
		 */
		return "ItripAreaDic/ItripAreaDiclist";
	}

	/**
	 * 区域字典表增加页面，超连接get
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ItripAreaDicadd.do", method = RequestMethod.GET)
	public String itripAreaDicadd(
			@ModelAttribute("itripAreaDic") ItripAreaDic itripAreaDic) {
		return "ItripAreaDic/ItripAreaDicadd";
	}

	/**
	 * 区域字典表增加页面，form,post
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ItripAreaDicadd.do", method = RequestMethod.POST)
	public String additripAreaDicSava(@Valid ItripAreaDic itripAreaDic,
			BindingResult bindingResult, HttpSession session) {
//		if (bindingResult.hasErrors()) {
//			logger.debug("add itripAreaDic validated has error====");
//			return "ItripAreaDicadd";
//		}
		// itripAreaDic.setCreatedby(((ItripUser)session.getAttribute(USER_SESSION)).getId());
		//itripAreaDic.setCreationdate(new Date());
		if (itripAreaDicService.insertSelective(itripAreaDic) > 0) {
			return "redirect:/admin/ItripAreaDic/ItripAreaDic.do";
		}
		return "ItripAreaDic/ItripAreaDicadd";
	}

	/**
	 * 修改区域字典表信息
	 * 
	 * @param uid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ItripAreaDicmodify.do", method = RequestMethod.GET)
	public String getItripAreaDicByName(@RequestParam  String id, Model model) {
		logger.debug("getItripAreaDicByid id===================" + id);
		ItripAreaDic itripAreaDic = itripAreaDicService
				.selectById(id);
		model.addAttribute(itripAreaDic);
		return "ItripAreaDic/ItripAreaDicmodify";
	}

	@RequestMapping(value = "/ItripAreaDicmodify.do", method = RequestMethod.POST)
	public String modifyUserSave(ItripAreaDic itripAreaDic,
			HttpSession session, HttpServletRequest request) {
		logger.debug("modifyUserSave userid=============="
				+ itripAreaDic.getId());
		// itripAreaDic.setCreatedby(((ItripUser)session.getAttribute(USER_SESSION)).getId());
		itripAreaDic.setModifydate(new Date());
		if (itripAreaDicService.updateByPrimaryKeySelective(itripAreaDic) > 0) {
			return "redirect:/admin/ItripAreaDic/ItripAreaDic.do";
		}
		return "ItripAreaDic/ItripAreaDicmodify";
	}

	/**
	 * 查看区域字典表信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ItripAreaDicView/{id}", method = RequestMethod.GET)
	public String ProviderView(@PathVariable String id, Model model) {
		logger.debug("view id=======================" + id);
		ItripAreaDic itripAreaDic = itripAreaDicService.selectById(id);
		model.addAttribute(itripAreaDic);
		return "ItripAreaDic/ItripAreaDicview";
	}

	/**
	 * 删除区域字典表
	 * 
	 * @param billid
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/ItripAreaDicDel.do", method = RequestMethod.GET)
	public void providerDell(String proid, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = proid;
		long pid = Integer.parseInt(id);
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(id)) {
			int flag = itripAreaDicService.deleteByPrimaryKey(pid);
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
