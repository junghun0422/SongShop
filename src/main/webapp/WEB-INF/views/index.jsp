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
<!-- <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script> -->
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
					<!-- <span><i id="naver_id_login"></i></span> -->
					<span>
						<i id="kakao-login-btn">
							<a id="kakaoIdLogin_loginButton" href="#">
								<img src="images/kakao.png" height="60" style="border-radius:5px;">
							</a>
						</i>
					</span>
				</div>
			</div>
			<form method="post" action="/login-processing" id="loginForm" onsubmit="return check();">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
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
						<input type="submit" class="btn float-right login-btn" id="loginBtn" value="로그인">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">

	// 설정 정보 초기화
 	var naverLogin = new naver.LoginWithNaverId
	({
		cliendId		:	"0hBZHoIXRr7pJgK5UFL0",
		callbackUrl		:	"/navercallback",
		isPopup			:	true,
		loginButton		:	{ color: "green", type: 1, height: 60 },
		callbackHandle	: true
	}); 

	// 네아로 로그인 정보를 초기화하기 위하여 init() 호출.
 	naverLogin.init();

 	/*	
 	window.addEventListener( "load", function() 
	{
		naverLogin.getLoginStatus(function (status) 
		{
			if(status)
			{
				var email = naverLogin.user.getEmail();
				if( email == undefined || email == null ) 
				{
					alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
					naverLogin.reprompt();
					return;
				}

				console.log( naverLogin.user );
			}
			else alert("callback 처리 실패!!");
		});
	}); */

	$( "#joinIn" ).click(function() 
	{
		//location.replace("/treePage");
		location.replace( "/member/join-member" )
		//location.href="/oauth2/authorization/google";	
	});

	function check()
	{
		var user_id = $( "#user_id" ).val();
		var pwd = $( "#password" ).val();
		
		if( user_id == "" || pwd == "" ) 
		{
			alert( "로그인 정보를 입력해주세요." );
			return false;
		}
		else
			return true;
	}

	$("#kakao-login-btn").click(function() {
		var url = "${loginUrl}";
		location.href = url;
	});

	/*******************************************
		카카오 로그인 인증 후 사용자 정보
	********************************************/
/*   	Kakao.init("a8a5212775ee89de14206fd035f2b5ff");
	$("#kakao-login-btn").click(function() 
	{
 		Kakao.Auth.login(
		{
			persistAccessToken: true,
			persistRefreshToken: true,
			success	:	function( authObj )
			{
				console.log( JSON.stringify( authObj ) );
				console.log( "access :: " + authObj.access_token );
				console.log( "refresh :: " + authObj.refresh_token );
				console.log( "expires_in :: " + authObj.expires_in );
				console.log( "refresh_token_expires_in :: " + authObj.refresh_token_expires_in );
				console.log( "token_type :: " + authObj.token_type );

				Kakao.API.request(
				{
					url		:	"/v2/user/me",
					success	:	function( res )
					{
						console.log( res );
						console.log( JSON.stringify( res ) );
					}
				});
			},
			fail	:	function(err)
			{
				alert( "ERR :: " + JSON.stringify( err ) );
			}		
		});
	}); */

	$(function() 
	{
		if( localStorage.getItem( "user_id" ) != "" && localStorage.getItem( "user_id" ) != null && localStorage.getItem( "user_id" ) != "0" )
		{
			$( "#user_id" ).val( localStorage.getItem( "user_id" ) );
			$( "input:checkbox[id='storage']" ).prop( "checked", true );
		}

		$("input").on("blur keyup", function() { $(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) ); });

		// 로그인 실패시 사용할 부분
		var message = '${message}';
 		var blank_pattern = /^\s+|\s+$/g;
		if(message.replace(blank_pattern, "") != "") alert(message);
	});
</script>
</body>
</html>