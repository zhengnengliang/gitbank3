package com.bdqn.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.service.ProductStore.ItripProductStoreService;

@Controller  
@RequestMapping("/admin/ItripProductStore")
public class ItripProductStoreController {
	private Logger logger =Logger.getLogger(ItripProductStoreController.class);
	@Resource
	private ItripProductStoreService itripProductStoreService;
}
