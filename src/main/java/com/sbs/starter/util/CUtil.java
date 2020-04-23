package com.sbs.starter.util;

import java.math.BigInteger;

// Common Util 의 약자 클래스
// 일반적으로 많이 쓰는 유틸을 사용자가 지정한다.
public class CUtil {

	public static long getAsLong(Object object) {
		
		if (object instanceof BigInteger) {
			
			return ((BigInteger) object).longValue();
			
		} else if (object instanceof Long) {
			
			return (long) object ;
			
		} else if (object instanceof Integer) {
			
			return ((Integer) object).longValue();
			
		}else if ( object instanceof String) {
			
			return Long.parseLong((String) object);
			
		}
		
		//System.out.println("오브젝트 확인 : "+ object +"\n 오브젝트의 클래스 확인 : "+ object.getClass());
		return -1;//(Long)object; // 위에 조건문에 걸리지않으면 -1로 이상현상을 리턴하려 했으나 실패하여 통째로 리턴
							//  추측 : db에서 넘어올때 형변환을 하지 않았다? 혹은 하였으나 캐치하지 못한다?
							// dao.xml(myBatis설정) 의 userGeneratedKeys, keyProperty 옵션으로 문제 해결
	}

}
