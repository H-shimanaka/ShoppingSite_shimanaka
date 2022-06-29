<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>

<body>

	<p>${errorMsg}</p>

	<form action="/ShoppingSite/jp/co/aforce/servlets/Members/LoginController" method="post">

		<ul>
			<li><p>会員番号</p><br>
				<input type="text" name="member_id" value="${member_id}" required></li>

			<li><p>パスワード</p><br>
				<input type="password" name="password" required></li>
		</ul>

		<div>
			<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/memberRegist.jsp'" value="新規登録はこちら">
			<button type="submit">ログイン</button>
		</div>

	</form>

</body>

</html>