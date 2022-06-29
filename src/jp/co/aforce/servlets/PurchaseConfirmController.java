package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.models.MemberCartModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/PurchaseConfirmController"})
public class PurchaseConfirmController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		Object mb = session.getAttribute("mb");
		String member_id = ((MemberBean) mb).getMember_id();

		MemberCartModel cartItems = new MemberCartModel();
		ArrayList<CartBean> CartList = cartItems.specificMemberCart(member_id);

		int cart_total_price = 0;
		for(CartBean cb : CartList) {
			cart_total_price += cb.getTotal_price();
		}

		request.setAttribute("cart_total_price", cart_total_price);
		request.setAttribute("CartList", CartList);
		request.getRequestDispatcher("/views/purchase-confirm.jsp").forward(request, response);

	}

}
