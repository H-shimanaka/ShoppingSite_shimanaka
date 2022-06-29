package jp.co.aforce.servlets.Members;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.beans.ShoppingLogBean;
import jp.co.aforce.models.GetShoppingLogsModel;
import jp.co.aforce.models.ItemsAllModel;
import jp.co.aforce.models.LoginModel;
import jp.co.aforce.models.MembersAllModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/Members/LoginController"})
public class LoginController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/login.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");

		LoginModel model = new LoginModel();
		MemberBean mb = model.loginAsMember(member_id, password);

		if(mb.getMember_id() == null){

			request.setAttribute("member_id", member_id);
			request.setAttribute("errorMsg", "会員番号またはパスワードが誤っています。");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);

		}else if(mb.getMember_id().equals("A20211004")) {

			MembersAllModel members = new MembersAllModel();
			ArrayList<MemberBean> MemberList = members.getAllMembersData();

			ItemsAllModel items = new ItemsAllModel();
			ArrayList<ItemBean> ItemList = items.getAllItemData();

			GetShoppingLogsModel logmodel = new GetShoppingLogsModel();
			ArrayList<ShoppingLogBean> logs = logmodel.getAllShoppingLogs();

			HttpSession session = request.getSession(true);
			session.setAttribute("logs", logs);
			session.setAttribute("ItemList", ItemList);
			session.setAttribute("MemberList", MemberList);
			session.setAttribute("mb", mb);

			request.getRequestDispatcher("/views/administrator.jsp").forward(request, response);

		}else {

			HttpSession session = request.getSession(true);
			session.setAttribute("mb", mb);

			request.getRequestDispatcher("/views/home.jsp").forward(request, response);

		}
	}

}
