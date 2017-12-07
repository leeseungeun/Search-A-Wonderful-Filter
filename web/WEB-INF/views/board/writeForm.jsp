<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="login page of SearchaWonderfulFilter">
	<meta name="author" content="LEE SEUNGEUN">
    
	<link rel="icon" href="/lib/images/searchFilter.png">

	<title>Search a Wonderful Filter</title>

	<link href="/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/lib/css/common.css" rel="stylesheet">
	<link href="/lib/css/boardCommon.css" rel="stylesheet">

	<script type="text/javascript" src="/lib/js/jquery-3.1.1.js"></script>
	<script src="/lib/bootstrap/js/ie-emulation-modes-warning.js"></script>
	<script type="text/javascript" src="/lib/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="/lib/js/board/ckEditor.js"></script>
	<!-- <script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=581bfb266f278f9a8ca9fa283b6672c3"></script> -->
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=IHVLSwTG2PJ4_LpxuTDw&submodules=geocoder"></script>
	<script type="text/javascript" src="/lib/js/utils/region.js"></script>
	<script type="text/javascript" src="/lib/js/board/writeAndModify.js"></script>
</head>

<body>
<div class="site-wrapper">
	<jsp:include page="../common/headerLogoOnly.jsp"></jsp:include>
	<div class="container inner boardWrap">
		<div class="box box-primary">
			<div class="box-header">
				<h4 class="box-title">게시글 등록</h4>	
			</div>
			<form role="form" action="/board/write" method="post" id="writeForm" enctype="multipart/form-data">
				<div class="box-body">
					<div class="form-group">
						<div class="divWrap"> 
						<label for="exampleInputPassword1">구분</label>
						<select class="decoSelect" id="bdiv" name="bdiv">
							<option selected="selected" disabled="disabled">선택</option>
							<option value="B01">서비스 건의 사항</option>
							<option value="B02">맛집 정보 공유</option>
							<option value="B03">맛집 원정대 모집</option>
						</select>
						</div>
						<input type="hidden" name="bwriter" value="${sessionScope.login.email}">
						<input type="hidden" name="bno" value="${bno }">
						<div class="titleWrap">
							<label for="btitle">제목</label>
							<input type="text" name="btitle" id="btitle" class="form-control title" placeholder="제목을 입력해주세요.">
						</div>
					</div>
					<div class="form-group">
						<label for="bcont">내용</label>
						<textarea class="form-control bcont" name="bcont" rows="6" placeholder="내용"></textarea>
					</div>
					<div class="form-group" id="mapWrap" hidden="">
						<label for="exampleInputPassword1">지도</label>
						<div class="input-group locselect">
						<select class="input-group-addon" id="sido">
							<option selected="selected" disabled="disabled">전체</option>
							<c:forEach var="sido" items="${sidoList }">
								<option value="${sido}">${sido }</option>
							</c:forEach>
						</select>
						<select class="input-group-addon" id="gugun">
							<option selected="selected" disabled="disabled">전체</option>
						</select>
						<select class="input-group-addon" id="dong">
							<option selected="selected" disabled="disabled">전체</option>
						</select>
						<input type="hidden" id="myaddr">
						<input type="hidden" id="maplatitude">
						<input type="hidden" id="maplongtitude">
						<input type="hidden" id="marklatitude">
						<input type="hidden" id="marklongtitude">
					</div>
					<div id="map"></div>
			 		<script src="/lib/js/board/map.js"></script>
				</div>
			</div>
			<div class="box-footer">
				<div class="buttonWrap">
					<button type="button" class="btn btn-default big-btn" id="toList">취소</button>
					<button type="button" class="btn btn-default big-btn" id="write">등록</button>
				</div>
			</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>	
	
</div>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/lib/bootstrap/js/docs.min.js"></script>
   
<script src="/lib/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>