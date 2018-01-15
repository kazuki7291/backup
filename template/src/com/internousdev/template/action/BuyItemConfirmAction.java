package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemComplateDAO;
import com.internousdev.template.dto.BuyItemCartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	private BuyItemComplateDAO buyItemComplateDAO = new BuyItemComplateDAO();

	/**
	 * 商品購入情報登録メソッド
	 *
	 * @author internous
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {

		List<BuyItemCartDTO> buyItemList = (List<BuyItemCartDTO>) session.get("buyitemCartList");

		buyItemComplateDAO.buyItemeInfo(
				buyItemList,
				session.get("total_count").toString(),
				session.get("total_price").toString(),
				session.get("pay").toString(),
				session.get("login_user_id").toString());
				/*
				session.get("id").toString(),
				session.get("login_user_id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString()
				*/


		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
