package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.util.SQL;

public class LoginModel extends DAO {

	public MemberBean loginAsMember(String member_id, String password) {

		MemberBean mb = new MemberBean();

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.LoginSQL)){

			pstmt.setString(1, member_id);
			pstmt.setString(2, password);

			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					mb.setMember_id(rs.getString("MEMBER_ID"));
					mb.setLast_name(rs.getString("LAST_NAME"));
					mb.setFirst_name(rs.getString("FIRST_NAME"));
					mb.setSex(rs.getString("SEX"));
					mb.setBirth_year(rs.getInt("BIRTH_YEAR"));
					mb.setBirth_month(rs.getInt("BIRTH_MONTH"));
					mb.setBirth_day(rs.getInt("BIRTH_DAY"));
					mb.setPhone_number(rs.getString("PHONE_NUMBER"));
					mb.setMail_address(rs.getString("MAIL_ADDRESS"));
					mb.setPost_code(rs.getString("POST_CODE"));
					mb.setPrefecture(rs.getString("PREFECTURE"));
					mb.setCities(rs.getString("CITIES"));
					mb.setHouse_number(rs.getString("HOUSE_NUMBER"));
					mb.setPassword(rs.getString("PASSWORD"));
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return mb;

	}

}
