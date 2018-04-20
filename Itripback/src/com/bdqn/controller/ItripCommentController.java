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
import com.bdqn.pojo.ItripComment;
import com.bdqn.service.comment.ItripCommentService;
import com.mysql.jdbc.StringUtils;

@Controller  
@RequestMapping("/admin/ItripComment")
public class ItripCommentController {
	private Logger logger =Logger.getLogger(ItripCommentController.class);
	@Resource
	private ItripCommentService itripCommentService;

	/**
	 * 评论字典表管理
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/ItripComment.do")
	private String query3(
			Model model,
			@RequestParam(value = "queryProName", required = false) String queryProName) {
		if (StringUtils.isNullOrEmpty(queryProName)) {
			queryProName = "";
		}
		
		List<ItripComment> itripCommentList = new ArrayList<ItripComment>();
		itripCommentList = itripCommentService.selectByName(queryProName);
		model.addAttribute("ItripCommentList", itripCommentList);
		model.addAttribute("queryProName", queryProName);
		/*
		 * request.getRequestDispatcher("providerlist.jsp").forward(request,
		 * response);
		 */
		return "ItripComment/ItripCommentlist";
	}

	/**
	 * 评论字典表增加页面，超连接get
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ItripCommentadd.do", method = RequestMethod.GET)
	public String ItripCommentadd(
			@ModelAttribute("itripComment") ItripComment itripComment) {
		return "ItripComment/ItripCommentadd";
	}

	/**
	 * 评论字典表增加页面，form,post
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ItripCommentadd.do", method = RequestMethod.POST)
	public String addItripCommentSava(@Valid ItripComment itripComment,
			BindingResult bindingResult, HttpSession session) {
//		if (bindingResult.hasErrors()) {
//			logger.debug("add ItripComment validated has error====");
//			return "ItripCommentadd";
//		}
		// ItripComment.setCreatedby(((ItripUser)session.getAttribute(USER_SESSION)).getId());
		//ItripComment.setCreationdate(new Date());
		if (itripCommentService.insertSelective(itripComment) > 0) {
			return "redirect:/admin/ItripComment/ItripComment.do";
		}
		return "ItripComment/ItripCommentadd";
	}

	/**
	 * 修改评论字典表信息
	 * 
	 * @param uid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ItripCommentmodify.do", method = RequestMethod.GET)
	public String getItripCommentByName(@RequestParam  String id, Model model) {
		logger.debug("getItripCommentByname id===================" + id);
		ItripComment itripComment = itripCommentService.selectById(id);
		model.addAttribute(itripComment);
		return "ItripComment/ItripCommentmodify";
	}

	@RequestMapping(value = "/ItripCommentmodify.do", method = RequestMethod.POST)
	public String modifyUserSave(ItripComment itripComment,
			HttpSession session, HttpServletRequest request) {
		logger.debug("modifyUserSave userid=============="
				+ itripComment.getId());
		// ItripComment.setCreatedby(((ItripUser)session.getAttribute(USER_SESSION)).getId());
		itripComment.setModifydate(new Date());
		if (itripCommentService.updateByPrimaryKeySelective(itripComment) > 0) {
			return "redirect:/admin/ItripComment/ItripComment.do";
		}
		return "ItripComment/ItripCommentmodify";
	}

	/**
	 * 查看评论字典表信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ItripCommentview/{id}", method = RequestMethod.GET)
	public String ProviderView(@PathVariable String id, Model model) {
		logger.debug("view id=======================" + id);
		ItripComment itripComment = itripCommentService.selectById(id);
		model.addAttribute(itripComment);
		return "ItripComment/ItripCommentview";
	}

	/**
	 * 删除评论字典表
	 * 
	 * @param billid
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/ItripCommentDel.do", method = RequestMethod.GET)
	public void providerDell(String proid, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = proid;
		long pid = Integer.parseInt(id);
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(id)) {
			int flag = itripCommentService.deleteByPrimaryKey(pid);
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
