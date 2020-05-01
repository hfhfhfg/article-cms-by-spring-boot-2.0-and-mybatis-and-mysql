package com.sbs.starter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	//beforeActionInterceptor 불러오기
	@Autowired
	@Qualifier("beforeActionInterceptor")
	HandlerInterceptor beforeActionInterceptor;
	
	
	//이함수는 인터셉터를 적용하는 역할을 합니다.
	public void addInterceptors(InterceptorRegistry registry) {
		
		//beforeActionInterceptor 를 모든 액션(/**)에 연결합니다 단 /resouce 로 시작하는 액션은 제외합니다.
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**");
	}

}
