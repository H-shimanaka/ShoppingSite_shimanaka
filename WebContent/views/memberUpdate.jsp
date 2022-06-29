<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>会員情報変更・削除画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member-form.css">
</head>

<body>

	<form action="/ShoppingSite/jp/co/aforce/servlets/Members/MemberUpdateController" method="post">

		<b>会員情報更新</b>

		<ul>

			<li>会員番号<br>
				<input type="text" name="member_id" value="${mb.member_id}" readonly>

			<li>名前<br>
				姓 <input type="text" name="last_name" value="${mb.last_name}" required>
				名 <input type="text" name="first_name" value="${mb.first_name}" required></li>

			<li>性別<br>
				<c:choose>
				<c:when test="${mb.sex == '男'}">
				<input type="radio" name="sex" value="1" checked required>男
				<input type="radio" name="sex" value="2" required>女
				</c:when>
				<c:when test="${mb.sex == '女'}">
				<input type="radio" name="sex" value="1" required>男
				<input type="radio" name="sex" value="2" checked required>女
				</c:when>
				<c:otherwise>
				<input type="radio" name="sex" value="1" required>男
				<input type="radio" name="sex" value="2" required>女
				</c:otherwise>
				</c:choose></li>

			<li>生年月日<br>
				<select name="birth_year" id="birth_year" required>
					<option value=""></option>
					<c:if test="${not empty mb.birth_year}">
						<option value = "${mb.birth_year}" selected>${mb.birth_year}(設定値)</option>
					</c:if>
				</select> 年
				<select name="birth_month" id="birth_month" required>
					<option value=""></option>
					<c:if test="${not empty mb.birth_month}">
						<option value = "${mb.birth_month}" selected>${mb.birth_month}(設定値)</option>
					</c:if>
				</select> 月
				<select name="birth_day" id="birth_day" required>
					<option value=""></option>
					<c:if test="${not empty mb.birth_day}">
						<option value = "${mb.birth_day}" selected>${mb.birth_day}(設定値)</option>
					</c:if>
				</select> 日</li>

			<li>電話番号<br>
				<input type="tel" name="phone_number"value="${mb.phone_number}" required></li>

			<li>メールアドレス<br>
				<input type="text" name="mail_address" value="${mb.mail_address}" required></li>

			<li>郵便番号<br>
				<input type="text" name="post_code" value="${mb.post_code}" required></li>

			<li>住所<br>
				都道府県<input type="text" name="prefecture" value="${mb.prefecture}" required><br>
				市区町村<input type="text" name="cities" value="${mb.cities}" required><br>
				それ以降の住所<input type="text" name="house_number" value="${mb.house_number}" required></li>

			<li>パスワード<br>
				<input type="password" name="password" value="${mb.password}" required></li>
		</ul>

		<div class="update-buttons">
			<input type="reset" value="リセット">
			<input type="submit" id="submit" value="更新">
		</div>

		<div class="delete-buttons">
			<input type="button" onclick="location.href='/ShoppingSite/views/member_account.jsp'" value="戻る">
			<button type="submit" formaction="/ShoppingSite/jp/co/aforce/servlets/Members/MemberDeleteController" formmethod="post">削除する</button>
		</div>

		<p>${errorMsg}</p>

	</form>

	<script src="${pageContext.request.contextPath}/js/script.js"></script>

</body>

</html>