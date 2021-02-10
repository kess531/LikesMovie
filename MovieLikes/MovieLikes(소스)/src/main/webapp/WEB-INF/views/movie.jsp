<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="UTF-8">
	<head>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c:choose사용 -->
		<meta http-equiv= "Content - Type" content="text/html; charset=UTF - 8">
	
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

		<title>영화가 좋다</title>

		<!-- 링크로 세팅 불러오기 -->
		
		<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath() %>/resources/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

		<!-- Loading main css file -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/style.css">

		<script src="<%=request.getContextPath() %>/resources/js/ie-support/html5.js"></script>
		<script src="<%=request.getContextPath() %>/resources/js/ie-support/respond.js"></script>
	

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
							<li class="menu-item"><a href="home">Home</a></li>
							<li class="menu-item"><a href="#">About</a></li>
							<li class="menu-item current-menu-item"><a href="movie">Movie List</a></li>
						</ul> <!-- .menu -->

						
					</div> <!-- .main-navigation -->

					<div class="mobile-navigation"></div>
				</div>
			</header>
	
			<main class="main-content">
				<div class="container">
					<div class="page">
						<div class="breadcrumbs">
							<a href="home">Home</a>
						<a href="movie">Movie List</a>
						</div>
				<form name="frm" action="movie" method="GET" >
						<div class="filters">
							<select name="col" id="filters">
								<option value="none"> </option>
								<option value="SF">SF</option>
								<option value="HORROR">호러</option>
								<option value="DOCU">드라마</option>							
								<option value="ACTION">액션</option>
								<option value="COMEDY">코미디</option>
								<option value="ANI">애니메이션</option>
								<option value="FANTASY">판타지</option>
							</select>
						
							</form>
							<input type="submit" class="submit1"  value ="적용">
							</div>
							
						
						<div class="movie-list">
						<c:forEach items="${movie}" var ="dto" begin = "${ (8 * (curPageNum - 1)) }" end = "${ (8 * (curPageNum - 1)) + 7  }">
							<div class="movie">
								<figure class="movie-poster">
									<a href="Contentview?movie_no=${dto.movie_no}"><img src="<%=request.getContextPath() %>/resources/Thum/${dto.movie_no}.jpg" width="270px" height="244px" alt="#"></a>
								</figure>
								<div class="movie-title${dto.movie_no}">
									<a href="Contentview?movie_no=${dto.movie_no}">${dto.movie_title}</a>
								</div>
							
							</div>
						</c:forEach>
						</div> <!-- .movie-list -->
						<div class="pagination">
						<c:choose>
						<c:when test="${col eq 'none' }">
							<c:if test="${curPageNum > 4}">
								<a href="movie?page=${blockStartNum -1}&col=${col}" class="page-number prev"><i class="fa fa-angle-left"></i></a>
							</c:if>
							<c:forEach var="i" begin="${blockStartNum}" end="${blockLastNum}">
								  <c:choose>
								  	<c:when test="${i == curPageNum}">
                    					<span class="page-number current">${i}</span>
               					 	</c:when>
               					 	<c:otherwise>
                    					<a href="movie?page=${i}&col=${col}" class="page-number">${i}</a>
                					</c:otherwise>
								 </c:choose>
							</c:forEach>
							<c:if test="${lastPageNum > blockLastNum}">
            					<a href="movie?page=${blockLastNum + 1}&col=${col}" class="page-number next"><i class="fa fa-angle-right"></i></a>
        					</c:if>
        				</c:when>
        				<c:otherwise>
							<c:if test="${curPageNum > 4}">
								<a href="movie?page=${blockStartNum -1}&col=${col}" class="page-number prev"><i class="fa fa-angle-left"></i></a>
							</c:if>
							<c:forEach var="i" begin="${blockStartNum}" end="${blockLastNum}">
								  <c:choose>
								  	<c:when test="${i == curPageNum}">
                    					<span class="page-number current">${i}</span>
               					 	</c:when>
               					 	<c:otherwise>
                    					<a href="movie?page=${i}&col=${col} " class="page-number">${i}</a>
                					</c:otherwise>
								 </c:choose>
							</c:forEach>
							<c:if test="${lastPageNum > blockLastNum}">
            					<a href="movie?page=${blockLastNum + 1}&col=${col}" class="page-number next"><i class="fa fa-angle-right"></i></a>
        					</c:if>
        				</c:otherwise>
						</c:choose>
						</div>
					</div>
					
				</div> <!-- .container -->
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
									<li>Lorem ipsum dolor</li>
									<li>Sit amet consecture</li>
									<li>Dolorem respequem</li>
									<li>Invenore veritae</li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Help Center</h3>
								<ul class="no-bullet">
									<li>Lorem ipsum dolor</li>
									<li>Sit amet consecture</li>
									<li>Dolorem respequem</li>
									<li>Invenore veritae</li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Join Us</h3>
								<ul class="no-bullet">
									<li>Lorem ipsum dolor</li>
									<li>Sit amet consecture</li>
									<li>Dolorem respequem</li>
									<li>Invenore veritae</li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Social Media</h3>
								<ul class="no-bullet">
									<li>Facebook</li>
									<li>Twitter</li>
									<li>Google+</li>
									<li>Pinterest</li>
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
		<!-- Default snippet for navigation -->
		


		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.1.min.js"></script>
		<script src="<%=request.getContextPath() %>/resources/js/plugins.js"></script>
		<script src="<%=request.getContextPath() %>/resources/js/app.js"></script>
		
	</body>

</html>