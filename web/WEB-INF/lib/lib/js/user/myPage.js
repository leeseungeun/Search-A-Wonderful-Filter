$(function(){
	//submit
	$("#modifyMyInfo").on("click",function(){
		
		var upw = $("#upw").val();
		var modifyConfirm = $("#modifyConfirm").val();
		var isPwChange = $("<input>").attr("name","isPwChange").attr("type","hidden");
		
		if(modifyConfirm==null|modifyConfirm==0){
			alert("정보 변경을 위해 비밀번호를 입력해주세요.")
			return;
		}
		
		if(upw==null|upw.length == 0){
			$("#upw").removeAttr("name");
			$("#upwConf").removeAttr("name");
			$(isPwChange).val("0");
			$("#myInfoForm").append(isPwChange);
			
		}else {
			
			if($("#pwOk").val=="0"){
				alert("비밀번호를 다시 확인해주세요.");
				return;
			}
			
			$("#upw").attr("name","upw");
			$("#upwConf").attr("name","upwConf");
			$(isPwChange).val("1");
			$("#myInfoForm").append(isPwChange);
		}
		
		if($("#usecustomservice").is(":checked")){

			isGender = $("input[type='radio']").val();
			isBirth= $("#birth").val();
			isRegion=$("#region").val();
			if(isGender==null|isGender.length == 0
					|isBirth==null|isBirth.length == 0
					|isRegion==null|isRegion.length == 0){
				return;
			}
		}
		$("#myInfoForm").submit();
	});
});