<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>BEANEARTH INQUIRY</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/inquiry-form.css">
</head>

<body>

	<jsp:include page="/views/header.jsp"></jsp:include>

	<div class="head-img">
		<p>PLEASE  CONSULT  ANYTHING</p>
	</div>

	<div class="container">

		<form action="">

			<p>INQUIRY FORM</p>

			<div>
				<label>お名前 ※</label><br>
				<input type="text" required>
			</div>

			<div>
				<label>ご住所 ※</label><br>
				<input type="text" required>
			</div>

			<div>
				<label>お電話番号 ※</label><br>
				<input type="text" required>
			</div>

			<div>
				<label>メールアドレス ※</label><br>
				<input type="text" required>
			</div>

			<div>
				<label>ご質問等お問い合わせ内容</label><br>
				<textarea required></textarea>
			</div>

			<button type="submit">送信</button>

		</form>

	</div>

	<jsp:include page="/views/footer.jsp"></jsp:include>

</body>

</html>