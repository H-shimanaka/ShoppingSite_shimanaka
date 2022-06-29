<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>カート内容変更画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/changeCartContents.css">
</head>

<body>

	<div class="item-photo">
		<img src="${pageContext.request.contextPath}/img/${cb.item_photo}">
	</div>

	<div class="update_delete">

		<form action="/ShoppingSite/jp/co/aforce/servlets/UpdateCartContentController" method="post">

			<b>カート内容変更</b>
			<input type="hidden" name="cart_item_num" value="${cb.cart_item_num}">

			<ul>
				<li>${cb.item_name}</li>

				<li>\<input id="item_price" type="number" value="${cb.item_price}" readonly></li>

				<li>個数<br>
					<input type="number" name="count" value="${cb.item_count}" min="1" max="99" required>個</li>

				<li>合計<br>
					\<input id="total_price" type="number" name="total_price" value="${cb.total_price}" readonly></li>
			</ul>

			<div class="buttons">
				<input type="submit" value="変更">
			</div>

		</form>

		<form class="delete-button" action="/ShoppingSite/jp/co/aforce/servlets/DeleteCartContentController" method="post">
			<input type="hidden" name="cart_item_num" value="${cb.cart_item_num}">
			<input type="submit" value="削除する">
		</form>

		<form class="return-button" action="/ShoppingSite/jp/co/aforce/servlets/AllItemCartController" method="post">
			<input type="submit" value="戻る">
		</form>

		<p>${errorMsg}</p>

	</div>

	<script src="${pageContext.request.contextPath}/js/cart-js.js"></script>

</body>

</html>