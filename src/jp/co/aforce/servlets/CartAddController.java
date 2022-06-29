package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.models.CartAddModel;
import jp.co.aforce.models.ScreenTransitionModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/CartAddController"})
public class CartAddController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Object mb = session.getAttribute("mb");
		String member_id = ((MemberBean) mb).getMember_id();

		String item_id = request.getParameter("item_id");
		int item_count = Integer.parseInt(request.getParameter("count"));

		ScreenTransitionModel model = new ScreenTransitionModel();
		ItemBean ib = model.searchSpecifiedItem(item_id);

		int total_price = Integer.parseInt(request.getParameter("total_price"));

		CartAddModel cam = new CartAddModel();
		int insert = cam.addItemToCart(member_id, ib.getItem_id(), ib.getItem_name(), ib.getItem_price(), ib.getItem_photo(), item_count, total_price);

		if(insert == 0) {

			request.setAttribute("errorMsg", "カートに追加できませんでした。");
			request.getRequestDispatcher("/views/shop.jsp").forward(request, response);

		}else {

			request.setAttribute("errorMsg", "カートに追加しました。");
			request.getRequestDispatcher("/views/shop.jsp").forward(request, response);

		}


	}

}
