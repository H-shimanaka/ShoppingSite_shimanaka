package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.util.SQL;

public class ItemUpdateModel extends DAO{

	public int updateItemData(String item_id, String item_name, int item_price, String item_photo, String item_category, String item_explain) {

		int update = 0;

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.updateItemDataSQL)){

			pstmt.setString(1, item_name);
			pstmt.setInt(2, item_price);
			pstmt.setString(3, item_photo);
			pstmt.setString(4, item_category);
			pstmt.setString(5, item_explain);
			pstmt.setString(6, item_id);

			update = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return update;

	}

}
