package com.sbs.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbs.starter.dto.Article;
import com.sbs.starter.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/article/list")
	public String showMain() {
		
		List<Article> list = articleService.getList();
		return "article/list";
	}
}
