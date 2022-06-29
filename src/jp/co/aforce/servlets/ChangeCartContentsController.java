package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.models.ScreenTransitionModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/ChangeCartContentsController"})
public class ChangeCartContentsController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/login.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int cart_item_num = Integer.parseInt(request.getParameter("cart_item_num"));
		ScreenTransitionModel model = new ScreenTransitionModel();
		CartBean cb = model.changeCartContents(cart_item_num);

		request.setAttribute("cb", cb);
		request.getRequestDispatcher("/views/changeCartContents.jsp").forward(request, response);

	}

}
