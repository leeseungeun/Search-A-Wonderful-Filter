<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="search page of SearchaWonderfulFilter">
	<meta name="author" content="LEE SEUNGEUN">

	<link rel="icon" href="/lib/images/searchFilter.png">

	<title>Search a Wonderful Filter</title>

	<link href="/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/lib/css/common.css" rel="stylesheet">
	<link href="/lib/css/search.css" rel="stylesheet">
	<link href="/lib/css/searchResult.css" rel="stylesheet">
	<link rel="stylesheet" href="/lib/css/jquery.mCustomScrollbar.css" />

	<script type="text/javascript" src="/lib/js/jquery-3.1.1.js"></script>
 	<script src="/lib/bootstrap/js/ie-emulation-modes-warning.js"></script>
	<script src="/lib/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript" src="/lib/js/search/scroll.js"></script>
	<script type="text/javascript" src="/lib/js/search/search.js"></script>
	<script type="text/javascript">
		$(function(){
	 		$("#navSearch").addClass("active");
		});
 	</script>
</head>

 <body>
	<div class="site-wrapper">
		<div class="site-wrapper-inner">
			<div class="result-container">
			
				<jsp:include page="../common/headerWithLogo.jsp"></jsp:include>				
				
				<div class="inner cover">
					<div class="input-group searchArea">
					<form action="/search/result">
						<input type="text" class="form-control searchInput" name="keyword" value="${keyword }" id="keyword">
						<input type="hidden" name="page" value="1" id="page">
						<span class="input-group-btn">
							<button class="btn btn-default btn-lg" type="button" id="search">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</span>
					</form>
					</div>
					<div class="resultWrap">
					<div class="nonad">
						<p class="resultEmphTo"> 아래의 분류는 <span class="accEmph">${rDto.modelAccuracy }</span>의 정확도를 가지고 있습니다.</p>
						<div class="row">
						<p class="resultEmph"> 비광고 </p>
						<div class="nonad">
						<c:forEach var="sDto" items="${rDto.labeledResult }">
							<c:if test="${sDto.label eq 'nonad' }">
									<div class="goBlog">
										<h3 class="blogNm">${sDto.title }</h3>
										<span>
										<a class="btn btn-default a-btn" href="${sDto.url}" target="_blank">블로그로 이동하기 <span class="glyphicon glyphicon-chevron-right"></span></a>
										</span>
									</div>
							</c:if>
						</c:forEach>
						</div>
						</div>
				        <hr>
						<div class="row">
						<p class="resultEmph">광고</p>
						<div class="ad">
						<c:forEach var="sDto" items="${rDto.labeledResult }">
							<c:if test="${sDto.label eq 'ad' }">
									<div class="goBlog">
										<h3 class="blogNm">${sDto.title }</h3>
										<span>
											<a class="btn btn-default a-btn" href="${sDto.url}">블로그로 이동하기 <span class="glyphicon glyphicon-chevron-right"></span></a>
										</span>									
									</div>
							</c:if>
						</c:forEach>
						</div>
					    </div>
					</div>
			        <div class="page-wrap">
						<ul class="pagination">
							<c:if test="${page ne 1 }">
								<li>
									<a href="result?keyword=${keyword}&page=${page-1}">&lt;</a>
								</li>
							</c:if>
								<li>
									<a href="result?keyword=${keyword}&page=${page+1}">&gt;</a>
								</li>
						</ul>
					</div>
					</div>
				</div>
			</div>

			<jsp:include page="../common/footer.jsp"></jsp:include>

		</div>
	</div>

    <script src="/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="/lib/bootstrap/js/docs.min.js"></script>
   
    <script src="/lib/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
