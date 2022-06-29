package jp.co.aforce.servlets.Members;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.models.MemberRegistModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/servlets/Members/MemberRegistController"})
public class MemberRegistController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/login.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String sex = null;
		String mail_address = request.getParameter("mail_address");
		String phone_number = request.getParameter("phone_number");
		int birth_year = Integer.parseInt(request.getParameter("birth_year"));
		int birth_month = Integer.parseInt(request.getParameter("birth_month"));
		int birth_day = Integer.parseInt(request.getParameter("birth_day"));
		String post_code = request.getParameter("post_code");
		String prefecture = request.getParameter("prefecture");
		String cities = request.getParameter("cities");
		String house_number = request.getParameter("house_number");
		String password = request.getParameter("password");

		if(request.getParameter("sex").equals("1")) {
			sex = "男";
		}else {
			sex = "女";
		}

		MemberRegistModel model = new MemberRegistModel();
		int count = model.checkExistsMember(last_name, first_name, sex, mail_address, phone_number, birth_year, birth_month, birth_day, post_code, prefecture, cities, house_number, password);

		if(count == 0) {

			int insert = model.registNewMember(last_name, first_name, sex, mail_address, phone_number, birth_year, birth_month, birth_day, post_code, prefecture, cities, house_number, password);
			if(insert == 0) {

				request.setAttribute("errorMsg", "会員登録に失敗しました。");
				request.getRequestDispatcher("/views/memberRegist.jsp").forward(request, response);

			}else {

				request.setAttribute("errorMsg", "会員登録に成功しました。");
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);

			}

		}else {

			request.setAttribute("errorMsg", "会員情報が既に登録されています。");
			request.getRequestDispatcher("/views/memberRegist.jsp").forward(request, response);

		}

	}

}
