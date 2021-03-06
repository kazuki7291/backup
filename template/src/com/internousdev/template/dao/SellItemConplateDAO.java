package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class SellItemConplateDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO item_info_transaction (id, item_name, item_price, item_stock, insert_date) VALUES(?, ?, ?, ?, ?)";

	public Map<String, Object>  session;


	/**
	 * 商品購入情報登録メソッド
	 *
	 * @param item_transaction_id
	 * @param user_master_id
	 * @param total_price
	 * @param total_count
	 * @param pay
	 * @throws SQLException
	 */

	/*String item_transaction_id, String user_master_id, String total_price, String total_count, String pay*/
	public void sellItemeInfo(int id ,String item_name,int item_price,int item_stock) throws SQLException {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1,id);
				preparedStatement.setString(2, item_name);
				preparedStatement.setInt(3, item_price);
				preparedStatement.setInt(4, item_stock);
				preparedStatement.setString(5, dateUtil.getDate());

				preparedStatement.execute();

			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				connection.close();
			}
	}
}
