$(function(){
	$("#search").on("click", function(){
		
		self.location="/search/result?keyword="
			+encodeURIComponent($("#keyword").val())
			+"&page="
			+$("#page").val();
		
	});
});