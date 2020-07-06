<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

</style>
<body>
	<main role="main">
    	<section class="jumbotron text-center">
	        <div class="container">
	        	<!-- <h1 class="jumbotron-heading">Song Shoppingmall</h1> -->
	        </div>
	        <button type="button" class="btn btn-danger regi" id="btnRegister">REGISTER</button>
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
    
    <script type="text/javascript">
/* 		$("#btnRegister").click(function() 
		{
			$(".fade").css("display", "block");
		}); */
	</script>
</body>