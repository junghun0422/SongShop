<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	html, body
	{
		width	:	100%;
		height	:	100%:
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
</style>
<body>
<div class="container">
	<div class="card-deck mb-3 text-center">
    	<div class="card mb-4 shadow-sm" id="product">
      		<div class="card-header">
        		<h4 class="my-0 font-weight-normal">상품 목록</h4>
      		</div>
      		<div class="card-body">
        		<h1 class="card-title pricing-card-title">상품</h1>
        		<ul class="list-unstyled mt-3 mb-4">
					<li> 상품 등록 </li>
					<li> 상품 수정 </li>
					<li> 상품 목록 </li>
					<li> 상품 삭제 </li>
				</ul>
        		<button type="button" class="btn btn-lg btn-block btn-primary">상품목록으로...</button>
      		</div>
    	</div>
    	
    	<div class="card mb-4 shadow-sm">
      		<div class="card-header">
        		<h4 class="my-0 font-weight-normal">수입 / 통계</h4>
      		</div>
      		<div class="card-body">
		        <h1 class="card-title pricing-card-title">$15 <small class="text-muted">/ mo</small></h1>
		        <ul class="list-unstyled mt-3 mb-4">
					<li>20 users included</li>
					<li>10 GB of storage</li>
					<li>Priority email support</li>
					<li>Help center access</li>
		        </ul>
        		<button type="button" class="btn btn-lg btn-block btn-primary">Get started</button>
      		</div>
    	</div>
    	
	    <div class="card mb-4 shadow-sm" id="inquiry">
	    	<div class="card-header">
	        	<h4 class="my-0 font-weight-normal">문의</h4>
	      	</div>
	      	<div class="card-body">
	        	<h1 class="card-title pricing-card-title">$29 <small class="text-muted">/ mo</small></h1>
	        	<ul class="list-unstyled mt-3 mb-4">
		          <li>30 users included</li>
		          <li>15 GB of storage</li>
		          <li>Phone and email support</li>
		          <li>Help center access</li>
	        	</ul>
	        	<button type="button" class="btn btn-lg btn-block btn-primary">Contact us</button>
	      	</div>
	    </div>
	</div>
</div>
</body>
<script type="text/javascript">

	var sellMain = 
	{
		observe : function() 
		{
			$("div").bind("click", function(event) { sellMain.eventControl(event); })
		},
		eventControl : function(e) 
		{
			switch(e.currentTarget.id)
			{
				case "inquiry" :
					sellMain.movePage("inquiry");
					e.preventDefault();
					break;
				case "product" :
					sellMain.movePage("product");
					e.preventDefault();
					break;
			}
		},
		movePage : function(id)
		{
			let	url;
			switch(id)
			{
				case "inquiry" :
					url = "/inquiry/goInquiry";
					break;
				case "product" :
					url = "/product/goProduct";
					break;
			} 

			location.replace(url);
		}
	}

	$(function() 
	{
		sellMain.observe();
	});
</script>