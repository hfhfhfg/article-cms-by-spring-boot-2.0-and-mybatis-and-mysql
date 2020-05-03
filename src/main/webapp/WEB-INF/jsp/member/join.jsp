<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageName" value="회원가입" />

<%@ include file="../part/head.jspf" %>
	

<script>
function submitJoinForm(form) {
	form.loginId.value = form.loginId.value.trim();
	
	if(form.loginId.value.length == 0){
		alert("로그인ID를 입력해주세요.");
		form.loginId.focus();
		
		return false;
	}
	
form.loginPw.value = form.loginPw.value.trim();
	
	if(form.loginPw.value.length == 0){
		alert("로그인PW를 입력해주세요.");
		form.loginPw.focus();
		
		return false;
	}
	
form.loginPwConfirm.value = form.loginPwConfirm.value.trim();
	
	if(form.loginPwConfirm.value.length == 0){
		alert("로그인PW확인을 입력해주세요.");
		form.loginPwConfirm.focus();
		
		return false;
	}
	
	if(form.loginPw.value.trim() != form.loginPwConfirm.value.trim()){
		alert("비밀번호가 일치하지 않습니다.");
		form.loginPwConfirm.focus();
		
		return false;
	}
	form.submit();
}
</script>


	
	
	<form class="con common-form" action="./doJoin" method="POST" onsubmit="submitJoinForm(this); return false;">
		<div>
			<span>로그인 ID</span>
			<div>
				<input type="text" name="loginId" placeholder="로그인ID" autofocus="autofocus" maxlength="30">
			</div>
		</div>
		
		<div>
			<span>로그인 PW</span>
			<div>
				<input name="loginPw" placeholder="PASSWORD" autofocus="autofocus" maxlength="30" >
			</div>
		</div>
		
		<div>
			<span>비밀번호 확인</span>
			<div>
				<input name="loginPwConfirm" placeholder="PASSWORD-C" autofocus="autofocus" maxlength="30" >
			</div>
		</div>
		
		<div>
			<span>가입</span>
			<div>
			<input type="submit" value="가입">
			<input type="reset" value="취소" onclick="history.back()">
			<input type="reset" value="다시작성">
			</div>
		</div>
	
	</form>


	
<%@ include file="../part/foot.jspf" %>
