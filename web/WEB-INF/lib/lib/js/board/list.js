
var result = "${result}"
if(result=="success"){
	alert("처리 완료");
}
$(function(){
	var searchType = $("#searchType").val();
	if(searchType==null|searchType.length==0){
		$("#searchKeyword").val("");
	}
	
	$("#writeBoardBtn").on("click",function(evt){
		self.location="writeForm";
	});
	
	var bdiv = $("<select>").addClass("form-control").attr("id","fakeInput");
	bdiv.append($("<option>").val("").html("선택"));
	bdiv.append($("<option>").val("B01").html("서비스 건의 사항"));
	bdiv.append($("<option>").val("B02").html("맛집 정보 공유"));
	bdiv.append($("<option>").val("B03").html("맛집 원정대 모집"));
	
	var textinput = $("<input>").attr("type","text").addClass("form-control").attr("id","fakeInput");
		
	$("#searchType").on("change",function(){
		var searchType = $("#searchType").val();
		$("input[name=searchType]").val(searchType);
		
		if(searchType=='bdiv'){
			$(".searchKeywordWrap").empty();
			$(".searchKeywordWrap").append(bdiv);
		} else{
			
			$(".searchKeywordWrap").empty();
			$(".searchKeywordWrap").append(textinput);
		}
	});
	
	$(document).on("change","#fakeInput",function(){
		if($("#searchType").val()=='bdiv'){
			var searchKeyword = $("#fakeInput option:selected").val();
		}else{
			var searchKeyword = $('#fakeInput').val();
		}
		$("#searchKeyword").val(searchKeyword);
		
	});
	
});
