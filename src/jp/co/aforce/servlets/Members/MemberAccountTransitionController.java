package jp.co.aforce.servlets.Members;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/Members/MemberAccountTransitionController"})
public class MemberAccountTransitionController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Object mb = session.getAttribute("mb");

		try {

			if(mb == null) {
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/views/member_account.jsp").forward(request, response);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
