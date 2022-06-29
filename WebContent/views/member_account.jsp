<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>アカウント画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/account_menu.css">
</head>

<body>

	<form action="/ShoppingSite/jp/co/aforce/servlets/Members/LogoutController" method="post">

		<b>アカウントメニュー</b>

		<div>
			<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/memberUpdate.jsp'" value="会員情報変更・削除">
			<button type="submit" formaction="/ShoppingSite/jp/co/aforce/servlets/MemberShoppingLogsController" formmethod="post">購入履歴閲覧</button>
			<input type="submit" value="ログアウト">
			<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/home.jsp'" value="戻る">
		</div>

	</form>

</body>

</html>