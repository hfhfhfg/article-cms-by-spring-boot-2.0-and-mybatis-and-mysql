package com.sbs.starter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbs.starter.dto.Member;
import com.sbs.starter.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/home/main")
	public String showMain(/*HttpSession session,*/ Model model) {
		
		/* //해당 로그인 회원 번호로 회원정보 전체를 불러온다. //이걸 거의 모든 액션에서 하게 된다 이를 방지해야한다. Member
		/*
		 * long loginedMemberId = 0 ;
		 * 
		 * 
		 * //로그인 한 상태인지 체크하는 부분 if (session.getAttribute("loginedMemberId") != null) {
		 * loginedMemberId = (long)session.getAttribute("loginedMemberId"); }
		 * 
		 * 
		 * loginedMember = memberService.getOne(loginedMemberId);
		 * 
		 * model.addAttribute("loginedMember" ,loginedMember);
		 */
		
		
		return "home/main";
	}
	
	@RequestMapping("/")
	public String showMain2() {
		
		return "redirect:/home/main";
	}
}
