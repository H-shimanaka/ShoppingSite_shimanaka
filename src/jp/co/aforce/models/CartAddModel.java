package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.util.SQL;

public class CartAddModel extends DAO{

	public int addItemToCart(String member_id, String item_id, String item_name, int item_price, String item_photo, int item_count, int total_price){

		int insert = 0;

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.CartAddSQL);){

			pstmt.setString(1, member_id);
			pstmt.setString(2, item_id);
			pstmt.setString(3, item_name);
			pstmt.setInt(4, item_price);
			pstmt.setString(5, item_photo);
			pstmt.setInt(6, item_count);
			pstmt.setInt(7, total_price);

			insert = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return insert;

	}

}
