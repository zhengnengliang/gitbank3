package com.bdqn.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.service.LabelDic.ItripLabelDicService;

@Controller  
@RequestMapping("/admin/ItripLabelDic")
public class ItripLabelDicController {
	private Logger logger =Logger.getLogger(ItripLabelDicController.class);
	@Resource
	private ItripLabelDicService itripLabelDicService;
}
