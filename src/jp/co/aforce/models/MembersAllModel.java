package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jp.co.aforce.beans.MemberBean;

public class MembersAllModel extends DAO{

	public ArrayList<MemberBean> getAllMembersData(){

		ArrayList<MemberBean> MemberList = new ArrayList<>();

		String sql = "SELECT * FROM member_info;";

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();){

			while(rs.next()) {
				MemberBean mb = new MemberBean();
				mb.setMember_id(rs.getString("MEMBER_ID"));
				mb.setLast_name(rs.getString("LAST_NAME"));
				mb.setFirst_name(rs.getString("FIRST_NAME"));
				mb.setSex(rs.getString("SEX"));
				mb.setBirth_year(rs.getInt("BIRTH_YEAR"));
				mb.setBirth_month(rs.getInt("BIRTH_MONTH"));
				mb.setBirth_day(rs.getInt("BIRTH_DAY"));
				mb.setPost_code(rs.getString("POST_CODE"));
				mb.setPrefecture(rs.getString("PREFECTURE"));
				mb.setCities(rs.getString("CITIES"));
				mb.setHouse_number(rs.getString("HOUSE_NUMBER"));
				mb.setPhone_number(rs.getString("PHONE_NUMBER"));
				mb.setMail_address(rs.getString("MAIL_ADDRESS"));
				MemberList.add(mb);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return MemberList;
	}


	public MemberBean getMemberDetailData(String member_id){

		MemberBean mb = new MemberBean();

		String sql = "SELECT * FROM member_info WHERE MEMBER_ID = ?;";

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){

			pstmt.setString(1, member_id);

			try (ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					mb.setMember_id(rs.getString("MEMBER_ID"));
					mb.setLast_name(rs.getString("LAST_NAME"));
					mb.setFirst_name(rs.getString("FIRST_NAME"));
					mb.setSex(rs.getString("SEX"));
					mb.setBirth_year(rs.getInt("BIRTH_YEAR"));
					mb.setBirth_month(rs.getInt("BIRTH_MONTH"));
					mb.setBirth_day(rs.getInt("BIRTH_DAY"));
					mb.setPost_code(rs.getString("POST_CODE"));
					mb.setPrefecture(rs.getString("PREFECTURE"));
					mb.setCities(rs.getString("CITIES"));
					mb.setHouse_number(rs.getString("HOUSE_NUMBER"));
					mb.setPhone_number(rs.getString("PHONE_NUMBER"));
					mb.setMail_address(rs.getString("MAIL_ADDRESS"));
				}

			} catch (Exception e) {

			}


		}catch (Exception e) {
			e.printStackTrace();
		}

		return mb;
	}

}
