package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SellItemAction extends ActionSupport implements SessionAware {

	/*
	 * 画面の販売情報
	 */
	private String SellItemName;

	private String SellItemPrice;

	private String Sellstock;

	/*
	 * 情報を格納
	 */
	public Map<String, Object> session;



	public String execute() {

		session.put("SellItemName", SellItemName);
		session.put("SellItemPrice",SellItemPrice);
		session.put("Sellstock", Sellstock);

		return SUCCESS;
	}



	public String getSellItemName() {
		return SellItemName;
	}



	public void setSellItemName(String sellItemName) {
		SellItemName = sellItemName;
	}



	public String getSellItemPrice() {
		return SellItemPrice;
	}



	public void setSellItemPrice(String sellItemPrice) {
		SellItemPrice = sellItemPrice;
	}



	public String getSellstock() {
		return Sellstock;
	}



	public void setSellstock(String sellstock) {
		Sellstock = sellstock;
	}



	public Map<String, Object> getSession() {
		return session;
	}



	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}