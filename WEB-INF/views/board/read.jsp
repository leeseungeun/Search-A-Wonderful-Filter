<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<link href="/lib/css/boardRead.css" rel="stylesheet">
	<link href="/lib/css/reply.css" rel="stylesheet">
	<link rel="stylesheet" href="/lib/css/jquery.mCustomScrollbar.css" />

	<script type="text/javascript" src="/lib/js/jquery-3.1.1.js"></script>
	<script src="/lib/bootstrap/js/ie-emulation-modes-warning.js"></script>
	<!-- <script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=581bfb266f278f9a8ca9fa283b6672c3"></script> -->
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=IHVLSwTG2PJ4_LpxuTDw&submodules=geocoder"></script>
	<script src="/lib/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript" src="/lib/js/board/scroll.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#toList").on("click",function(){
				self.location="list?curPage=${page.curPage}&recordPerPage=${page.recordPerPage}&searchType=${page.searchType}&searchKeyword=${page.searchKeyword}";
			});
			$("#modifyBtn").on("click",function(){
				self.location="modifyForm?curPage=${page.curPage}&recordPerPage=${page.recordPerPage}&searchType=${page.searchType}&searchKeyword=${page.searchKeyword}&bno=${bDto.bno}";
			});
			$("#removeBtn").on("click",function(){
				if("${bDto.replycnt}" != '0'){
					if(!confirm("게시글에 댓글이 있습니다.그래도 삭제하시겠습니까?")){
						return;
					}
				}
				$("form").attr("action","/board/remove");
				$("form").attr("method","post");
				$("form").submit();
			});
			var msg = "${msg}";
			if(msg == null|msg.length != 0){

				alert(msg);
				
			}
		});
	</script>
</head>
<body>
<div class="site-wrapper">
	<jsp:include page="../common/headerLogoOnly.jsp"></jsp:include>
	<div class="container inner boardWrap">
		<div class="box box-primary">
			<div class="box-header">
				<h4 class="box-title">게시글 상세보기</h4>	
			</div>
			<div class="box-body">
				<form>
				<div class="form-group">
					<div class="divWrap"> 
					<input type="hidden" name="bno" value="${bDto.bno }" id="bno">
					<input type="hidden" name="curPage" value="${page.curPage }">
					<input type="hidden" name="recordperPage" value="${page.recordPerPage}">
					<input type="hidden" name="searchType" value="${page.searchType }">
					<input type="hidden" name="searchKeyword" value="${page.searchKeyword }"> 
					<input type="hidden" name="rwriter" value="${sessionScope.login.email }" id="rwriter">
					<span class="head-first">구분</span>
						<c:if test="${bDto.bdiv== 'B01'}">
							<input type="text" class="form-control" value="서비스 건의  사항" readonly="readonly">
						</c:if>
						<c:if test="${bDto.bdiv== 'B02'}">
							<input type="text" class="form-control" value="맛집 정보 공유" readonly="readonly">
						</c:if>
						<c:if test="${bDto.bdiv== 'B03'}">
							<input type="text" class="form-control" value="맛집 원정대 모집" readonly="readonly">
						</c:if>
					</div>
					<div class="titleWrap">
						<span class="head">제목</span>
						<input type="text" class="form-control title" value="${bDto.btitle}" readonly="readonly">
					</div>
				</div>
				<div class="form-group multiinputs">
					<div class="writerWrap">
						<span class="head">작성자</span>
						<input type="text" class="body form-control" value="${fn:substring(bDto.bwriter,0,6)}*****@*****.***" readonly="readonly">
					</div>
					<div class="regDtWrap"> 
						<span class="head">등록일</span>
						<input type="text" class="body form-control" value="<fmt:formatDate value="${bDto.bregdt}" pattern="MM/dd/yyyy"/>" readonly="readonly">
					</div>
					<div class="upDtWrap"> 
						<span class="head">수정일</span>
						<input type="text" class="body form-control" value="<fmt:formatDate value="${bDto.bupdt}" pattern="MM/dd/yyyy"/>" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<span class="head">내용</span>
					<span class="form-control content" id="bcont">${bDto.bcont}</span>
				</div>
				<div class="form-group" id="mapWrap" hidden="">
					<span class="head">지도</span>
				<div id="map"></div>
				</div>
					<script type="text/javascript">
					if("${bDto.bdiv}"!='B01'){
						$("#mapWrap").attr("hidden",null);
					}
					var map = new naver.maps.Map('map', {
					    center: new naver.maps.LatLng("${mDto.maplatitude}","${mDto.maplongtitude}"),
					    zoom: 10
					});

					var marker = new naver.maps.Marker({
					    position: new naver.maps.LatLng("${mDto.marklatitude}", "${mDto.marklongtitude}"),
					    map: map
					});
					</script>
				</form>
			</div>
			<div class="box-footer">
				<div class="buttonWrap4read">
					<c:if test="${sessionScope.login.email == bDto.bwriter}">
						<button type="button" class="btn btn-default big-btn" id="removeBtn">삭제</button>
						<button type="button" class="btn btn-default big-btn" id="modifyBtn">수정</button>
					</c:if>
					<button type="button" class="btn btn-default big-btn" id="toList">목록</button>
				</div>
			</div>
		<div class="replyWrap">
			<div class="row">
				<h4 class="box-title">댓글</h4>
			</div>
			<c:if test="${!empty login }">
			<div class="row">
				<div class="replyWriteWrap">
					<textarea name="rcont" class="form-control" rows="3" placeholder="댓글을 입력해주세요." id="rcont"></textarea>
					<button class="btn btn-default btn-lg" id="replyWrite">등록</button>
				</div>
			</div>
			</c:if>
			<hr>
			<div>
				<div class="replyListWrap"></div>
				<div class="pageWrap">
					<ul id="pagination" class="pagination pagination-sm no margin"></ul>
				</div>
			</div>
		</div>
		</div>
	</div>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>	
	
</div>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="/lib/js/board/read.js"></script>
<script type="text/x-handlebars-template" id="replyTmpl">
	{{#each .}}
	<div class="message-item" id="m1">
		<div class="message-inner">
			<div class="message-head clearfix">
				<div class="user-detail">
					<h5 class="handle">{{privacyProtector rwriter}}*****@*****.***</h5>
					<input type="hidden" id="pageInfo">
					<button value="{{rno}}" class="btn btn-default btn-xs pull-right delbtn" id="replyRemove">
						<i class="fa fa-fw fa-remove">&times;</i>
					</button>
					<div class="post-meta">
						<div class="asker-meta">
							<span class="qa-message-when">
								<span class="qa-message-when-data">{{dateFormat rregdt}}</span>
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="qa-message-content">
				{{rcont}}
			</div>
		</div></div>
	{{/each}}
</script>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/lib/bootstrap/js/docs.min.js"></script>
   
<script src="/lib/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>