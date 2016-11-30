package com.uni.sd.subastadora.beans.creditCard;

import java.util.Date;
import java.util.Map;


import org.apache.commons.lang.StringUtils;

import com.uni.sd.subastadora.beans.base.BaseBean;
import com.uni.sd.subastadora.beans.user.UserB;

public class CreditCardB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _cardNumber;
	private Date _expiration;
	private UserB _user;
	
	public CreditCardB(Map<String, String> params) {
		super(params);
	}

	public String getCardNumber() {
		return _cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		_cardNumber = cardNumber;
	}

	
	public UserB getUser() {
		return _user;
	}

	public void setUser(UserB user) {
		_user = user;
	}
	
	public Date getExpiration() {
		return _expiration;
	}

	public void setExpiration(Date expiration) {
		_expiration = expiration;
	}
	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setCardNumber(params.get("name"));
	}

}