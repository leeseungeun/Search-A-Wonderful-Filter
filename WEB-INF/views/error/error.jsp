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

 	<script src="/lib/bootstrap/js/ie-emulation-modes-warning.js"></script>

</head>

 <body>
	<div class="site-wrapper">
		<div class="site-wrapper-inner">
			<div class="cover-container">
			
				<div class="inner cover">
					<h1 class="cover-heading"><a href="/" id="goHomeWhenError">Search a Wonderful Filter</a></h1>
						<div class="searchArea">
							<p>
								현재 시스템 점검 중입니다. 
							</p>
							<p>
								시스템 점검이 지속될 경우 아래의 연락처로 메일 남겨주시길 바랍니다. 
							</p>
						</div>
				</div>
			</div>

			<jsp:include page="../common/footer.jsp"></jsp:include>

		</div>
	</div>

    <script type="text/javascript" src="/lib/js/jquery-3.1.1.js"></script>
    <script src="/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="/lib/bootstrap/js/docs.min.js"></script>
   
    <script src="/lib/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
