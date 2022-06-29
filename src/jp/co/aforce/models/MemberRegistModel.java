package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.aforce.util.SQL;

public class MemberRegistModel extends DAO{

	public int checkExistsMember(String last_name, String first_name, String sex, String mail_address, String phone_number, int birth_year, int birth_month, int birth_day, String post_code, String prefecture, String cities, String house_number, String password) {

		int count = 0;

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.checkExistsMemberSQL);){

			pstmt.setString(1, last_name);
			pstmt.setString(2, first_name);
			pstmt.setString(3, sex);
			pstmt.setInt(4, birth_year);
			pstmt.setInt(5, birth_month);
			pstmt.setInt(6, birth_day);
			pstmt.setString(7, post_code);
			pstmt.setString(8, prefecture);
			pstmt.setString(9, cities);
			pstmt.setString(10, house_number);
			pstmt.setString(11, phone_number);
			pstmt.setString(12, mail_address);
			pstmt.setString(13, password);

			try(ResultSet rs = pstmt.executeQuery()){

				while(rs.next()) {
					count = rs.getInt("count(*)");
				}

			}catch(SQLException e) {
					e.printStackTrace();
				}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return count;

	}


	public int registNewMember(String last_name, String first_name, String sex, String mail_address, String phone_number, int birth_year, int birth_month, int birth_day, String post_code, String prefecture, String cities, String house_number, String password) {

		int insert = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String member_id = "M" + sdf.format(new Date());

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.registNewMemberSQL);){

			pstmt.setString(1, member_id);
			pstmt.setString(2, last_name);
			pstmt.setString(3, first_name);
			pstmt.setString(4, sex);
			pstmt.setInt(5, birth_year);
			pstmt.setInt(6, birth_month);
			pstmt.setInt(7, birth_day);
			pstmt.setString(8, post_code);
			pstmt.setString(9, prefecture);
			pstmt.setString(10, cities);
			pstmt.setString(11, house_number);
			pstmt.setString(12, phone_number);
			pstmt.setString(13, mail_address);
			pstmt.setString(14, password);

			insert = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return insert;

	}

}
