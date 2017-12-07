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

	<script type="text/javascript" src="/lib/js/jquery-3.1.1.js"></script>
 	<script src="/lib/bootstrap/js/ie-emulation-modes-warning.js"></script>
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
			<div class="cover-container">
			
				<jsp:include page="../common/header.jsp"></jsp:include>				
				
				<div class="inner cover">
					<h1 class="cover-heading">Search a Wonderful Filter</h1>
						<div class="input-group searchArea">
						<form action="/search/result">
							<input type="text" class="form-control searchInput" placeholder="제주도 맛집  > '제주도' 입력" id="keyword" name="keyword" value="">
							<input type="hidden" name="page" value="1" id="page">
							<span class="input-group-btn">
								<button class="btn btn-default btn-lg" type="button" id="search">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
								</button>
							</span>
						</form>
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
