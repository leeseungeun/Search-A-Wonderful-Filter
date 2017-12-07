$(function(){
	$("#bdiv").on("change",function(){
		if($("#bdiv").val()=='B01'){
			
			$("#mapWrap").attr("hidden","hidden");
			$("#cke_1_contents").attr("style","height:300px");
			
			$("#mapWrap input[type='hidden']").removeAttr("name");
		} else{
			$("#mapWrap").attr("hidden",null);
			$("#cke_1_contents").attr("style","height:150px");
			
			
			$("#maplatitude").attr("name","maplatitude");
			$("#maplongtitude").attr("name","maplongtitude");
			$("#marklatitude").attr("name","marklatitude");
			$("#marklongtitude").attr("name","marklongtitude");
		}
	});
	
	$("#toList").on("click",function(){
		self.location="/board/list";
	});
	
	$("#write").on("click",function(){
		var bdiv = $("#bdiv").val();
		var btitle = $("#btitle").val();
		if(bdiv==null
			|bdiv==0
			|btitle==null
			|btitle==0){
			alert("구분과 제목은 필수 입력 사항입니다.");
		}
		if($("#bdiv").val().length!=0
				&&$("#bdiv").val()!=null
				&&$("#bdiv").val()!='B01'){
			
			if($("#maplatitude").val()==null
					|$("#maplatitude").val().length==0
					|$("#maplongtitude").val()==null
					|$("#maplongtitude").val().length==0
					|$("#marklatitude").val()==null
					|$("#marklatitude").val().length==0
					|$("#marklongtitude").val().length==0
					|$("#marklongtitude").val()==null){
				
				alert("주소 선택 후 지도를 클릭하여 장소에 대한 정보를 입력해주세요.");
				return;
			}

		}
		$("#writeForm").submit();
	});
	
	$("#modify").on("click",function(){
		var bdiv = $("#bdiv").val();
		var btitle = $("#btitle").val();
		if(bdiv==null
			|bdiv==0
			|btitle==null
			|btitle==0){
			alert("구분과 제목은 필수 입력 사항입니다.");
		}
		if($("#bdiv").val().length!=0
				&&$("#bdiv").val()!=null
				&&$("#bdiv").val()!='B01'){
			
			if($("#maplatitude").val()==null
					|$("#maplatitude").val().length==0
					|$("#maplongtitude").val()==null
					|$("#maplongtitude").val().length==0
					|$("#marklatitude").val()==null
					|$("#marklatitude").val().length==0
					|$("#marklongtitude").val().length==0
					|$("#marklongtitude").val()==null){
				
				alert("주소 선택 후 지도를 클릭하여 장소에 대한 정보를 입력해주세요.");
				return;
			}

		}
		$("#modifyForm").submit();
	});
	
});