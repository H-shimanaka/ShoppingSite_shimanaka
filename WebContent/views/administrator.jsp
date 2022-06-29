<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>管理者画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-form.css">
</head>

<body>

	<form action="/ShoppingSite/jp/co/aforce/servlets/Members/LogoutController" method="post">

		<b>管理者メニュー</b>

		<div>
			<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/itemManage.jsp'" value="商品情報一覧">
			<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/memberManage.jsp'" value="登録会員一覧">
			<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/purchase-history.jsp'" value="購入履歴閲覧">
			<input type="submit" value="ログアウト">
		</div>

	</form>

</body>

</html>