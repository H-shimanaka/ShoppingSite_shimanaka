<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>マイカート</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member-cart.css">
</head>

<body>

	<jsp:include page="/views/header.jsp"></jsp:include>

	<div class="head-img">
		<p>MY SHOPPING CART</p>
	</div>

	<div class="container">

		<ul class="cartItems">
			<c:forEach var="cb" items="${CartList}">
				<li class="items">
					<form action="/ShoppingSite/jp/co/aforce/servlets/ChangeCartContentsController" method="post">
						<img src="${pageContext.request.contextPath}/img/${cb.item_photo}">
						<input type="hidden" name="cart_item_num" value="${cb.cart_item_num}">
						<p>${cb.item_name}</p>
						<p>￥${cb.item_price}, ${cb.item_count}個</p>
						<p>計:￥${cb.total_price}</p>
						<button type="submit">変更・削除</button>
					</form>
				</li>
			</c:forEach>
		</ul>

		<c:if test="${empty CartList}">
			<div class="emptyCart">
				<h2>カートに商品が入っておりません</h2>
				<p>ぜひお買い物をお楽しみください。ご利用をお待ちしております。</p>
			</div>

		</c:if>

		<c:if test="${not empty CartList}">
			<div id="purchase-confirm">
				<form action="/ShoppingSite/jp/co/aforce/servlets/PurchaseConfirmController" method="post">
					<button type="submit">購入内容確認へ</button>
				</form>
			</div>

		</c:if>


	</div>

	<jsp:include page="/views/footer.jsp"></jsp:include>

</body>

</html>