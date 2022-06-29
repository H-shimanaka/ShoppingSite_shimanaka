package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.beans.ShoppingLogBean;
import jp.co.aforce.models.GetShoppingLogsModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/MemberShoppingLogsController"})
public class MemberShoppingLogsController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Object mb = session.getAttribute("mb");
		String member_id = ((MemberBean) mb).getMember_id();

		GetShoppingLogsModel model = new GetShoppingLogsModel();
		ArrayList<ShoppingLogBean> logs = model.getSpecificMemberShoppingLogs(member_id);

		request.setAttribute("logs", logs);
		request.getRequestDispatcher("/views/memberShoppingLogs.jsp").forward(request, response);

	}

}
