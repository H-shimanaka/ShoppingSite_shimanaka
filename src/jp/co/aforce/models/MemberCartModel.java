package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.util.SQL;

public class MemberCartModel extends DAO{

	public ArrayList<CartBean> specificMemberCart(String member_id) {

		ArrayList<CartBean> cartItems = new ArrayList<>();

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.specificMemberCartSQL)){

			pstmt.setString(1, member_id);

			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					CartBean cb = new CartBean();
					cb.setCart_item_num(rs.getInt("CART_ITEM_NUM"));
					cb.setItem_id(rs.getString("ITEM_ID"));
					cb.setItem_name(rs.getString("ITEM_NAME"));
					cb.setItem_price(rs.getInt("ITEM_PRICE"));
					cb.setItem_photo(rs.getString("ITEM_PHOTO"));
					cb.setItem_count(rs.getInt("ITEM_COUNT"));
					cb.setTotal_price(rs.getInt("TOTAL_PRICE"));
					cartItems.add(cb);
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return cartItems;
	}



}
