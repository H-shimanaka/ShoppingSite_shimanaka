package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.models.ScreenTransitionModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/ScreenTransitionController"})
public class ScreenTransitionController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/login.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String item_id = request.getParameter("item_id");
		ScreenTransitionModel model = new ScreenTransitionModel();
		ItemBean ib = model.searchSpecifiedItem(item_id);

		request.setAttribute("ib", ib);
		request.getRequestDispatcher("/views/cartAdd.jsp").forward(request, response);

	}

}
