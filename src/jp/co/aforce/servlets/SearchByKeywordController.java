package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.models.ItemsAllModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/SearchByKeywordController"})
public class SearchByKeywordController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String item_category = request.getParameter("item_category");
		String keyword = request.getParameter("keyword");
		String sort = request.getParameter("sort");

		ItemsAllModel model = new ItemsAllModel();
		ArrayList<ItemBean> ItemList = model.getItemDataByKeyword(item_category, keyword, sort);

		request.setAttribute("item_category", item_category);
		request.setAttribute("keyword", keyword);
		request.setAttribute("ItemList", ItemList);
		request.getRequestDispatcher("/views/item-list.jsp").forward(request, response);

	}

}
