<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.sbs.starter.dto.Article"%>

<%
	List<Article> list = (List<Article>) request.getAttribute("List");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕</title>
</head>
<body>
	<h1>게시물 리스트 입니다.</h1>
	<h2>v1</h2>
	<%
		for (int i = 0; i < list.size(); i++) {
	%>
	<%
		Article article = list.get(i);
	%>
	<section>
		번호 :
		<%=article.getId()%>, 제목 :
		<%=article.getTitle()%>
	</section>
	<hr>


	<%
		}
	%>
	
	<h1>게시물 리스트 입니다.</h1>
	
	<h2>전체 게시물의 수 : ${totalCount }</h2>

	<h2>v2</h2>
	<!--v2 는  el으로 설정하였다.  el의 장점은 getAttribute시 형변환등을 고려하지 않아도 되는 장점이 있다.  --> 
	<c:forEach items="${List }" var="article">
		<section>번호 : ${article.id}, 
		제목 : ${article.title }</section>
		<hr>
	</c:forEach>
</body>
</html>