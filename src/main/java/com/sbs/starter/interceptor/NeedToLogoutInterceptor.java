package com.sbs.starter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//인터셉터 이름
@Component("needToLogoutInterceptor")
public class NeedToLogoutInterceptor implements HandlerInterceptor {
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception{
		
		//이 인터셉터 실행 이전에 BeforeActionInterceptor가 실행된다.
		//그래서 여기서 단순히  request.getAttribute("isLogined"); 로 로그인 여부를 알아낸 후 어떤 페이지를 보여줄 것 인지 다시 설정한다.
		
		boolean isLogined =  (boolean) request.getAttribute("isLogined");
		
		if (isLogined) {
			
			response.setContentType("text/html; charSet=UTF-8");
			response.getWriter().append("<script>");
			response.getWriter().append("alert('로그인 후 이용해주세요.');");
			response.getWriter().append("history.back();");
			response.getWriter().append("</script>");
			
			// 리턴 false; 를 하게되면 이후에 실행 될 인터셉터와 액션이 실행되지 않는다.
			return false;
			
		}
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
