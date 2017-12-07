<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="masthead clearfix">
	<div class="inner">
		<nav>
			<ul class="nav masthead-nav">
				<li id="navSearch"><a href="/">SEARCH</a></li>
				<li id="navBoard"><a href="/board/list">BOARD</a></li>
				<li id="navMyPage"><a href="/user/myPageForm">MY PAGE</a></li>
				<c:if test="${not empty login}">
					<li><a href="/user/logout">LOGOUT</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
</div>