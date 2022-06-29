package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.util.SQL;

public class MemberDeleteModel extends DAO {

	public int deleteMemberData(String member_id,String last_name, String first_name, String sex, String mail_address, String phone_number, int birth_year, int birth_month, int birth_day, String post_code, String prefecture, String cities, String house_number, String password) {

		int delete = 0;

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.deleteMemberDataSQL);){

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

			delete = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return delete;

	}

}
