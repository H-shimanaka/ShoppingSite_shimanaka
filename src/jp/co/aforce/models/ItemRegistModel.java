package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.aforce.util.SQL;

public class ItemRegistModel extends DAO {

	public int checkExistsItem(String item_name, int item_price, String item_photo,String item_category, String item_explain) {

		int count = 0;

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.checkExistsItemSQL);){

			pstmt.setString(1, item_name);
			pstmt.setInt(2, item_price);
			pstmt.setString(3, item_photo);
			pstmt.setString(4, item_category);
			pstmt.setString(5, item_explain);

			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					count = rs.getInt("count(*)");
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return count;

	}


	public int registNewItem(String item_name, int item_price, String item_photo, String item_category, String item_explain) {

		int insert = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String item_id = "I" + sdf.format(new Date());

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.registerNewItemSQL);){

			pstmt.setString(1, item_id);
			pstmt.setString(2, item_name);
			pstmt.setInt(3, item_price);
			pstmt.setString(4, item_photo);
			pstmt.setString(5, item_category);
			pstmt.setString(6, item_explain);

			insert = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return insert;

	}

}
