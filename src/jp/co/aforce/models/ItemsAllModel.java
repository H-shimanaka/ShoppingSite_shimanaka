package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.util.SQL;

public class ItemsAllModel extends DAO{

	public ArrayList<ItemBean> getAllItemData() {

		ArrayList<ItemBean> items = new ArrayList<>();

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.AllItemsSQL)){

			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					ItemBean ib = new ItemBean();
					ib.setItem_id(rs.getString("ITEM_ID"));
					ib.setItem_name(rs.getString("ITEM_NAME"));
					ib.setItem_price(rs.getInt("ITEM_PRICE"));
					ib.setItem_photo(rs.getString("ITEM_PHOTO"));
					ib.setItem_category(rs.getString("ITEM_CATEGORY"));
					ib.setItem_explain(rs.getString("ITEM_EXPLAIN"));
					items.add(ib);
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return items;
	}


	public ArrayList<ItemBean> getItemDataByCategory(String item_category) {

		ArrayList<ItemBean> items = new ArrayList<>();

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL.AllItemsByCategorySQL)){

			pstmt.setString(1, item_category);

			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					ItemBean ib = new ItemBean();
					ib.setItem_id(rs.getString("ITEM_ID"));
					ib.setItem_name(rs.getString("ITEM_NAME"));
					ib.setItem_price(rs.getInt("ITEM_PRICE"));
					ib.setItem_photo(rs.getString("ITEM_PHOTO"));
					ib.setItem_category(rs.getString("ITEM_CATEGORY"));
					ib.setItem_explain(rs.getString("ITEM_EXPLAIN"));
					items.add(ib);
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return items;
	}


	public ArrayList<ItemBean> getItemDataByKeyword(String item_category, String keyword, String sort) {

		ArrayList<ItemBean> items = new ArrayList<>();

		String LikeWord = "%" + keyword + "%";

		String sql = SQL.getItemDataByKeywordSQL;

		if(!sort.equals("指定なし")) {
			 sql += "ORDER BY ITEM_PRICE " + sort;
		}

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, item_category);
			pstmt.setString(2, LikeWord);

			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					ItemBean ib = new ItemBean();
					ib.setItem_id(rs.getString("ITEM_ID"));
					ib.setItem_name(rs.getString("ITEM_NAME"));
					ib.setItem_price(rs.getInt("ITEM_PRICE"));
					ib.setItem_photo(rs.getString("ITEM_PHOTO"));
					ib.setItem_category(rs.getString("ITEM_CATEGORY"));
					ib.setItem_explain(rs.getString("ITEM_EXPLAIN"));
					items.add(ib);
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return items;
	}

}
