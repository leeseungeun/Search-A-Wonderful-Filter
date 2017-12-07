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
	<script type="text/javascript">
		var msg = "${msg}"
		if(msg == null|msg.length != 0){

			alert(msg);
			
		}
	</script>
</head>

<body>
<div class="site-wrapper">
	<div class="container inner">
		<h1 class="form-signin-heading"><a href="/" class="toMain">Search a Wonderful Filter</a></h1>
			<form class="form-signin" action="/user/login" method="post">
		 		<div class="form-group has-feedback">
		  			<label for="inputEmail" class="sr-only">Email address</label>
					<input type="email" id="email" name="email" class="form-control" placeholder="이메일(example@gmail.com)" required autofocus title="서비스 이용을 위해 이메일 입력해주세요.">
					<span class="glyphicon glyphicon-envelope form-control-feedback" aria-hidden="true"></span>
				</div>
				<div class="form-group has-feedback">
					<label for="upw" class="sr-only">Password</label>
					<input type="password" id="upw" name="upw" class="form-control" placeholder="비밀번호" required title="서비스 이용을 위해 비밀번호를 입력해주세요." maxlength="12">
					<span class="glyphicon glyphicon-lock form-control-feedback" aria-hidden="true"></span>
				</div>
				<div class="checkbox">
				<label>
					<input type="checkbox" name="useCookie"> 로그인 상태 유지
				</label>
				</div>
				<button class="btn btn-lg btn-default btn-block" type="submit">로그인</button>
			</form>
			<div class="findPWandJoinin">
				<span><a href="/user/findPWForm">임시 비밀번호 발급</a></span>
				<span><a href="/user/joinForm">회원가입</a></span>
			</div>
	</div>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>	
	
</div>
<script type="text/javascript" src="/lib/js/jquery-3.1.1.js"></script>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/lib/bootstrap/js/docs.min.js"></script>
   
<script src="/lib/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>