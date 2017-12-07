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
	<link href="/lib/css/boardList.css" rel="stylesheet">

	<script src="/lib/bootstrap/js/ie-emulation-modes-warning.js"></script>
	<script type="text/javascript" src="/lib/js/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="/lib/js/board/list.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#navBoard").addClass("active");
			$("#searchBtn").on("click",	function(event){
				self.location="list"
					     		+"${pageHelper.makeQuery(1)}"
								+"&searchType="
								+$("#searchType").val()
								+"&searchKeyword="
								+encodeURIComponent($("#searchKeyword").val());
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
	<jsp:include page="../common/headerWithLogo.jsp"></jsp:include>
	<div class="container inner">
		<div class="boardWrap">
			<div class="searchWrap">
				<div class="searchTypeWrap">
					<select class="form-control" id="searchType">
						<option value="">검색 조건</option>
						<option value="bdiv">구분</option>
						<option value="bwriter">작성자</option>
						<option value="btitleOrbcont">제목 또는 내용</option>
					</select>
					<input type="hidden" name="searchType" value="${page.searchType}">
					<input type="hidden" name="searchKeyword" value="${page.searchKeyword}" id="searchKeyword">
				</div>
				<div class="searchKeywordWrap">
				</div>
				<button class="btn btn-default" type="button" id="searchBtn">검색</button>
				<button class="btn btn-default" type="button" id="writeBoardBtn">게시글 작성</button>
			</div>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>글번호</th>
							<th>구분</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
							<th>수정일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!empty list}">
							<c:forEach items="${list }" var="bDto">
								<tr>
									<td>${bDto.bno}</td>
									<td>
										<c:if test="${bDto.bdiv== 'B01'}">
											서비스 건의 사항
										</c:if>
										<c:if test="${bDto.bdiv== 'B02'}">
											맛집 정보 공유
										</c:if>
										<c:if test="${bDto.bdiv== 'B03'}">
											맛집 원정대 모집
										</c:if>
									</td>
									<td>
										<a id="btitle" href="/board/read${pageHelper.makeQueryWithSearch(pageHelper.page.curPage) }&bno=${bDto.bno}">
											${bDto.btitle }
										</a>
										<span class="badge">${bDto.replycnt}</span>
									</td>
									<td>${fn:substring(bDto.bwriter,0,6)}*****@*****.***</td>
									<td><fmt:formatDate value="${bDto.bregdt}" pattern="MM/dd/yyyy"/></td>
									<td><fmt:formatDate value="${bDto.bupdt}" pattern="MM/dd/yyyy"/></td>
									<td>${bDto.viewcnt}</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${empty list }">
							<tr>
								<td colspan="7" id="noResult">표시할 결과가 없습니다.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
			<div class="page-wrap">
				<ul class="pagination">
					<c:if test="${pageHelper.prev }">
						<li>
							<a>&laquo;</a>
						</li>
					</c:if>
					<c:forEach begin="${pageHelper.startPage}" end="${pageHelper.endPage}" var="idx">
						<li
						<c:out value="${pageHelper.page.curPage==idx?'class=active':'' }"/>>
							<a href="list${pageHelper.makeQueryWithSearch(idx)}">${idx }</a>
						</li>
					</c:forEach>
					<c:if test="${pageHelper.next && pageHelper.endPage > 0 }">
						<li>
							<a href="${pageHelper.makeQueryWithSearch(pageHelper.endPage+1)}">&raquo;</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>	
	
</div>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/lib/bootstrap/js/docs.min.js"></script>
   
<script src="/lib/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>