<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" src="../lib/ckeditor/ckeditor.js"></script>
<style>
	html, body
	{
		width	:	100%;
		height	:	100%;
	}
	
	.container
	{
		position			:	absolute;
		top					:	50%;
		left				:	50%;
		margin				:	auto;
		transform			:	translateX(-50%) translateY(-50%);
		-moz-transform		:	translateX(-50%) translateY(-50%);  
		-webkit-transform	:	translateX(-50%) translateY(-50%);  
		-o-transform		:	translateX(-50%) translateY(-50%);
		-ms-transform		:	translateX(-50%) translateY(-50%);
	}
	
	.input-group { left	: 25%; }
</style>
<body>
	<div class="container">
		<div class="input-group">
			<textarea class="form-control" id="p_content" style="margin-top:500px;"></textarea>
			<script type="text/javascript">
				var name = '${_csrf.headerName}';
				var token = '${_csrf.token}';
				CKEDITOR.replace("p_content", {
					 width	:	500, height	:	500,
					 filebrowserUploadUrl	:	"/inquiry/imgUpload?_csrf=" + token
					 });
			</script>
		</div>
	</div>
</body>