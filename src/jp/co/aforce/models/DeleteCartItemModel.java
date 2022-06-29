package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.util.SQL;

public class DeleteCartItemModel extends DAO{

	public int deleteCartItem(int cart_item_num){

		int delete = 0;

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.deleteCartItemSQL);){

			pstmt.setInt(1, cart_item_num);

			delete = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return delete;

	}

}
