package com.sbs.starter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	// beforeActionInterceptor 인터셉터 불러오기
	@Autowired
	@Qualifier("beforeActionInterceptor")
	HandlerInterceptor beforeActionInterceptor;
	
	// needToLogin 불러오기
	@Autowired
	@Qualifier("needToLoginInterceptor")
	HandlerInterceptor needToLoginInterceptor;
	
	// needToLogout 불러오기
	@Autowired
	@Qualifier("needToLogoutInterceptor")
	HandlerInterceptor needToLogoutInterceptor;

	// 이 함수는 인터셉터를 적용하는 역할을 합니다.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// beforeActionInterceptor 를 모든 액션(/**)에 연결합니다. 단 /resource 로 시작하는 액션은 제외
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**");
		
		// needToLoginInterceptor 설정은  모든액션(/**)에서 로그인이 필요없는 페이지들만 제외시켜줍니다.
		registry.addInterceptor(needToLoginInterceptor).addPathPatterns("/**").excludePathPatterns("/resouce/**")
		.excludePathPatterns("/").excludePathPatterns("/member/join").excludePathPatterns("/member/doJoin")
		.excludePathPatterns("/member/login").excludePathPatterns("/member/doLogin").excludePathPatterns("/article/list")
		.excludePathPatterns("/article/detail");
		
		// 비로그인 상태에서만 사용되어야 할 페이지를 추가한다. 해당내용은 몇몇개만 추가하면 되기때문에 addPathPatterns로 일일히 넣어주면 된다.
		registry.addInterceptor(needToLogoutInterceptor).addPathPatterns("/member/join").addPathPatterns("/member/doJoin")
		.addPathPatterns("/member/login").addPathPatterns("/member/doLogin");
	}
}