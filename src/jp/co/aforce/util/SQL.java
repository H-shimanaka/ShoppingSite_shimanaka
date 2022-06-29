package jp.co.aforce.util;

public class SQL {

	//会員情報データベースに関するSQL
	public static final String LoginSQL = "SELECT * FROM member_info "
											+ "WHERE MEMBER_ID = ? "
											+ "AND PASSWORD = ?;";

	public static final String checkExistsMemberSQL = "SELECT COUNT(*) FROM member_info "
														+ "WHERE LAST_NAME = ? "
														+ "AND FIRST_NAME = ? "
														+ "AND SEX = ? "
														+ "AND BIRTH_YEAR = ? "
														+ "AND BIRTH_MONTH = ? "
														+ "AND BIRTH_DAY = ? "
														+ "AND POST_CODE = ? "
														+ "AND PREFECTURE = ? "
														+ "AND CITIES = ? "
														+ "AND HOUSE_NUMBER = ? "
														+ "AND PHONE_NUMBER = ? "
														+ "AND MAIL_ADDRESS = ? "
														+ "AND PASSWORD = ?;";

	public static final String registNewMemberSQL = "INSERT INTO member_info (MEMBER_ID, LAST_NAME, FIRST_NAME, SEX, BIRTH_YEAR, BIRTH_MONTH, BIRTH_DAY, POST_CODE, PREFECTURE, CITIES, HOUSE_NUMBER, PHONE_NUMBER, MAIL_ADDRESS, PASSWORD) "
														+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String updateMemberDataSQL = "UPDATE member_info SET "
														+ "LAST_NAME = ?, "
														+ "FIRST_NAME = ?, "
														+ "SEX = ?, "
														+ "BIRTH_YEAR = ?, "
														+ "BIRTH_MONTH = ?, "
														+ "BIRTH_DAY = ?, "
														+ "POST_CODE = ?, "
														+ "PREFECTURE = ?, "
														+ "CITIES = ?, "
														+ "HOUSE_NUMBER = ?, "
														+ "PHONE_NUMBER = ?, "
														+ "MAIL_ADDRESS = ?, "
														+ "PASSWORD = ? "
														+ "WHERE MEMBER_ID = ?;";

	public static final String deleteMemberDataSQL = "DELETE FROM member_info "
														+ "WHERE MEMBER_ID = ? "
														+ "AND LAST_NAME = ? "
														+ "AND FIRST_NAME = ? "
														+ "AND SEX = ? "
														+ "AND BIRTH_YEAR = ? "
														+ "AND BIRTH_MONTH = ? "
														+ "AND BIRTH_DAY = ? "
														+ "AND POST_CODE = ? "
														+ "AND PREFECTURE = ? "
														+ "AND CITIES = ? "
														+ "AND HOUSE_NUMBER = ? "
														+ "AND PHONE_NUMBER = ? "
														+ "AND MAIL_ADDRESS = ? "
														+ "AND PASSWORD = ?;";




	//商品情報データベースに関するSQL
	public static final String AllItemsSQL = "SELECT * FROM item_info";

	public static final String AllItemsByCategorySQL = "SELECT * FROM item_info WHERE ITEM_CATEGORY = ?;";

	public static final String checkExistsItemSQL = "SELECT COUNT(*) FROM item_info "
														+ "WHERE ITEM_NAME = ? "
														+ "AND ITEM_PRICE = ? "
														+ "AND ITEM_PHOTO = ? "
														+ "AND ITEM_CATEGORY = ? "
														+ "AND ITEM_EXPLAIN = ?;";

	public static final String searchSpecifiedItemSQL = "SELECT * FROM item_info WHERE ITEM_ID = ?";

	public static final String getItemDataByKeywordSQL = "SELECT * FROM (SELECT * FROM item_info WHERE ITEM_CATEGORY = ?) AS I WHERE ITEM_NAME LIKE ? ";

	public static final String registerNewItemSQL = "INSERT INTO item_info (ITEM_ID, ITEM_NAME, ITEM_PRICE, ITEM_PHOTO, ITEM_CATEGORY, ITEM_EXPLAIN) "
														+ "VALUES (?, ?, ?, ?, ?, ?);";

	public static final String updateItemDataSQL = "UPDATE item_info SET "
														+ "ITEM_NAME = ?, "
														+ "ITEM_PRICE = ?, "
														+ "ITEM_PHOTO = ?, "
														+ "ITEM_CATEGORY = ?, "
														+ "ITEM_EXPLAIN = ? "
														+ "WHERE ITEM_ID = ?;";

	public static final String deleteItemDataSQL = "DELETE FROM item_info "
													+ "WHERE ITEM_ID = ? ;";





	//カート情報データベースに関するSQL
	public static final String CartAddSQL = "INSERT INTO cart_info (MEMBER_ID, ITEM_ID, ITEM_NAME, ITEM_PRICE, ITEM_PHOTO, ITEM_COUNT, TOTAL_PRICE)"
												+ "VALUES (?, ?, ?, ?, ?, ?, ?);";

	public static final String specificMemberCartSQL = "SELECT * FROM cart_info WHERE MEMBER_ID = ?";

	public static final String changeCartContentsSQL = "SELECT * FROM cart_info WHERE CART_ITEM_NUM = ?;";

	public static final String deletePurchasedItemsSQL = "DELETE FROM cart_info WHERE MEMBER_ID = ?;";

	public static final String updateCartItemSQL = "UPDATE cart_info SET "
														+ "ITEM_COUNT = ?, "
														+ "TOTAL_PRICE = ? "
														+ "WHERE CART_ITEM_NUM = ?;";

	public static final String deleteCartItemSQL = "DELETE FROM cart_info WHERE CART_ITEM_NUM = ?;";





	//購入履歴データベースに関するSQL
	public static final String getAllShoppingLogsSQL =  "SELECT * FROM shopping_logs;";

	public static final String purchaseDicisionSQL = "INSERT INTO shopping_logs (MEMBER_ID, PURCHASE_DATETIME, TOTAL_PRICE, PAYMENT_METHOD, LOGISTIC, POST_CODE, PREFECTURE, CITIES, HOUSE_NUMBER, PHONE_NUMBER, MAIL_ADDRESS, PASSWORD) "
														+	"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

}
