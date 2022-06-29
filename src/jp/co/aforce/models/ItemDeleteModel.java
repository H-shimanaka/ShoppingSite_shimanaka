package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.util.SQL;

public class ItemDeleteModel extends DAO{

	public int deleteItemData(String item_id) {

		int delete = 0;

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.deleteItemDataSQL)){

			pstmt.setString(1, item_id);

			delete = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return delete;

	}

}
