package jp.co.aforce.servlets.Members;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.models.MembersAllModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/Members/MemberDetailController"})
public class MemberDetailController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String member_id = request.getParameter("member_id");

		MembersAllModel model = new MembersAllModel();
		MemberBean mb = model.getMemberDetailData(member_id);

		request.setAttribute("mb", mb);
		request.getRequestDispatcher("/views/memberDetail.jsp").forward(request, response);

	}

}
