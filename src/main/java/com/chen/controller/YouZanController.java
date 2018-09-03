package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/youzan")
public class YouZanController {

	@RequestMapping("/index")
	public String index() {
		return "youzan/index";
	}
}
