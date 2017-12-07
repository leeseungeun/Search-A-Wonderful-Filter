//<![CDATA[
	$(function(){
		var warnMsg = $("<p>").attr("id","warnMsg").css("color","red");
		//get information
		$("#usecustomservice").on("click",function(){
			$("#usecustomservice").val(null);
			$("input[type='radio']").removeAttr("name");
			$("#birth").removeAttr("name");
			$("#region").removeAttr("name");
			
			if($("#usecustomservice").is(":checked")){
				$("#usecustomservice").val("1");
				$("input[type='radio']").attr("name","gender");
				$("#birth").attr("name","birth");
				$("#region").attr("name","region");
			}
		});
		
		// select gender
		$(".gender").on("click",function(){
			$(".gender").css("background-color","#FFF");
			$(this).css("background-color","#e6e6e6");
			$("input[type=radio]").attr("checked",null);
			$(this).prev().attr("checked","checked");
		});
		
		//pw length check
		$("#upw").on("blur",function(){
			$("#pwOk").val("0");
			$("#warnMsg").remove();
			
			var upw = $("#upw").val();
			if (upw.length < 6){
				$(this).css("border","2px solid red");
				$(warnMsg).html("비밀번호는 최소 6글자입니다.");
				$("#pwWrap").append(warnMsg);
				return;
			} else	if (upw.length > 12){
				$(this).css("border","2px solid red");
				$(warnMsg).html("비밀번호는 최대 12글자입니다.");
				$("#pwWrap").append(warnMsg);
				return;
			}
			$(this).css("border","none");
			$("#pwOk").val("1");
		});
		
		// pw confirm
		$("#upwConf").on("keyup",function(){
			$("#pwOk").val("0");
			$("#warnMsg").remove();
			if($("#upw").val() != $("#upwConf").val()){
				$(this).css("border","2px solid red");
				$(warnMsg).html("입력하신 비밀번호와 일치하지 않습니다.");
				$("#pwWrap").append(warnMsg);
				return;
			}
			$(this).css("border","none");
			$("#pwOk").val("1");
		});
		
		//umsg check
		$("#umsg").on("blur",function(){
			$("#pwOk").val("0");
			$("#warnMsg").remove();

			var umsg = $("#umsg").val();
			
			if(umsg==null|umsg.length == 0){
				$(this).css("border","2px solid red");
				$(warnMsg).html("본인 확인 메시지를 입력해주세요.");
				$("#pwWrap").append(warnMsg);
				return;
			} 
			
			var blank_pattern = /[\s]/g;
			if( blank_pattern.test(umsg) == true){
				$(this).css("border","2px solid red");
				$(warnMsg).html('공백은 사용할 수 없습니다.');
				$("#pwWrap").append(warnMsg);
			    return;
			}
			
			stringByteLength = umsg.replace(/[\0-\x7f]|([0-\u07ff]|(.))/g,"$&$1$2").length
			if(stringByteLength > 15){
				$(this).css("border","2px solid red");
				$(warnMsg).html('본인 확인 메시지는 최대  영문 15자, 국문 5자입니다.');
				$("#pwWrap").append(warnMsg);
			}
			$(this).css("border","none");
			$("#pwOk").val("1");
		});
		
	});		
//]]>