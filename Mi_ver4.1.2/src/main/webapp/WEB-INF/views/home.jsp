<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
<c:set var="cp" value="${pageContext.request.contextPath}" />

<c:url var="cssUrl" value="/resources/css/layout.css">
    <c:param name="ver" value="${System.currentTimeMillis()}" />
</c:url>

	<link rel="stylesheet" href="${cp}/resources/css/reset.css">
	<link rel="stylesheet" href="${cssUrl}" />
</head>
<body>


	<div id="layout">
		<div id="layout1">
			<img alt="고양이" src="${cp}/resources/image/cat2.jpg" class="layout1">
		<P>  The time on the server is ${serverTime}. </P>
		</div>
		
	
		<div id="layout2">
			layout2
		</div>
		
		<div id="layout3">
			
		
		
			<div id="layout4">
				<div id="hello_World_Box">어서오세요!</div>
				<div id="login_Box">
			<c:set var="nickname" value="${sessionScope.nickname}" />
			
<%-- 			<a>${sessionScope.nickname}</a> --%>
			
			
			<c:choose>
				<c:when test="${empty nickname}"> 
<%--  				<c:when test="${empty sessionScope.nickname}"> --%>
					<form action="${cp }/board/login">
						<input name="submit_ID" placeholder="아이디"><br>
						<input name="submit_PW" type="password" placeholder="비밀번호"><br>
						<input type="submit" value="로그인">
						<a href="sign_up.jsp"><input type="button" value="회원가입"></a>
					</form>				
				</c:when>
				<c:otherwise>
<%-- 					<p> 어서오세요 ${sessionScope.nickname}님</p> --%>
					<p> 어서오세요 <br> ${nickname}님 <br> <a href="${cp }/board/logout"> <input type="button" value = "로그아웃"></a> </p> 
					
				</c:otherwise>
				
			</c:choose>					
				</div>
				
				<div id="board_leader">
					<h1>게시판</h1>
				</div>
				
				<div id="board_1">
					<div id=board>
							<a href="${cp }/board/free_Board">자유게시판</a><br>
					<br>	<a href="${cp }/board/music_Board">노래게시판</a><br>
					<br>	<a href="${cp }/board/cat_Board">고양이게시판</a><br>
					</div>
				</div>
				
				
				
			</div>
			
			<div id="layout5">
<%-- 				<%@include file="include_layout_back.jsp"%>	 --%>
				<%@include file="board/free_Board.jsp"%>	
			</div>
			<div id="layout6">
				<img alt="cat1" src="${cp}/resources/image/cat3.jpg" id="image">
			</div>
			
		</div>
	</div>
</body>
</html>
