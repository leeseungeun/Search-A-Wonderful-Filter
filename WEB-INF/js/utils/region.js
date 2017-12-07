$(function(){
	// get gugun info
	$("#sido").on("change",function(){
		var sido = $("#sido").val();
		
		$.ajax({
				type:'get'
			,	url:'/user/getGugun'
			,	data:"sido="+sido
			,	success: function(data){
					var defaultOption = $("<option>").html("전체").attr("selected","selected").attr("disabled","disabled");
					$("#gugun").empty().append(defaultOption);
					$(data).each(function(i){
						
						
						var gugunOption = $("<option>");
						gugunOption.html(data[i]);
						$("#gugun").append(gugunOption);
						
					});
				}
		});
	});
	
	//get dong info
	$("#gugun").on("change",function(){
		var gugun = $("#gugun").val();
		
		$.ajax({
			type:'get'
		,	url:'/user/getDong'
		,	data: "gugun="+gugun
		,	success: function(data){
				var defaultOption = $("<option>").html("전체").attr("selected","selected").attr("disabled","disabled");
				$("#dong").empty().append(defaultOption);
				
				$(data).each(function(i){
					
					
					var dongOption = $("<option>");
					dongOption.html(data[i]);
					$("#dong").append(dongOption);
					
				});
			}
		});
	});
	
	//complete region
	$("#dong").on("change",function(){
		var region = "";
		region += $("#sido").val()+" "+$("#gugun").val()+" "+$("#dong").val();
		$("#region").val(region);
		$("#myaddr").val(region);
	});	
});
		