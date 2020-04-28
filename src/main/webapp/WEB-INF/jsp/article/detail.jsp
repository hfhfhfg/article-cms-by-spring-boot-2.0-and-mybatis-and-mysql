<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.sbs.starter.dto.Article"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
	.con{
	width:1000px;
	margin: 0 auto;
	}
	
</style>

<title>커뮤니티 사이트 - 게시물 상세페이지</title>
</head>
<body>
	
	
	<h1>게시물 상세페이지.</h1>
	
	<section class="con">번호  : ${article.id }<br> 제목 : ${article.title } <br> 내용 : ${article.body }</section>
	<div class="btns con">
	<a href="./list">게시물 리스트</a>
	<a href="./add">게시물 추가</a>
	<a href="./modify?id= ${article.id }">게시물 수정</a>
	<a href="./delete>id= ${article.id }">게시물 삭제</a>
	</div>
</body>
</html>