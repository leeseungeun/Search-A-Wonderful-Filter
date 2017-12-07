<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
	<link href="/lib/css/joinAndMyPage.css" rel="stylesheet">
	<link href="/lib/css/myPage.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

	<script src="/lib/bootstrap/js/ie-emulation-modes-warning.js"></script>
	<script type="text/javascript" src="/lib/js/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="/lib/js/user/joinAndMyPage.js"></script>
	<script type="text/javascript" src="/lib/js/user/myPage.js"></script>
	<script type="text/javascript" src="/lib/js/utils/region.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
		var msg = "${msg}";
		if(msg == null|msg.length != 0){

			alert(msg);
			
		}
	    $(function(){
			$("#navMyPage").addClass("active");
	         // Find any date inputs and override their functionality
	         $('input[type="date"]').datepicker();
	    });
	</script>
</head>

<body>
<div class="site-wrapper">
	<jsp:include page="../common/headerWithLogo.jsp"></jsp:include>
	<div class="container inner myPage">
		<div class="pointDiv">
			<span>연속 출석 ${attendence}일째 </span>
			<span>/</span>
			<span>보유 포인트 : ${userDTO.upoint }점</span>
		</div>
		<form class="form-join" id="myInfoForm" action="/user/myPage" method="post">
			<div class="form-group">
				<div class="has-feedback">
					<input type="email" id="email" name="email" class="form-control" value="${userDTO.email }" readonly="readonly">
					<span class="glyphicon glyphicon-envelope form-control-feedback" aria-hidden="true"></span>
				</div>
				<div class="has-feedback">
					<label for="modifyConfirm" class="sr-only">Password</label>
					<input type="password" id="modifyConfirm" name="modifyConfirm" class="form-control" placeholder="비밀번호" required title="정보 변경을 위해 비밀번호를 입력해주세요." maxlength="12">
					<span class="glyphicon glyphicon-lock form-control-feedback" aria-hidden="true"></span>
				</div>
			</div>
			<div class="form-group" id="pwWrap">
				<div class="has-feedback">
					<label for="umsg" class="sr-only">Authentication Text</label>
					<input type="text" id="umsg" name="umsg" class="form-control" value="${userDTO.umsg }" title="비밀번호를 찾을 때 사용할 메시지(공백 없이 최대  영문 15자, 국문 5자)를 변경하실 경우 입력해주세요." maxlength="15">
					<span class="glyphicon glyphicon-exclamation-sign form-control-feedback" aria-hidden="true"></span>
				</div>
				<div class="has-feedback">
					<label for="upw" class="sr-only">Password</label>
					<input type="password" id="upw" class="form-control" placeholder="새 비밀번호" title="비밀번호를 변경하실 경우 입력해주세요." maxlength="12">
					<span class="glyphicon glyphicon-lock form-control-feedback" aria-hidden="true"></span>
				</div>
				<div class="has-feedback">
					<label for="upwConf" class="sr-only">Password</label>
					<input type="password" id="upwConf" class="form-control" placeholder="새 비밀번호 확인" title="변경하실 비밀번호를 다시 입력해주세요." maxlength="12">
					<span class="glyphicon glyphicon-check form-control-feedback" aria-hidden="true"></span>
					<input type="hidden" id="pwOk" value="0">
				</div>
			</div>
			<hr>
			<p>
				정보 제공에 동의함으로써 맞춤형 서비스를 이용하겠습니다.
				<c:choose>
					<c:when test="${userDTO.usecustomservice ne null }">
						<input type="checkbox" id="usecustomservice" name="usecustomservice" checked="checked" value="1">
					</c:when>
					<c:otherwise>
						<input type="checkbox" id="usecustomservice" name="usecustomservice" value="1">
					</c:otherwise>
				</c:choose>
			</p>
			<div class="form-group">
				<div class="btn-group btn-group-lg" role="group">
					<c:choose>
						<c:when test="${userDTO.gender eq 'G01' }">
							<input type="radio" value="G01" hidden="hidden" checked="checked" name="gender">
							<span class="btn btn-default resize-btn gender" style="background-color: rgb(230,230,230);">남자</span>
							<input type="radio" value="G02" hidden="hidden" name="gender">
							<span class="btn btn-default left-border-btn resize-btn gender">여자</span>
						</c:when>
						<c:when test="${userDTO.gender eq 'G02' }">
							<input type="radio" value="G01" hidden="hidden" name="gender">
							<span class="btn btn-default resize-btn gender">남자</span>
							<input type="radio" value="G02" hidden="hidden" checked="checked" name="gender">
							<span class="btn btn-default left-border-btn resize-btn gender" style="background-color: rgb(230,230,230);">여자</span>
						</c:when>
						<c:otherwise>
							<input type="radio" value="G01" hidden="hidden" name="gender">
							<span class="btn btn-default resize-btn gender">남자</span>
							<input type="radio" value="G02" hidden="hidden" name="gender">
							<span class="btn btn-default left-border-btn resize-btn gender">여자</span>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="input-group">
					<span class="input-group-addon small-input inputhead">생일</span>
					<fmt:formatDate value="${userDTO.birth }" var="parsedBirth" pattern="MM/dd/YYYY"/>
					<input type="date" id="birth" class="form-control date-input right-border-input" value="${parsedBirth }" name="birth">
				</div>
				<div class="input-group">
					<select class="form-control input-group-addon medium-input right-border-input" id="sido">
						<option selected="selected" disabled="disabled">전체</option>
						<c:forEach var="sido" items="${sidoList }">
							<option value="${sido}">${sido }</option>
						</c:forEach>
					</select>
					<select class="form-control input-group-addon medium-input right-border-input" id="gugun">
						<option selected="selected" disabled="disabled">전체</option>
					</select>
					<select class="form-control input-group-addon medium-input" id="dong">
						<option selected="selected" disabled="disabled">전체</option>
					</select>
					<input type="text" class="form-control" id="region" value="${userDTO.region}" readonly="readonly" name="region">
				</div>
			</div>
			<button class="btn btn-lg btn-default btn-block bordered-btn" type="button" id="modifyMyInfo">수정</button>
		</form>
	</div>
	
<jsp:include page="../common/footer.jsp"></jsp:include>	
	
</div>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/lib/bootstrap/js/docs.min.js"></script>
   
<script src="/lib/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>