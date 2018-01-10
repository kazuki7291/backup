package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GobuyItemConfirmAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;

	/**
	 * 支払い方法
	 */
	private String pay;

	public String execute() {
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

		return SUCCESS;
	}



	public String getPay() {
		return pay;
	}



	public void setPay(String pay) {
		this.pay = pay;
	}



	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
