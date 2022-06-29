package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.aforce.beans.ShoppingLogBean;
import jp.co.aforce.util.SQL;

public class GetShoppingLogsModel extends DAO{

	public ArrayList<ShoppingLogBean> getAllShoppingLogs() {

		ArrayList<ShoppingLogBean> logs = new ArrayList<>();

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.getAllShoppingLogsSQL);){

			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					ShoppingLogBean slb = new ShoppingLogBean();
					slb.setMember_id(rs.getString("MEMBER_ID"));
					slb.setPurchase_datetime(rs.getString("PURCHASE_DATETIME"));
					slb.setTotal_price(rs.getInt("TOTAL_PRICE"));
					slb.setPayment_method(rs.getString("PAYMENT_METHOD"));
					slb.setLogistic(rs.getString("LOGISTIC"));
					logs.add(slb);
				}

			}catch (SQLException e) {
				e.printStackTrace();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return logs;
	}


	public ArrayList<ShoppingLogBean> getSpecificMemberShoppingLogs(String member_id) {

		ArrayList<ShoppingLogBean> logs = new ArrayList<>();

		String sql ="SELECT * FROM shopping_logs WHERE MEMBER_ID = ?";

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){

			pstmt.setString(1, member_id);

			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					ShoppingLogBean slb = new ShoppingLogBean();
					slb.setMember_id(rs.getString("MEMBER_ID"));
					slb.setPurchase_datetime(rs.getString("PURCHASE_DATETIME"));
					slb.setTotal_price(rs.getInt("TOTAL_PRICE"));
					slb.setPayment_method(rs.getString("PAYMENT_METHOD"));
					slb.setLogistic(rs.getString("LOGISTIC"));
					logs.add(slb);
				}

			}catch (SQLException e) {
				e.printStackTrace();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return logs;
	}

}
