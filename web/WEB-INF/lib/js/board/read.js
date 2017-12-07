var bno = $("#bno").val();

var printReply = function(replyArr,target,tmpl){
	var replyTmpl = Handlebars.compile($("#replyTmpl").html());
	var html = replyTmpl(replyArr);
	target.empty();
	target.append(html);
}

var printPage = function(pageHelper,target){
	
	var str = "";
	
	if(pageHelper.prev){
		str += "<li><a href='"
			+ (pageHelper.startPage-1)
			+ "'> << </a></li>";
	}
	
	for(var i=pageHelper.startPage,len=pageHelper.endPage;i<=len;i++){
		var strClass = pageHelper.page.curPage == i?'class=active':'';
		str += "<li "
			+ strClass
			+ "><a href='"
			+ i
			+ "'>"
			+ i
			+"</a></li>";
	}
		
	if(pageHelper.next){
		str += "<li><a href='"
			+ (pageHelper.endPage+1)
			+ "'> >> </a></li>"
	}
	
	target.html(str);
	
}

function getReplyList(pageInfo){
	$.getJSON(pageInfo,function(data){
		printReply(data.list,$(".replyListWrap"),$("#replyTmpl"));
		printPage(data.pageHelper,$(".pagination"));
		$("#pageInfo").val(data.pageHelper.page.curPage);
	});
}

Handlebars.registerHelper("dateFormat",function(timeValue){
	
	var dateObj = new Date(timeValue);
	var year = dateObj.getFullYear();
	var month = dateObj.getMonth()+1;
	var date = dateObj.getDate();
	
	return month+"/"+date+"/"+year;
});

Handlebars.registerHelper("rwriteCheck",function(replyer,block){
	
	var accum = '';
	if(rwriter=='${login.email}'){
		accum += block.fn();
	}
	
	return accum;
	
});

Handlebars.registerHelper("privacyProtector",function(replyer){
	return replyer.substring(0,6);
});

getReplyList("/replies/"+bno+"/1");

$(".pagination").on("click","li a", function(event){
	
	event.preventDefault();
	
	replyPage = $(this).attr("href");
	getReplyList("/replies/"+bno+"/"+replyPage);
});

$("#replyWrite").on("click",function(){
	var rwriterObj = $("#rwriter");
	var rcontObj = $("#rcont");
	var rwriter = rwriterObj.val();
	var rcont = rcontObj.val();
	
	$.ajax({
			type:'post'
		,	url:'/replies/'+bno
		,	headers:{
					"Content-Type":"application/json"
				,	"X-HTTP-Method-Override":"POST"
			}
		,	dataType:'text'
		,	data: JSON.stringify({
					bno:bno
				,	rwriter:rwriter
				,	rcont:rcont
			})
		,	success:function(result){
				console.log("result: "+result);
				if(result=='1'){
					alert("성공적으로 댓글을 등록하였습니다.");
					replyPage = 1;
					getReplyList("/replies/"+bno+"/"+replyPage);
					rcontObj.val("");
				}
			}	
	});
});

$(document).on("click","#replyRemove",function(){
	
	var rno = $(this).val();
	var pageInfo = $("#pageInfo").val(); 
	
	$.ajax({
		type:'delete'
	,	url:'/replies/'+bno+'/'+rno
	,	headers:{
				"Content-Type":"application/json"
			,	"X-HTTP-Method-Override":"DELETE"
		}
	,	dataType:'text'
	,	success:function(result){
		console.log("result: "+result);
		if(result=='1'){
			alert("성공적으로 삭제되었습니다.");
			var replyPage = pageInfo
			getReplyList("/replies/"+bno+"/"+replyPage);
		}
		}
	});
});

