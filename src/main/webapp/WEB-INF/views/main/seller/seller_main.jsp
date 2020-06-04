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
    	<div class="card mb-4 shadow-sm">
      		<div class="card-header">
        		<h4 class="my-0 font-weight-normal">상품</h4>
      		</div>
      		<div class="card-body">
        		<h1 class="card-title pricing-card-title">$0 <small class="text-muted">/ mo</small></h1>
        		<ul class="list-unstyled mt-3 mb-4">
					<li>10 users included</li>
					<li>2 GB of storage</li>
					<li>Email support</li>
					<li>Help center access</li>
        		</ul>
        		<button type="button" class="btn btn-lg btn-block btn-outline-primary">Sign up for free</button>
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
    	
	    <div class="card mb-4 shadow-sm">
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
