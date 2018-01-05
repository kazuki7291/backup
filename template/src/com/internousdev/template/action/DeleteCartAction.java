package com.internousdev.template.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dto.BuyItemCartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private Boolean DeleteFlag;

	public String execute(){
		@SuppressWarnings("unchecked")
		List<BuyItemCartDTO> buyItemCartList = (List<BuyItemCartDTO>) session.get("buyitemCartList");
		for(int i=0; i<buyItemCartList.size(); i++){
			if(DeleteFlag == true){
			}
			session.put("buyItemCart",buyItemCartList);
		}
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Boolean getDeleteFlag() {
		return DeleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		DeleteFlag = deleteFlag;
	}


}
