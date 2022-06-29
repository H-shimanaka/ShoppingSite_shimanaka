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
import jp.co.aforce.models.ItemUpdateModel;
import jp.co.aforce.models.ItemsAllModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/Items/ItemUpdateController"})
@MultipartConfig
public class ItemUpdateController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/login.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String item_id = request.getParameter("item_id");
		String item_name = request.getParameter("item_name");
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		String item_category = request.getParameter("item_category");
		String item_explain = request.getParameter("item_explain");

		Part part = request.getPart("item_photo");
		String item_photo = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String path = getServletContext().getRealPath("/img");

		ItemUpdateModel model = new ItemUpdateModel();
		int update = model.updateItemData(item_id, item_name, item_price, item_photo, item_category, item_explain);

		if(update == 0) {
			request.setAttribute("errorMsg", "商品情報の変更に失敗しました。");
			request.getRequestDispatcher("/views/itemManage.jsp").forward(request, response);
		}else {

			ItemsAllModel items = new ItemsAllModel();
			ArrayList<ItemBean> ItemList = items.getAllItemData();

			HttpSession session = request.getSession();
			session.removeAttribute("ItemList");
			session.setAttribute("ItemList", ItemList);

			part.write(path + File.separator + item_photo);
			request.setAttribute("errorMsg", "商品情報の変更に成功しました。");
			request.getRequestDispatcher("/views/itemManage.jsp").forward(request, response);
		}


	}

}
