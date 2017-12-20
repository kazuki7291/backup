
package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dto.BuyItemCartDTO;
import com.internousdev.template.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	/**
	 * アイテム購入個数
	 */
	private List<String> count;

	/**
	 * 支払い方法
	 */
	private String pay;

	/**
	 * アイテム情報を格納
	 */
	public Map<String, Object>  session;

	public List<BuyItemCartDTO> buyitemCartList = new ArrayList<>();

	/**
	 * 商品情報取得メソッド
	 *
	 * @author internous
	 */
	@SuppressWarnings("unchecked")
	public String execute() {
		String result = SUCCESS;

		// LoginActionで保存したSession(buyItemList)の値を取得します。
		List<BuyItemDTO> buyItemList = (List<BuyItemDTO>) session.get("buyItemList");

		int total_count = 0;
		int total_price = 0;

		for(int i = 0; i < buyItemList.size(); i++){
			if(Integer.parseInt(count.get(i)) != 0){
				BuyItemCartDTO buyitemCartDTO = new BuyItemCartDTO();
				buyitemCartDTO.setCount(Integer.parseInt(count.get(i)));
				buyitemCartDTO.setId(buyItemList.get(i).getId());
				buyitemCartDTO.setItemName(buyItemList.get(i).getItemName());
				buyitemCartDTO.setItemPrice(buyItemList.get(i).getItemPrice());
				buyitemCartList.add(buyitemCartDTO);

				total_count = total_count + buyitemCartDTO.getCount();
				total_price = total_price + Integer.parseInt(buyitemCartDTO.getItemPrice()) * buyitemCartDTO.getCount();
			}
		}


		session.put("total_count", total_count);
		session.put("total_price", total_price);

		session.put("buyitemCartList", buyitemCartList);

		String payment;

		if(pay.equals("1")) {

			payment = "現金払い";
			session.put("pay", payment);
		} else if(pay.equals(2)) {
			payment = "クレジットカード（一括）";
			session.put("pay", payment);
		} else{
				payment = "クレジットカード（分割）";
				session.put("pay", payment);
		}
		return result;
	}

	public List<String> getCount() {
		return count;
	}

	public void setCount(List<String> count) {
		this.count = count;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<BuyItemCartDTO> getBuyitemCartList() {
		return buyitemCartList;
	}

	public void setBuyitemCartList(List<BuyItemCartDTO> buyitemCartList) {
		this.buyitemCartList = buyitemCartList;
	}





}
