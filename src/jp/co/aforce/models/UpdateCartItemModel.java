package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.util.SQL;

public class UpdateCartItemModel extends DAO{

	public int updateCartItem(int item_count, int total_price, int cart_item_num){

		int update = 0;

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.updateCartItemSQL);){

			pstmt.setInt(1, item_count);
			pstmt.setInt(2, total_price);
			pstmt.setInt(3, cart_item_num);

			update = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return update;

	}

}
