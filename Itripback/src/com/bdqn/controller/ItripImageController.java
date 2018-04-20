package com.bdqn.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.service.Image.ItripImageService;

@Controller  
@RequestMapping("/admin/ItripImage")
public class ItripImageController {
	private Logger logger =Logger.getLogger(ItripImageController.class);
	@Resource
	private ItripImageService itripImageService;
}
