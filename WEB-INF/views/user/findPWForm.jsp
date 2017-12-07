<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<link href="/lib/css/loginAndFindPW.css" rel="stylesheet">

	<script src="/lib/bootstrap/js/ie-emulation-modes-warning.js"></script>
</head>

<body>
<div class="site-wrapper">
	<div class="container inner">
		<h1 class="form-signin-heading"><a href="/" class="toMain">Search a Wonderful Filter</a></h1>
			<form class="form-signin" action="/user/findPW" method="post">
		 		<div class="form-group has-feedback">
		  			<label for="email" class="sr-only">Email address</label>
					<input type="email" id="email" name="email" class="form-control" placeholder="이메일(example@gmail.com)" required autofocus title="서비스 이용을 위해 이메일을 입력해주세요.">
					<span class="glyphicon glyphicon-envelope form-control-feedback" aria-hidden="true"></span>
				</div>
				<div class="form-group has-feedback">
						<label for="umsg" class="sr-only">Authentication Text</label>
						<input type="text" id="umsg" name="umsg" class="form-control" placeholder="본인 확인 메시지" required  title="회원 가입 시 입력한 본인 확인 메시지(공백 없이 최대  영문 15자, 국문 5자 )를 입력해주세요." maxlength="15">
						<span class="glyphicon glyphicon-exclamation-sign form-control-feedback" aria-hidden="true"></span>
					</div>
				<button class="btn btn-lg btn-default btn-block" type="submit">임시 비밀번호 발급</button>
			</form>
	</div>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>	
	
</div>
<script type="text/javascript" src="/lib/js/jquery-3.1.1.js"></script>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/lib/bootstrap/js/docs.min.js"></script>
<script src="/lib/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>