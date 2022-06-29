package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.util.SQL;

public class MemberUpdateModel extends DAO{

	public int updateMemberData(String member_id,String last_name, String first_name, String sex, String mail_address, String phone_number, int birth_year, int birth_month, int birth_day, String post_code, String prefecture, String cities, String house_number, String password) {

		int update = 0;

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.updateMemberDataSQL);){

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
			pstmt.setString(14, member_id);

			update = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return update;

	}

}
