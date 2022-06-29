<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>BEANEARTH SHOP</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/item-list.css">
</head>

<body>

	<jsp:include page="/views/header.jsp"></jsp:include>

	<div class="head-img">
		<p>ITEMS LINEUP</p>
	</div>

	<div class="container">

		<div class="convenient-menu">
			<form action="/ShoppingSite/jp/co/aforce/servlets/SearchByKeywordController" method="post">
				<input type="hidden" name="item_category" value="${item_category}">
				<p><input type="text" name="keyword" value="${keyword}"></p>
				<select name="sort">
					<option value="指定なし">指定なし</option>
					<option value="DESC">価格が高い順</option>
					<option value="ASC">価格が安い順</option>
				</select>
				<p><input type="submit" value="検索"></p>
				<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/views/shop.jsp'" value="ショップ一覧へ"></p>
			</form>

		</div>

		<ul>
			<c:forEach var="ib" items="${ItemList}">
				<li class="items">
					<form action="/ShoppingSite/jp/co/aforce/servlets/ScreenTransitionController" method="post">
						<div>
							<img class="items-img" src="${pageContext.request.contextPath}/img/${ib.item_photo}">
						</div>
						<input type="hidden" name="item_id" value="${ib.item_id}">
						<p>${ib.item_name}</p>
						<p>￥${ib.item_price}</p>
						<button id="insertCart" type="submit">カートに入れる</button>
					</form>
				</li>

			</c:forEach>
		</ul>

		<c:if test="${empty ItemList}">
			<div class="NoHitKeyword">
				<h2>検索キーワードに該当する商品はございません。</h2>
				<p>その他のカテゴリー、もしくは別のキーワードを入力してください。</p>
			</div>
		</c:if>

	</div>

	<jsp:include page="/views/footer.jsp"></jsp:include>

</body>

</html>