package jp.co.aforce.servlets.Items;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.models.ItemDeleteModel;
import jp.co.aforce.models.ItemsAllModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/Items/ItemDeleteController"})
public class ItemDeleteController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/login.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String item_id = request.getParameter("item_id");

		ItemDeleteModel model = new ItemDeleteModel();
		int delete = model.deleteItemData(item_id);

		if(delete == 0) {
			request.setAttribute("errorMsg", "商品情報の削除に失敗しました。");
			request.getRequestDispatcher("/views/itemManage.jsp").forward(request, response);
		}else {

			ItemsAllModel items = new ItemsAllModel();
			ArrayList<ItemBean> ItemList = items.getAllItemData();

			HttpSession session = request.getSession();
			session.removeAttribute("ItemList");
			session.setAttribute("ItemList", ItemList);

			request.setAttribute("errorMsg", "商品情報の削除に成功しました。");
			request.getRequestDispatcher("/views/itemManage.jsp").forward(request, response);
		}


	}

}
