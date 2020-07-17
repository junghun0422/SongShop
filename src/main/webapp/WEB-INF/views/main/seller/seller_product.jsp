<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<style>
ul
{
	list-style : none;
}

.jumbotron
{
	margin-bottom : 0px;
}

.wrap
{
	position			:	absolute;
	width				:	500px;
	height				:	500px;
	top					:	50%;
	left				:	50%;
	margin				:	auto;
	background-color	:	#f8f9fa;
	transform			:	translateX(-50%) translateY(-50%);
	-moz-transform		:	translateX(-50%) translateY(-50%);  
	-webkit-transform	:	translateX(-50%) translateY(-50%);  
	-o-transform		:	translateX(-50%) translateY(-50%);
	-ms-transform		:	translateX(-50%) translateY(-50%);
}

.regi
{
	float : right;
}

.top label
{
    font-size : larger;
    font-weight : bold;
    margin-top : .5rem;
}

 .modal-dialog 
{
	height : 80% !important;
	padding-top : 4%;
}
</style>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../lib/scripts/jquery-1.12.4.min.js"></script>
</head>
<body>
	<main role="main">
    	<section class="jumbotron text-center">
	        <div class="container">
	        	<!-- <h1 class="jumbotron-heading">Song Shoppingmall</h1> -->
	        </div>
	        <button type="button" class="btn btn-danger regi" data-toggle="modal" data-target="#modalProduct">상품등록</button>
		</section>

		<div class="album py-5 bg-light">
			<div class="container">
				<div class="row">
				
					<c:forEach var="i" begin="0" end="8">
						<div class="col-md-4">
							<div class="car mb-4 shadow-sm">
								<img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22348%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20348%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_1725538e6c7%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A17pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_1725538e6c7%22%3E%3Crect%20width%3D%22348%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22116.71875%22%20y%3D%22120.3%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
								<div class="card-body">
									<p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">
											<button type="button" class="btn btn-sm btn-outline-secondary">Detail</button>
											<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
										</div>
									<small class="text-muted">9 mins</small>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
    </main>

	<!-- Product Modal -->
	<div class="modal fade" id="modalProduct" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
  	<div class="modal-content">
    	<div class="modal-header">
    		<h5>상품등록</h5>
      		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    	</div>
    	<div class="modal-body">
			<div class="d_0">
				<span>구분</span>
				<select class="form-control" id="category_box"></select>
			</div>
			<div class="d_1">
		  		<span>상품명 
		  			<input type="text" class="form-control" name="product_nm" id="product_nm">
		  		</span>
		  	</div>
			<div class="d_2">
		  		<span>가격 
		  			<input type="number" class="form-control" name="product_price" id="product_price" />
		  		</span>
		  	</div>
			<div class="d_3">
	  			<span>첨부
	  				<input type="file" class="form-control" name="product_img" id="product_img" accept=".jpg, .png"/>
	  			</span>
  			</div>
			<div class="d_4">
  				<span>설명
  					<textarea class="form-control" rows="6" cols="10" name="proudct_des" id="proudct_des" style="resize:none;"></textarea>
				</span>
			</div>
    	</div>
    	<div class="modal-footer">
    		<button type="button" class="btn btn-warning productBtn" onclick="checkVal();">확인</button>
      		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
    	</div>
  	</div>
	</div>
	</div>
    <script type="text/javascript">
    	var header = "", token = "", userInfo = "";
    	
		var checkVal = () => 
		{
			if($("#product_nm").val() == '')
			{
				alert("상품이름을 입력해주세요.");
				$("#product_nm").focus();
				return;
			}

			if($("#product_price").val() == '')
			{
				alert("상품가격을 입력해주세요.");
				$("#product_price").focus();
				return;
			}

			if($("#product_img").get(0).files.length < 1)
			{
				alert("파일을 선택해주세요.");
				return;
			}
			
			var formData = new FormData(); 
			formData.append("product_img", $("#product_img").prop("files")[0]);
			formData.append("category_code", $("#category_box option:selected").val());
			formData.append("category_nm", $("#category_box option:selected").text());
 			formData.append("product_nm", $("#product_nm").val());
			formData.append("product_price", $("#product_price").val());
			formData.append("product_des", $("#proudct_des").val());

			$.ajax(
			{
				url 		:	"/seller/registProduct",
				type		:	"post",
				dataType	:	"json",
				data		:	formData,
			    processData	:	false,
			    contentType	:	false,
			    beforeSend	:	function(xhr)
			    {
			    	// 데이터를 전송하기 전에 헤더에 csrf값 설정
					xhr.setRequestHeader(header, token);
				},
				success 	:	function(responseData)
				{
					console.log("code :: " + responseData.code + ", msg :: " + responseData.message);

					if("00" == responseData.code)
					{
						$("[data-dismiss=modal]").trigger({ type: "click" });
						$("#product_nm").val("");
						$("#product_price").val("");
						$("#product_img").val("");
						$("#proudct_des").val("");
					}
					else 
					{
						alert("상품정보를 확인해주세요.");
					}
				},
				error		:	function(request, status, error)
				{
					console.log(request.status);
					console.log(request.responseText);
					console.log(error);
	 			}
			});
		}

		var searchCategoryList = () =>
		{
			console.log("searchCategoryList start . . . .");
			$.ajax(
			{
				url			:	"/product/searchCategoryList",
				type		:	"post",
				beforeSend	:	function(xhr)
				{
					xhr.setRequestHeader(header, token);
				},
				success		:	function(responseData)
				{
					console.log("searchCategoryList resultCode :: " + responseData.code);

					if("00" == responseData.code)
					{
						var tag = "";
						for(var i=0; i<responseData.data.length; i++)
						{
							tag += '<option value="' + responseData.data[i].categoryCode + '">' + responseData.data[i].categoryNm + '</option>';
						}

						$("#category_box").append(tag);
					}
				},
				error		:	function(request, status, error)
				{
					console.log(request.status);
					console.log(request.responseText);
					console.log(error);
	 			}
			});
		}

		var searchProductList = () =>
		{
			console.log("searchProductList start.... :: " + userInfo);
			
			$.ajax(
			{
				url			:	"/product/product_list/" + userInfo,
				type		:	"post",
			    beforeSend	:	function(xhr)
			    {
			    	// 데이터를 전송하기 전에 헤더에 csrf값 설정
					xhr.setRequestHeader(header, token);
				},
				success		:	function(responseData)
				{
					console.log("searchProductList resultCode :: " + responseData.code);
					console.log("searchProductList resultData.length :: " + responseData.data.length);
					console.log(responseData.data);
					for( var i=0; i<responseData.data.length; i++ )
					{
						console.log(responseData.data[i].categoryNm + " | " + responseData.data[i].categoryCode + ", " + responseData.data[i].productNm + " | " + responseData.data[i].productPrice);
					}
				},
				error		:	function(request, status, error)
				{
					console.log(request.status);
					console.log(request.responseText);
					console.log(error);
	 			}
			});
		} 

		var repositoryProductList = () =>
		{
			console.log("testList start.... :: " + userInfo);
			
			$.ajax(
			{
				url			:	"/product/testList/" + userInfo,
				type		:	"post",
			    beforeSend	:	function(xhr)
			    {
			    	// 데이터를 전송하기 전에 헤더에 csrf값 설정
					xhr.setRequestHeader(header, token);
				},
				success		:	function(responseData)
				{
					console.log(responseData);
					for(var i=0; i<responseData.length; i++)
					{
						console.log(responseData[i].categoryNm + "(" + responseData[i].categoryCode + ") => " + responseData[i].productNm + "_" + responseData[i].productPrice);
					}
				},
				error		:	function(request, status, error)
				{
					console.log(request.status);
					console.log(request.responseText);
					console.log(error);
	 			}
			});
		} 

		$(function() 
		{
 			token = $("meta[name='_csrf']").attr("content");
			header =  $("meta[name='_csrf_header']").attr("content");

			userInfo = "${userInfo}";
			
			searchCategoryList();
			//repositoryProductList();
			searchProductList();
		});
	</script>
</body>