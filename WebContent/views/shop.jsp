<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>BEANEARTH SHOP</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop.css">
</head>

<body>

	<jsp:include page="/views/header.jsp"></jsp:include>

	<div class="head-img">
		<p>ITEMS LINEUP</p>
	</div>

	<div class="container">

		<h2>～LINE UP～</h2>

		<div class="item-category">

			<form action="/ShoppingSite/jp/co/aforce/servlets/ShoppingController" method="post">
				<input type="hidden" name="item_category" value="コーヒー豆">
				<button class="category-button category-img1" type="submit">Coffee Beans</button>
			</form>

			<form action="/ShoppingSite/jp/co/aforce/servlets/ShoppingController" method="post">
				<input type="hidden" name="item_category" value="コーヒー器具">
				<button class="category-button category-img2" type="submit">Utilities</button>
			</form>

			<form action="/ShoppingSite/jp/co/aforce/servlets/ShoppingController" method="post">
				<input type="hidden" name="item_category" value="その他食品など">
				<button class="category-button category-img3" type="submit">Other Foods.etc</button>
			</form>

		</div>



	</div>

	<jsp:include page="/views/footer.jsp"></jsp:include>

</body>

</html>