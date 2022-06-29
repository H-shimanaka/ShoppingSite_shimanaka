<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
	<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap" rel="stylesheet">
</head>

<body>

<div class="announce-bar"></div>
	<header>

		<div class="header-title">
			<h1>BEANEARTH</h1>
		</div>

		<div class="home_menu">
			<nav>
				<ul>
					<li><a class="page-link" href="${pageContext.request.contextPath}/views/home.jsp"><span>HOME</span></a></li>
					<li><a class="page-link" href="${pageContext.request.contextPath}/views/shop.jsp">SHOP</a></li>
					<li><a class="page-link" href="${pageContext.request.contextPath}/views/inquiry-form.jsp">INQUIRY</a></li>
				</ul>
			</nav>
		</div>


		<div class="icon-wrapper">
			<nav>
				<ul>
					<li><form action="/ShoppingSite/jp/co/aforce/servlets/Members/MemberAccountTransitionController" method="post">
							<button type="submit"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path><circle cx="12" cy="7" r="4"></circle></svg></button>
						</form>
					</li>

					<li><form action="/ShoppingSite/jp/co/aforce/servlets/AllItemCartController" method="post">
							<button type="submit"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="10" cy="20.5" r="1"/><circle cx="18" cy="20.5" r="1"/><path d="M2.5 2.5h3l2.7 12.4a2 2 0 0 0 2 1.6h7.7a2 2 0 0 0 2-1.6l1.6-8.4H7.1"/></svg></button>
						</form>
					</li>

				</ul>
			</nav>
		</div>

	</header>

</body>
</html>