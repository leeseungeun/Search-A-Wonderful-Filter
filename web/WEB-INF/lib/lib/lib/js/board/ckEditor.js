$(function(){
	CKEDITOR.replace("bcont",
		{		height : '300px'
			,	filebrowserUploadUrl:'/board/fileUpload'
			,	filebrowserImageUploadUrl:'/board/fileUpload'
			,	filebrowserFlashUploadUrl:'/board/fileUpload'
		}
	);
});