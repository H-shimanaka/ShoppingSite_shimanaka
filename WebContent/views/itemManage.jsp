<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>商品情報登録画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/itemManage.css">
</head>

<body>

	<h1>登録商品一覧</h1>

	<form class="item-regist" action="/ShoppingSite/jp/co/aforce/servlets/Items/ItemRegistController" method="post" enctype="multipart/form-data">

		<b>商品情報登録</b>

		<ul>

			<li>商品名<br>
				<input type="text" name="item_name" required></li>

			<li>値段<br>
				<input type="text" name="item_price" required></li>

			<li>商品画像<br>
				<input type="file" name="item_photo" required></li>

			<li>商品カテゴリー<br>
				<select name="item_category" required>
					<option value="コーヒー豆">コーヒー豆</option>
					<option value="コーヒー器具">コーヒー器具</option>
					<option value="その他食品など">その他食品など</option>
				</select></li>

			<li>商品情報<br>
				<textarea name="item_explain" required></textarea></li>
		</ul>

		<div class="regist-buttons">
			<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/administrator.jsp'" value="戻る">
			<input type="reset" value="リセット">
			<input type="submit" id="submit" value="商品追加">
		</div>

		<p>${errorMsg}</p>

	</form>

	<div class="registedItems">
		<ul>
			<c:forEach var="ib" items="${ItemList}">
				<li class="items">
					<form action="/ShoppingSite/jp/co/aforce/servlets/Items/UpdateOrDeleteController" method="post">
						<div>
							<img class="items-img" src="${pageContext.request.contextPath}/img/${ib.item_photo}">
						</div>
						<input type="hidden" name="item_id" value="${ib.item_id}">
						<p>${ib.item_name}</p>
						<p>￥${ib.item_price}</p>
						<button type="submit">変更・削除</button>
					</form>
				</li>
			</c:forEach>
		</ul>
	</div>


</body>

</html>