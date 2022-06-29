<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>商品情報変更画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/update_delete.css">
</head>

<body>

	<div class="item-photo">
		<img src="${pageContext.request.contextPath}/img/${ib.item_photo}">
	</div>

	<div class="update_delete">

		<form action="/ShoppingSite/jp/co/aforce/servlets/Items/ItemUpdateController" method="post" enctype="multipart/form-data">

			<b>商品情報変更</b>

			<ul>
				<li>商品番号<br>
					<input type="text" name="item_id" value="${ib.item_id}" readonly></li>

				<li>商品名<br>
					<input type="text" name="item_name" value="${ib.item_name}" required></li>

				<li>値段<br>
					<input type="text" name="item_price" value="${ib.item_price}" required></li>

				<li>商品画像<br>
					<input type="file" name="item_photo" required></li>

				<li>商品カテゴリー<br>
					<select name="item_category" required>
						<option value="コーヒー豆">コーヒー豆</option>
						<option value="コーヒー器具">コーヒー器具</option>
						<option value="その他食品など">その他食品など</option>
						<c:if test="${not empty ib.item_category}">
						<c:choose>
							<c:when test="${ib.item_category == 'コーヒー豆'}">
								<option value="コーヒー豆" selected>コーヒー豆(設定値)</option>
							</c:when>
							<c:when test="${ib.item_category == 'コーヒー器具'}">
								<option value="コーヒー器具" selected>コーヒー器具(設定値)</option>
							</c:when>
							<c:when test="${ib.item_category == 'その他食品など'}">
								<option value="その他食品など" selected>その他食品など(設定値)</option>
							</c:when>
						</c:choose>
					</c:if>
					</select></li>

				<li>商品情報<br>
					<textarea name="item_explain" required>${ib.item_explain}</textarea></li>
			</ul>

			<div class="buttons">
				<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/itemManage.jsp'" value="戻る">
				<input type="reset" value="リセット">
				<input type="submit" value="変更">
			</div>

		</form>

		<form class="delete-button" action="/ShoppingSite/jp/co/aforce/servlets/Items/ItemDeleteController" method="post">
			<input type="hidden" name="item_id" value="${ib.item_id}">
			<input type="submit" value="削除する">
		</form>

		<p>${errorMsg}</p>

	</div>

</body>

</html>