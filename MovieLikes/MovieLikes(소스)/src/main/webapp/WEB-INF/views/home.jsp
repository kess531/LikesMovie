<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
	<head>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c:choose사용 -->
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

		<title>영화가 좋다</title>

		<!-- Loading third party fonts -->
		
		<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath() %>/resources/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

		<!-- Loading main css file -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/style.css">
<%-- 
		<script src="<%=request.getContextPath() %>/resources/js/ie-support/html5.js"></script>
		<script src="<%=request.getContextPath() %>/resources/js/ie-support/respond.js"></script> --%>
	
<script type="text/javascript">
function nan() {
	var result = Math.floor(Math.random() * 10) + 1;
	for(var i=0; i<10; i++)
		{
		
		}
}

</script>
	</head>


	<body>

	<div id="site-content">
			<header class="site-header">
				<div class="container">
					<a href="home" id="branding">
						<img src="<%=request.getContextPath() %>/resources/images/logo.png" alt="" class="logo">
						<div class="logo-copy">
							<h1 class="site-title">영화가 좋다</h1>
							<small class="site-description">Movie Likes</small>
						</div>
					</a> <!-- #branding -->

					<div class="main-navigation">
						<button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
						<ul class="menu">
							<li class="menu-item current-menu-item"><a href="index.html">Home</a></li>
							<li class="menu-item"><a href="about.html">About</a></li>
							<li class="menu-item"><a href="movie">Movie List</a></li>
						</ul> <!-- .menu -->

						
					</div> <!-- .main-navigation -->

					<div class="mobile-navigation"></div>
				</div>
			</header>
			<main class="main-content">
				<div class="container">
					<div class="page">
						<div class="row">
							<div class="col-md-9">
								<div class="slider">
									<ul class="slides">
										<li><a href="Contentview?movie_no=26"><img src="<%=request.getContextPath()%>/resources/Thum/26.jpg" alt="Slide 1"></a></li>
										<li><a href="Contentview?movie_no=32"><img src="<%=request.getContextPath() %>/resources/Thum/32.jpg" alt="Slide 2"></a></li>
										<li><a href="Contentview?movie_no=43"><img src="<%=request.getContextPath() %>/resources/Thum/43.jpg"" alt="Slide 3"></a></li>
									</ul>
								</div>
							</div>	
							
							<div class="col-md-3">
								<div class="row">
									<div class="col-sm-6 col-md-12">
										<div class="latest-movie">
											<a href="Contentview?movie_no=10"><img src="<%=request.getContextPath()%>/resources/Thum/10.jpg" alt="Movie 1"></a>
										</div>
									</div>
									<div class="col-sm-6 col-md-12">
										<div class="latest-movie">
											<a href="Contentview?movie_no=11"><img src="<%=request.getContextPath()%>/resources/Thum/11.jpg"  alt="Movie 2"></a>
										</div>
									</div>
									<div class="col-sm-6 col-md-12">
										<div class="latest-movie">
											<a href="Contentview?movie_no=51"><img src="<%=request.getContextPath()%>/resources/Thum/51.jpg"  alt="Movie 2"></a>
										</div>
									</div>
								</div>
							</div>
						</div> <!-- .row -->
						<div class="row">
							<div class="col-sm-6 col-md-3">
								<div class="latest-movie">
									<a href="Contentview?movie_no=12"><img src="<%=request.getContextPath()%>/resources/Thum/12.jpg"  alt="Movie 3"></a>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="latest-movie">
									<a href="Contentview?movie_no=14"><img src="<%=request.getContextPath()%>/resources/Thum/14.jpg"  alt="Movie 4"></a>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="latest-movie">
									<a href="Contentview?movie_no=38"><img src="<%=request.getContextPath()%>/resources/Thum/38.jpg"  alt="Movie 5"></a>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="latest-movie">
									<a href="Contentview?movie_no=55"><img src="<%=request.getContextPath()%>/resources/Thum/55.jpg"  alt="Movie 6"></a>
								</div>
							</div>
						</div> <!-- .row -->

					 <!-- .container -->
			</main>
			<footer class="site-footer">
				<div class="container">
					<div class="row">
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">About Us</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quia tempore vitae mollitia nesciunt saepe cupiditate</p>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Recent Review</h3>
								<ul class="no-bullet">
									<li><a href="#">Lorem ipsum dolor</a></li>
									<li><a href="#">Sit amet consecture</a></li>
									<li><a href="#">Dolorem respequem</a></li>
									<li><a href="#">Invenore veritae</a></li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Help Center</h3>
								<ul class="no-bullet">
									<li><a href="#">Lorem ipsum dolor</a></li>
									<li><a href="#">Sit amet consecture</a></li>
									<li><a href="#">Dolorem respequem</a></li>
									<li><a href="#">Invenore veritae</a></li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Join Us</h3>
								<ul class="no-bullet">
									<li><a href="#">Lorem ipsum dolor</a></li>
									<li><a href="#">Sit amet consecture</a></li>
									<li><a href="#">Dolorem respequem</a></li>
									<li><a href="#">Invenore veritae</a></li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Social Media</h3>
								<ul class="no-bullet">
									<li><a href="#">Facebook</a></li>
									<li><a href="#">Twitter</a></li>
									<li><a href="#">Google+</a></li>
									<li><a href="#">Pinterest</a></li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Newsletter</h3>
								<form action="#" class="subscribe-form">
									<input type="text" placeholder="Email Address">
								</form>
							</div>
						</div>
					</div> <!-- .row -->

					<div class="colophon">Copyright 2014 Company name, Designed by Themezy. All rights reserved</div>
				</div> <!-- .container -->

			</footer>
		</div>
				<script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.1.min.js"></script>
		<script src="<%=request.getContextPath() %>/resources/js/plugins.js"></script>
		<script src="<%=request.getContextPath() %>/resources/js/app.js"></script>

	</body>

</html>
		