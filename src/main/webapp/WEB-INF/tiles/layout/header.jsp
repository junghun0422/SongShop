<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<style>
	.footer
	{
		position: absolute;
	    bottom: 0;
	    width: 100%;
	    height: 60px;
	    line-height: 60px;
	    background-color: #f5f5f5;
	}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="#">SongShop</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          		<span class="navbar-toggler-icon"></span>
        	</button>
        	<div class="collapse navbar-collapse" id="navbarCollapse">
          		<ul class="navbar-nav mr-auto">
            		<li class="nav-item active">
              			<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            		</li>
		            <li class="nav-item">
		              <a class="nav-link" href="#">Link</a>
		            </li>
		            <li class="nav-item">
		              <a class="nav-link disabled" href="#">Disabled</a>
		            </li>
          		</ul>
          		<span class="userInfo" style="margin-right:15px; color:white;">${userInfo}</span>
          		<form class="form-inline mt-2 mt-md-0">
 	           		<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
    	       	 	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
          		</form>
        	</div>
		</nav>
	</header>
	
	
	<footer class="footer">
      <div class="container">
        <span class="text-muted">SongShop</span>
      </div>
    </footer>
</body>
<script type="text/javascript">
	
</script>
</html>