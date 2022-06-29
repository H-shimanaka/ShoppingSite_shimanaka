<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>カート追加</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cartAdd.css">
</head>

<body>

	<jsp:include page="/views/header.jsp"></jsp:include>

	<div class="under-bar"></div>

	<div class="container">

		<div>
			<img  class="item-image" src="${pageContext.request.contextPath}/img/${ib.item_photo}">
		</div>

		<div class="purchase-form">
			<form action="/ShoppingSite/jp/co/aforce/servlets/CartAddController" method="post">
				<input type="hidden" name="item_id" value="${ib.item_id}">
				<h2>${ib.item_name}</h2>
				<p>\<input id="item_price" type="number" value="${ib.item_price}" readonly></p>
				<p>個数<br>
					<input type="number" name="count" min="1" max="99" required></p>
				<p>合計<br>
					\<input id="total_price" type="number" name="total_price" readonly></p>
				<button id="insertCart" type="submit">カートに入れる</button>
				<p>${ib.item_explain}</p>
			</form>

			<form action="/ShoppingSite/jp/co/aforce/servlets/ShoppingController" method="post">
				<input type="hidden" name="item_category" value="${ib.item_category}">
				<button type="submit">商品一覧へ</button>
			</form>
		</div>

	</div>

	<jsp:include page="/views/footer.jsp"></jsp:include>

	<script src="${pageContext.request.contextPath}/js/cart-js.js"></script>

</body>

</html>