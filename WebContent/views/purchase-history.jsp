<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>購入履歴閲覧画面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/purchase-history.css">
</head>

<body>

	<table>
		<c:forEach var="log" items="${logs}">
			<tr>
				<td>${log.member_id}</td>
				<td>${log.purchase_datetime}</td>
				<td>${log.total_price}</td>
				<td>${log.payment_method}</td>
				<td>${log.logistic}</td>
			</tr>
		</c:forEach>
	</table>

	<div class="return-button">
		<input type="button" onclick="location.href='${pageContext.request.contextPath}/views/administrator.jsp'" value="戻る">
	</div>


</body>

</html>