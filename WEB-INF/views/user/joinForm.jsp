<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

	<script type="text/javascript" src="/lib/js/jquery-3.1.1.js"></script>
	<script src="/lib/bootstrap/js/ie-emulation-modes-warning.js"></script>
	<script type="text/javascript" src="/lib/js/user/joinAndMyPage.js"></script>
	<script type="text/javascript" src="/lib/js/user/join.js"></script>
	<script type="text/javascript" src="/lib/js/utils/region.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
	    $(function(){
	         // Find any date inputs and override their functionality
	         $('input[type="date"]').datepicker();
	    });
	</script>
</head>

<body>
<div class="site-wrapper">
	<div class="container inner">
		<h1 class="form-join-heading"><a href="/" class="toMain">Search a Wonderful Filter</a></h1>
			<form class="form-join" id="joinForm" action="/user/join" method="post">
				<div class="form-group">
			 		<div class="input-group">
			  			<label for="email" class="sr-only">Email address</label>
						<input type="email" id="email" name="email" class="form-control right-border-input" placeholder="이메일(example@gmail.com)" required autofocus title="이메일을 입력해주세요.">
						<span class="input-group-btn">
							<button class="btn btn-default btn-lg bottom-border-btn" type="button" id="sendMail">인증</button>
						</span>
						<input type="hidden" name="givenAuthNum" id="givenAuthNum">
					</div>
					<div class="input-group">
			  			<label for="authNum" class="sr-only">Authentication number</label>
						<input type="text" id="authNum" class="form-control right-border-input" placeholder="인증번호" required title="메일로 전송된 인증 번호를 입력해주세요." max="6">
						<span class="input-group-btn">
							<button class="btn btn-default btn-lg" type="button" id="numVal">확인</button>
						</span>
						<input type="hidden" id="numValOk" value="0">
					</div>
				</div>
				<div class="form-group" id="pwWrap">
					<div class="has-feedback">
						<label for="upw" class="sr-only">Password</label>
						<input type="password" id="upw" name="upw" class="form-control" placeholder="비밀번호" required title="비밀번호를 입력해주세요." maxlength="12">
						<span class="glyphicon glyphicon-lock form-control-feedback" aria-hidden="true"></span>
					</div>
					<div class="has-feedback">
						<label for="upwConf" class="sr-only">Password</label>
						<input type="password" id="upwConf" class="form-control" placeholder="비밀번호 확인" required title="비밀번호를 다시 입력해주세요." maxlength="12">
						<span class="glyphicon glyphicon-check form-control-feedback" aria-hidden="true"></span>
						<input type="hidden" id="pwOk" value="0">
					</div>
					<div class="has-feedback">
						<label for="umsg" class="sr-only">Authentication Text</label>
						<input type="text" id="umsg" name="umsg" class="form-control" placeholder="본인 확인 메시지" required  title="비밀번호를 찾을 때 사용할 메시지(공백 없이 최대  영문 15자, 국문 5자)를 입력해주세요." maxlength="15">
						<span class="glyphicon glyphicon-exclamation-sign form-control-feedback" aria-hidden="true"></span>
					</div>
				</div>
				<hr>
				<p>
					정보 제공에 동의함으로써 맞춤형 서비스를 이용하겠습니다.
					<input type="checkbox" id="usecustomservice" name="usecustomservice" value="1">
				</p>
				<div class="form-group" id="customWrap">
					<div class="btn-group btn-group-lg" role="group">
						<input type="radio" value="G01" hidden="hidden">
						<span class="btn btn-default resize-btn gender">남자</span>
						<input type="radio" value="G02" hidden="hidden">
						<span class="btn btn-default left-border-btn resize-btn gender">여자</span>
					</div>
					<div class="input-group" id="birthInput">
						<span class="input-group-addon small-input inputhead">생일</span>
						<input type="date" id="birth" class="form-control date-input right-border-input">
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
						<input type="hidden" id="region">
					</div>
				</div>
				<button class="btn btn-lg btn-default bordered-btn btn-block" type="button" id="join">가입하기</button>
			</form>
	</div>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>	
	
</div>

<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/lib/bootstrap/js/docs.min.js"></script>
   
<script src="/lib/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>