<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>商品情報変更画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/memberDetail.css">
</head>

<body>

	<div class="member-photo">
		<img src="${pageContext.request.contextPath}/img/profile-image.jpeg">
	</div>

	<div class="member_info">

		<ul>
			<li>会員番号：${mb.member_id}</li>
			<li>氏名：${mb.last_name} ${mb.first_name}</li>
			<li>性別：${mb.sex}</li>
			<li>生年月日：${mb.birth_year}/${mb.birth_month}/${mb.birth_day}</li>
			<li>郵便番号：${mb.post_code}</li>
			<li>住所：${mb.prefecture} ${mb.cities} ${mb.house_number}</li>
			<li>電話番号：${mb.phone_number}</li>
			<li>メールアドレス：${mb.mail_address}</li>
		</ul>

		<div class="return-button">
			<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/memberManage.jsp'" value="戻る">
		</div>

	</div>

</body>

</html>