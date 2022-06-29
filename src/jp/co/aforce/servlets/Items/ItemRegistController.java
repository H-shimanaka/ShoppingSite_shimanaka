package jp.co.aforce.servlets.Items;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.models.ItemRegistModel;
import jp.co.aforce.models.ItemsAllModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/Items/ItemRegistController"})
@MultipartConfig
public class ItemRegistController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/login.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String item_name = request.getParameter("item_name");
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		String item_category = request.getParameter("item_category");
		String item_explain = request.getParameter("item_explain");

		Part part = request.getPart("item_photo");
		String item_photo = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String path = getServletContext().getRealPath("/img");

		ItemRegistModel model = new ItemRegistModel();
		int count = model.checkExistsItem(item_name, item_price, item_photo, item_category, item_explain);

		if(count == 0) {

			int insert = model.registNewItem(item_name, item_price, item_photo, item_category, item_explain);

			if(insert == 0) {

				request.setAttribute("errorMsg", "商品登録に失敗しました。");
				request.getRequestDispatcher("/views/itemManage.jsp").forward(request, response);

			}else {

				part.write(path + File.separator + item_photo);

				ItemsAllModel items = new ItemsAllModel();
				ArrayList<ItemBean> ItemList = items.getAllItemData();

				HttpSession session = request.getSession();
				session.removeAttribute("ItemList");
				session.setAttribute("ItemList", ItemList);

				request.setAttribute("errorMsg", "商品登録に成功しました。");
				request.getRequestDispatcher("/views/itemManage.jsp").forward(request, response);
			}

		}else {

			request.setAttribute("errorMsg", "商品情報が既に登録されています。");
			request.getRequestDispatcher("/views/itemRegist.jsp").forward(request, response);

		}

	}

}
