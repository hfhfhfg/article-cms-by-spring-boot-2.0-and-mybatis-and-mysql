package com.sbs.starter.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.starter.dao.ArticleDao;
import com.sbs.starter.dto.Article;
import com.sbs.starter.util.CUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleDao articleDao;
	//이제 AtricleService는 데이터 관련해서는 모두 Dao에 위임
	public List<Article> getList() {

		return articleDao.getList();
	}
	
	
	@Override
	public long add(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
		articleDao.add(param);
		
		
//		이하 int를 long으로 바꾸는 방법이 너무 난잡하기 때문에. CUtil을 만들어서 새로 지정하였다.
//		BigInteger newIntId = (BigInteger) param.get("id");
//		
//		long newId = newIntId.longValue();
		
		long newId = CUtil.getAsLong(param.get("id"));
		
		return  newId;
		
	}


	@Override
	public int getTotalCount() {
		
		return articleDao.getTotalCount();
		
	}


	@Override
	public Article getOne(long id) {
		
		return articleDao.getOne(id);
	}


	@Override
	public void delete(long id) {
		articleDao.delete(id);
	}


	@Override
	public void modify(Map<String, Object> param) {
		articleDao.modify(param);
		
	}
}
