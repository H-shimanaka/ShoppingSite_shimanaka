<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>登録会員一覧画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/memberManage.css">
</head>

<body>

	<h1>登録会員一覧</h1>

	<div class="registedMembers">
		<ul>
			<c:forEach var="mb" items="${MemberList}">
				<li class="members">
					<form action="/ShoppingSite/jp/co/aforce/servlets/Members/MemberDetailController" method="post">
						<div>
							<img class="members-img" src="${pageContext.request.contextPath}/img/profile-image.jpeg">
						</div>
						<input type="hidden" name="member_id" value="${mb.member_id}">
						<p>${mb.member_id}</p>
						<p>${mb.last_name} ${mb.first_name}</p>
						<button type="submit">詳細</button>
					</form>
				</li>
			</c:forEach>
		</ul>

		<div class="return-button">
			<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/administrator.jsp'" value="戻る">
		</div>

	</div>




</body>

</html>