<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>購入内容確認画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/purchase-confirm.css">
</head>

<body>

	<jsp:include page="/views/header.jsp"></jsp:include>

	<div class="head-img">
		<p>MY SHOPPING CART</p>
	</div>

	<div class="container">

		<form action="/ShoppingSite/jp/co/aforce/servlets/PurchaseController" method="post">
			<ul class="cartItems">
				<c:forEach var="cb" items="${CartList}">
					<li class="items">
						<img src="${pageContext.request.contextPath}/img/${cb.item_photo}">
						<p>${cb.item_name}</p>
						<p>￥${cb.item_price}, ${cb.item_count}個</p>
						<p>計:${cb.total_price}</p>
					</li>
				</c:forEach>
			</ul>

			<div>
				<ul class="check-form">

					<li>合計金額：
						\<input id="cart_total_price" type="number" name="cart_total_price" value="${cart_total_price}" readonly></li>

					<li>配送方法：
						<select name="logistic" required>
							<option value="直送">登録住所へ直送</option>
							<option value="営業所受取">お近くの営業所で受け取り</option>
							<option value="宅配ロッカー">宅配ロッカー</option>
						</select></li>

					<li>お支払方法：
						<select name="payment_method" required>
							<option value="現金振込">現金振込</option>
							<option value="クレジット">クレジットカード</option>
							<option value="その他">その他</option>
						</select></li>

				</ul>
			</div>

			<div class="purchase-confirm">
				<button type="submit">購入</button>
			</div>


		</form>

		<form class="return-button" action="/ShoppingSite/jp/co/aforce/servlets/AllItemCartController" method="post">
			<button type="submit">カートへ戻る</button>
		</form>


	</div>

	<jsp:include page="/views/footer.jsp"></jsp:include>

</body>

</html>