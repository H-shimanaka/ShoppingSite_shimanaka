package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.util.SQL;

public class PurchaseDecisionModel extends DAO{

	public int purchaseDecision(MemberBean mb, int cart_total_price, String logistic, String payment_method) {

		int insert = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = sdf.format(new Date());

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.purchaseDicisionSQL);){

			pstmt.setString(1, mb.getMember_id());
			pstmt.setString(2, datetime);
			pstmt.setInt(3, cart_total_price);
			pstmt.setString(4, payment_method);
			pstmt.setString(5, logistic);
			pstmt.setString(6, mb.getPost_code());
			pstmt.setString(7, mb.getPrefecture());
			pstmt.setString(8, mb.getCities());
			pstmt.setString(9, mb.getHouse_number());
			pstmt.setString(10, mb.getPhone_number());
			pstmt.setString(11, mb.getMail_address());
			pstmt.setString(12, mb.getPassword());

			insert = pstmt.executeUpdate();

		}catch (Exception e) {
			e.printStackTrace();
		}

		return insert;
	}


	public int deletePurchasedItems(String member_id) {

		int delete = 0;

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.deletePurchasedItemsSQL);){

			pstmt.setString(1, member_id);

			delete = pstmt.executeUpdate();

		}catch (Exception e) {
			e.printStackTrace();
		}

		return delete;

	}

}
