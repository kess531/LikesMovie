<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
	<head>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- Date 타입 포맷변환 -->
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c:choose사용 -->
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %> 
	<title>영화가 좋다</title>

		<!-- Loading third party fonts -->
		
		<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath() %>/resources/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

		<!-- Loading main css file -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/style.css">

		<script src="<%=request.getContextPath() %>/resources/js/ie-support/html5.js"></script>
		<script src="<%=request.getContextPath() %>/resources/js/ie-support/respond.js"></script>

	</head>
<script type="text/javascript">
function sendIt() {
	   // var password = document.user_pwd.value;
	
	    if (document.write.user_id.value == "") {
	        alert("작성자 이름을 입력하지 않았습니다.");
	        document.write.user_id.focus();
	        return false;
	    }
	    if (document.write.user_pwd.value == "") {
	        alert("비밀번호를 입력하지 않았습니다.");
	        document.write.user_pwd.focus();
	        return false;
	    }

	    if (document.write.review_content.value == "") {
	        alert("리뷰를 작성하지 않았습니다.");
	        document.write.review_content.focus();
	        return false;
	    } 
	    if (document.write.review_content.value == "") {
	        alert("리뷰를 작성하지 않았습니다.");
	        document.write.review_content.focus();
	        return false;
	    } 
	    
	}


</script>

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
							<li class="menu-item"><a href="index.html">Home</a></li>
							<li class="menu-item"><a href="about.html">About</a></li>
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
							<a href="index.html">Home</a>
							<a href="movie">Movie List</a>
							<span>${Contentview.movie_title}</span>
						</div>

						<div class="content">
							<div class="row">
								<div class="col-md-6">
									<figure class="movie-poster"><img src="<%=request.getContextPath()%>/resources/Thum/${Contentview.movie_no}.jpg" height="550px" alt="#"></figure>
								</div>
								<div class="col-md-6">
									<h2 class="movie-title">${Contentview.movie_title}</h2>
									<div class="movie-summary">
										<p>${Contentview.movie_content}</p>
									</div>
									<ul class="movie-meta">
										<li><strong>Rating:</strong>
											<div class="star-rating" title="Rated 4.00 out of 5"><span style="width:${ avg_star * 20 }%"><strong class="rating">4.00</strong> out of 5</span></div>
										</li>
										<li><strong>Length:</strong> ${Contentview.movie_length} min</li>
										<li><strong>Premiere:</strong> ${Contentview.movie_date_y}/${Contentview.movie_date_m}/${Contentview.movie_date_d} </li>
										<c:set var="genre" value="${Contentview.movie_genre}"/>
										<li><strong>Category:</strong> <c:choose>
										<c:when test="${genre eq 'SF'}">
										  SF</c:when>
										 <c:when test="${genre eq 'FANTASY'}">
										  판타지</c:when>
										 <c:when test="${genre eq 'HORROR'}">
										  호러</c:when>
										 <c:when test="${genre eq 'DOCU'}">
										  다큐멘터리</c:when>
										 <c:when test="${genre eq 'ROMANCE'}">
										  로멘스</c:when>
										  <c:when test="${genre eq 'ACTION'}">
										  액션</c:when>
										 <c:when test="${genre eq 'COMEDY'}">
										  코미디</c:when>
										 <c:when test="${genre eq 'ANI'}">
										  애니메이션</c:when>								 
										 </c:choose>	 
										 </li>										
									</ul>
									<ul class="starring">
										<li><strong>Directors:</strong> ${Contentview.movie_directors}</li>
										<li><strong>Stars:</strong> ${Contentview.movie_actor}</li>
									</ul>
								</div>
							</div> <!-- .row -->
							<div class="entry-content">
					
		<div class='embed-container'>

		<iframe src="${Contentview.movie_url}" frameborder="0" allowfullscreen width="100%" height="600px"></iframe>

		</div>
<form action="write" method="post">

<div class= "reviewwrite1">
	<div>
		<input type="text" name="user_id" placeholder="작성자">
		<input type="hidden" name="movie_no" value="${Contentview.movie_no}">
		<input type="password" name="user_pwd">

		<div class="reviewwrite2">
		<textarea class="textarea1"  name="review_content" style="width: 800px; height: 50px;"></textarea>
		<select name="review_star" >
	    <option value="1">★</option>
	    <option value="2">★★</option>
	    <option value="3">★★★</option>
	    <option value="4">★★★★</option>
	    <option value="5">★★★★★</option>
	     </select>
	     <input type="submit" class="submit1"  value ="입력">
					</div>
				
				</div>
				</div>
			</form>
<div class="fullreview">

 <c:forEach items="${review}" var="dto">


<ul>
<li>

<div class="review1">
<b style="font-size: 15px;">${dto.review_content}</b>
</div>
<div class="review2">
<div class="star-rating" title="Rated 4.00 out of 5"><span style="width:${ dto.review_star * 20 }%"><strong class="rating">4.00</strong> out of 5</span></div>
<div style="float:right;">
<form action= "delete?review_no=${dto.review_no}" method="post">

				<input type="hidden" name="movie_no" value="${Contentview.movie_no}">
				<input type="password" name="user_pwd1">
				<input type="submit" value="삭제">
				</form></div>
</div>
<div class="review3">
<dl>
<dt>
<em style="width: 50px">${dto.user_id}</em>
<em style="width: 50px"><fmt:formatDate value="${dto.review_date}" pattern="yyyy-MM-dd hh : mm" /></em>
</dt>
</dl>
</div>

</li>
</ul>






 </c:forEach>
</div>




							</div>
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