<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<style>
	html 
	{
		height: 100%;
	}
	body
	{
	    background-image: url(http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg);
	    background-size: cover;
	    background-repeat: no-repeat;
	    height: 100%;
	    font-family: 'Numans', sans-serif;
	}
	
	.container
	{
		display:flex;
		width:500px;
		height:100%;
	}
	
	.bg-light
	{
		background-color	:	rgba(0,0,0,0.5) !important;
		margin-top	:	auto;
		margin-bottom	:	auto;
	}
	
	.container h4
	{
		color	:	white;
		margin-bottom: 1.75rem;
		
	}
	
	.input-group-prepend span 
	{
    	width: 50px;
	    background-color: #FFC312;
	    color: black;
	    border: 0 !important;
	}
	
</style>
</head>
<body>
	<div class="container">
	<div class="card bg-light" >
	<article class="card-body mx-auto" style="max-width: 400px;">
		<h4 class="card-title mt-3 text-center">회원 가입</h4>
		<form>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
			 </div>
	        <input name="" class="form-control" placeholder="이름" type="text">
	    </div> <!-- form-group// -->
	    <div class="form-group input-group">
	    	<div class="input-group-prepend">
			    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
			 </div>
	        <input name="" class="form-control" placeholder="이메일" type="email">
	    </div> <!-- form-group// -->
	    <div class="form-group input-group">
	    	<div class="input-group-prepend">
			    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
			</div>
			<select class="custom-select" style="max-width: 100px;">
			    <option selected value="korea">+82</option>
			    <option value="usa">+1</option>
			    <option value="jpa">+81</option>
			    <option value="chi">+86</option>
			</select>
	    	<input name="" class="form-control" placeholder="휴대폰 번호" type="text">
	    </div> <!-- form-group// -->
	    <div class="form-group input-group">
	    	<div class="input-group-prepend">
			    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
			</div>
			<select class="form-control">
				<option selected value="merchant">상인</option>
				<option value="customer">고객</option>
			</select>
		</div> <!-- form-group end.// -->
	    <div class="form-group input-group">
	    	<div class="input-group-prepend">
			    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
			</div>
	        <input class="form-control" placeholder="비밀번호" type="password">
	    </div> <!-- form-group// -->
	    <div class="form-group input-group">
	    	<div class="input-group-prepend">
			    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
			</div>
	        <input class="form-control" placeholder="비밀번호 확인" type="password">
	    </div> <!-- form-group// -->                                      
	    <div class="form-group">
	        <button type="submit" class="btn btn-warning btn-block"> 가입하기  </button>
	    </div> <!-- form-group// -->                                                                 
	</form>
	</article>
	</div> <!-- card.// -->
	
	</div> 
	<!--container end.//-->
</body>

</html>