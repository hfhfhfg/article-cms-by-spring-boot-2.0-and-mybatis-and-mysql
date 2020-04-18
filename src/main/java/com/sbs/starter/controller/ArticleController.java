package com.sbs.starter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {
	@RequestMapping("/article/list")
	@ResponseBody
	public String showMain() {
		return "게시물 리스트.";
	}
}
