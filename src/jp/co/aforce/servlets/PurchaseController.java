package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.models.LoginModel;
import jp.co.aforce.models.PurchaseDecisionModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/PurchaseController"})
public class PurchaseController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Object mb = session.getAttribute("mb");
		String member_id = ((MemberBean) mb).getMember_id();
		String password = ((MemberBean) mb).getPassword();

		int cart_total_price = Integer.parseInt(request.getParameter("cart_total_price"));
		String logistic = request.getParameter("logistic");
		String payment_method = request.getParameter("payment_method");

		LoginModel loginModel = new LoginModel();
		MemberBean purchase_user = loginModel.loginAsMember(member_id, password);

		PurchaseDecisionModel pdmodel = new PurchaseDecisionModel();
		int insert = pdmodel.purchaseDecision(purchase_user, cart_total_price, logistic, payment_method);

		if(insert == 0) {

			request.getRequestDispatcher("/views/purchase-confirm.jsp").forward(request, response);

		}else {

			int delete = pdmodel.deletePurchasedItems(member_id);

			if(delete == 0) {

				request.getRequestDispatcher("/views/purchase-confirm.jsp").forward(request, response);

			}else {

				request.getRequestDispatcher("/views/home.jsp").forward(request, response);

			}

		}


	}

}
