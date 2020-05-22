<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>LOGIN PAGE</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<!--Fontawesome CDN-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="css/login.css">

<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<script type="text/javascript" src="lib/scripts/jquery-1.12.4.min.js"></script>
</head>
<body>
<div class="_container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3> 로그인</h3>
				<div class="d-flex justify-content-end social_icon">
					<span><i id="naverIdLogin"></i></span>
					<span>
						<i id="kakao-login-btn">
							<a id="kakaoIdLogin_loginButton" href="#">
								<img src="images/kakao.png" height="60" style="border-radius:5px;">
							</a>
						</i>
					</span>
				</div>
			</div>
			<div class="card-body">
				<div class="input-group form-group">
					<div class="input-group-prepend">
						<span class="input-group-text"><i class="fas fa-user"></i></span>
					</div>
					<input type="text" class="form-control" placeholder="아이디" id="user_id" name="user_id">
				</div>
				<div class="input-group form-group">
					<div class="input-group-prepend">
						<span class="input-group-text"><i class="fas fa-key"></i></span>
					</div>
					<input type="password" class="form-control" placeholder="비밀번호" id="password" name="password">
				</div>
				<div class="row align-items-center remember">
					<input type="checkbox" id="storage">아이디 저장
				</div>
				<div class="form-group" style="margin-top:20px;">
					<button type="button" class="btn float-left join-in" id="joinIn">회원가입</button>
					<button type="button" class="btn float-right login-btn" id="loginBtn">로그인</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var naverLogin = new naver.LoginWithNaverId
	({
		cliendId	:	"0hBZHoIXRr7pJgK5UFL0",
		callbackUrl	:	"/navercallback",
		isPopup		:	true,
		loginButton	:	{ color: "green", type: 1, height: 60 }
	});

	// 설정정보를 초기화하고 연동을 준비
	naverLogin.init();

	$("#joinIn").click(function() 
	{
		//location.replace("/treePage");

		location.replace("/join")	
	});

	
/*
	window.addEventListener("load", function() 
	{
		naverLogin.getLoginStatus(function (status) 
		{
			if(status)
			{
				var email = naverLogin.user.getEmail();
				if(email == undefined || email == null) 
				{
					alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
					naverLogin.reprompt();
					return;
				}

				console.log(naverLogin.user);
			}
			//else alert("callback 처리 실패!!");
		});
	});


	$("#kakao-login-btn").click(function() 
	{
		Kakao.init("6ed0d6ca2676817edc66eca6454f4c72");
		Kakao.Auth.login(
		{
			persistAccessToken: true,
			persistRefreshToken: true,
			success	:	function(authObj)
			{
				
			},
			fail	:	function(err)
			{
				alert("ERR :: " + JSON.stringify(err));
			}		
		});
	});
	 */
	

	$("#loginBtn").click(function() 
	{
		if("" == $("#user_id").val() || "" == $("#password").val())
		{
			alert("로그인 정보를 입력해주세요.");
			return;
		}

		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");

		var jsonData = {
			"user_id" : $("#user_id").val(), 
			"password" : $("#password").val()
		};
		
		$.ajax({
			url			:	"/memeber/login",
			type		:	"post",	
			datatype	:	"json",
			data		:	jsonData,
			beforeSend	:	function(xhr)
			{
				xhr.setRequestHeader(header, token);
			},
			success		:	function(data)
			{
				alert(data);
			},
			error		:	function(request, status, error)
			{
				alert("ERROR :: " + request.status + " | " + request.responseText + " | " + error);
			}
		});

/* 		if($("input:checkbox[id='storage']").is(":checked")) 
			localStorage.setItem("user_id", $("#user_id").val());
		else 
			localStorage.setItem("user_id", "0"); */
	});

	$(function() 
	{
		if(localStorage.getItem("user_id") != "" && localStorage.getItem("user_id") != null && localStorage.getItem("user_id") != "0")
		{
			$("#user_id").val(localStorage.getItem("user_id"));
			$("input:checkbox[id='storage']").prop("checked", true);
		}

		$("input").on("blur keyup", function() { $(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) ); });
	});
</script>
</body>
</html>