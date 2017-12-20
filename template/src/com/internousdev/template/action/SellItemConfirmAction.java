package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.SellItemConplateDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SellItemConfirmAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	private SellItemConplateDAO sellItemComplateDAO = new SellItemConplateDAO();

	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public List<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();

	/**
	 * 商品購入情報登録メソッド
	 *
	 * @author internous
	 */
	public String execute() throws SQLException {

		buyItemList = buyItemDAO.getBuyItemInfo();

		sellItemComplateDAO.sellItemeInfo(
				buyItemList.size()+1,
				session.get("SellItemName").toString(),
				Integer.parseInt(session.get("SellItemPrice").toString()),
				Integer.parseInt(session.get("Sellstock").toString())
				);

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
