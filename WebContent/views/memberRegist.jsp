<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>新規会員登録画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member-form.css">
</head>

<body>

	<form action="/ShoppingSite/jp/co/aforce/servlets/Members/MemberRegistController" method="post">

		<b>新規会員登録</b>

		<ul>
			<li>名前<br>
				姓 <input type="text" name="last_name" required>
				名 <input type="text" name="first_name" required></li>

			<li>性別<br>
				<input type="radio" name="sex" value="1" required>男
				<input type="radio" name="sex" value="2" required>女</li>

			<li>生年月日<br>
				<select name="birth_year" id="birth_year" required><option value=""></option></select> 年
				<select name="birth_month" id="birth_month" required><option value=""></option></select> 月
				<select name="birth_day" id="birth_day" required><option value=""></option></select> 日</li>

			<li>電話番号<br>
				<input type="tel" name="phone_number" required></li>

			<li>メールアドレス<br>
				<input type="text" name="mail_address" required></li>

			<li>郵便番号<br>
				<input type="text" name="post_code" required></li>

			<li>住所<br>
				都道府県<input type="text" name="prefecture" required><br>
				市区町村<input type="text" name="cities" required><br>
				それ以降の住所<input type="text" name="house_number" required></li>

			<li>パスワード<br>
				<input type="password" name="password" required></li>
		</ul>

		<div class="update-buttons">
			<input type="button" onclick="location.href='/ShoppingSite/views/login.jsp'" value="戻る">
			<input type="reset" value="リセット">
			<input type="submit" id="submit" value="登録">
		</div>

		<p>${errorMsg}</p>

	</form>

	<script src="${pageContext.request.contextPath}/js/script.js"></script>

</body>

</html>