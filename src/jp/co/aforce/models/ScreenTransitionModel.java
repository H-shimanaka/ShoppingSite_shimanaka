package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.util.SQL;

public class ScreenTransitionModel extends DAO{

	public ItemBean searchSpecifiedItem(String item_id) {

		ItemBean ib = new ItemBean();

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.searchSpecifiedItemSQL);){

			pstmt.setString(1, item_id);

			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					ib.setItem_id(rs.getString("ITEM_ID"));
					ib.setItem_name(rs.getString("ITEM_NAME"));
					ib.setItem_price(rs.getInt("ITEM_PRICE"));
					ib.setItem_photo(rs.getString("ITEM_PHOTO"));
					ib.setItem_category(rs.getString("ITEM_CATEGORY"));
					ib.setItem_explain(rs.getString("ITEM_EXPLAIN"));
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return ib;

	}


	public CartBean changeCartContents(int cart_item_num) {

		CartBean cb = new CartBean();

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.changeCartContentsSQL);){

			pstmt.setInt(1, cart_item_num);

			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					cb.setCart_item_num(rs.getInt("CART_ITEM_NUM"));
					cb.setItem_id(rs.getString("ITEM_ID"));
					cb.setItem_name(rs.getString("ITEM_NAME"));
					cb.setItem_price(rs.getInt("ITEM_PRICE"));
					cb.setItem_photo(rs.getString("ITEM_PHOTO"));
					cb.setItem_count(rs.getInt("ITEM_COUNT"));
					cb.setTotal_price(rs.getInt("TOTAL_PRICE"));
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return cb;
	}

}
