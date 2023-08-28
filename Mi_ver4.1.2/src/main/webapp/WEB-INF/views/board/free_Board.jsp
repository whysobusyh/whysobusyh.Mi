<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>자유게시판</title>
  
  <c:set var="cp" value="${pageContext.request.contextPath}" />
  
  <c:url var="cssUrl" value="/resources/css/free_Board.css">
    <c:param name="ver" value="${System.currentTimeMillis()}" />
  </c:url>
  
  <link rel="stylesheet" href="${cp}/resources/css/reset.css">
  <link rel="stylesheet" href="${cssUrl}" />
</head>
<body>
  <div id="f_Layout1">
    <h1>자유게시판</h1>
  </div>
  <div class="f_leader">
<!--     <a>번호</a> <a>작성자</a> <a>제목</a> <a>등록일</a> <a>조회수</a> <a>추천</a> -->
<!-- 	번호 제목 작성자 등록일 조회수 추천 -->
<!-- 	<div class="text_items"> -->
<!-- 		번호 -->
<!-- 	</div> -->
<!-- 	<div class="text_items"> -->
<!-- 		제목 -->
<!-- 	</div> -->
<!-- 	<div class="text_items"> -->
<!-- 		작성자 -->
<!-- 	</div> -->
<!-- 	<div class="text_items"> -->
<!-- 		등록일 -->
<!-- 	</div> -->

	<div class="f_items">번호</div>
	<div class="f_items"> 제목</div>
	<div class="f_items"> 작성자 </div>
	<div class="f_items"> 작성일 </div>
	<div class="f_items"> 조회수 </div>
	<div class="f_items"> 추천수 </div>
    <hr>
  </div>
  
  <div id=f_article>
  	<c:forEach var="articles" items="${sessionScope.articles}">
  		<p>${articles}</p>
  	</c:forEach>
  </div>
</body>
</html>
