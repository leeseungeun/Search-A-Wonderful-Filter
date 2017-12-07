$(function(){
	// send mail
	$("#sendMail").on("click",function(){
		var email = $("#email").val();
		var emailRegExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;

		if(email==null|email.length == 0){
			
			alert("이메일을 입력해주세요.");
			return;
		
		} else	if (!email.match(emailRegExp)){
			
			alert("올바른 이메일 형식이 아닙니다.");
			return;
		}
		$.ajax({
				type:'post'
			,	url:'/user/emailValidation'
			,	data: email
			,	headers:{
						"Content-Type":"application/json"
					,	"X-HTTP-Method-Override":"POST"
				}
			,	success: function(data){
					if(data=="0"){
						alert("이미 가입하셨습니다.");
					}else {				
						$("#givenAuthNum").val(data);
						alert("인증 번호가 발송되었습니다.");
					}
				}
			, error:function(){
				alert("통신 상 문제가 발생하였습니다. 다시 시도해주세요.");
			}
		});
	});
	
	// authentication number validation
	$("#numVal").on("click",function(){
		
		var givenAuthNum = $("#givenAuthNum").val();
		if(givenAuthNum==null|givenAuthNum.length == 0){
			alert("먼저 이메일로 인증 번호를 발급 받아주세요.");
			return;
		}
		
		var authNum = $("#authNum").val().trim();
		var authNumRegExp = /[0-9]{6}$/;

		if(authNum==null|authNum.length == 0){
			
			alert("인증 번호를 입력해주세요.");
			return;
		
		} else	if (!authNum.match(authNumRegExp)){
			
			alert("올바른 인증 번호의 형식이 아닙니다.");
			return;
		}
		if(authNum==givenAuthNum){
			$("#numValOk").val("1");
			alert("인증에 성공하셨습니다.");
		}
	});
	
	// submit
	$("#join").on("click",function(){
		
		if($("#numValOk").val()==1
				& $("#pwOk").val()==1){
			if($("#usecustomservice").is(":checked")){
		
				isGender = $("input[type='radio']").val();
				isBirth= $("#birth").val();
				isRegion=$("#region").val();
				if(isGender==null|isGender.length == 0
				  |isBirth==null|isBirth.length == 0
				  |isRegion==null|isRegion.length == 0){
					alert("모든 정보를 입력했는지 확인해주세요.");
					return;
				}
			}
			
			$("#joinForm").submit();
			return;
		}
		alert("이메일 인증 및 필수 정보 입력을 확인해주세요.");
	});
});