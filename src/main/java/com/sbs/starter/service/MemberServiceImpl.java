package com.sbs.starter.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.starter.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;

	public Map<String, Object> checkLoginIdDup(String loginId) {
		
		int count = memberDao.getLoginIdDupCount(loginId);
		
		String resultCode = "";
		
		String msg = "";
		
		if( count == 0 ) {
			resultCode="S-1";
			msg = "사용 가능한 ID 입니다.";
		}else {
			
			resultCode="F-1";
			msg = "이미 사용중인 ID 입니다. 다른 ID를 사용해 주세요.";
		}
		
		Map<String , Object> rs = new HashMap<String, Object>();
		rs.put("resultCode", resultCode);
		rs.put("msg", msg);
		
		return rs;
	}
	

}
