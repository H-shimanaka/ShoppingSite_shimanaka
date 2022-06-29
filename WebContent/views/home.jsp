<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>BEANEARTH HOME</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
</head>

<body>

	<jsp:include page="/views/header.jsp"></jsp:include>

	<div class="head-img">
		<p>A CUP OF SUPREME COFFEE<br>
			IN BEANEARTH</p>
	</div>

	<div class="container">

		<div class="shop-explain">
			<h2>What's the BEANEARTH?</h2>
			<p>私たちは「お客様にLuxuryを提供する」を目的として開業した焙煎店です。<br>
				開業以来、神楽坂の地で地元の方々にご愛顧いただいております。</p>
		</div>

		<div class="shop-image"></div>

		<div class="shop-explain">
			<p>店名の「BEANEARTH」はBean（豆）とEarth（地球）、そしてVenus（女神）の３つの単語を掛け合わせ、<br>
				「世界屈指のコーヒー豆を通して、至高の時を提供する女神」を体現すべく、営業させていただいております。</p>
		</div>

		<div class="sub-images">
			<div class="some-image image1"></div>
			<div class="some-image image2"></div>
			<div class="some-image image3"></div>
		</div>


	</div>

	<jsp:include page="/views/footer.jsp"></jsp:include>

</body>

</html>