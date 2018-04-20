package com.bdqn.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.service.OrderLinkUser.ItripOrderLinkUserService;

@Controller  
@RequestMapping("/admin/ItripOrderLinkUser")
public class ItripOrderLinkUserController {
	private Logger logger =Logger.getLogger(ItripOrderLinkUserController.class);
	@Resource
	private ItripOrderLinkUserService itripOrderLinkUserService;
}
