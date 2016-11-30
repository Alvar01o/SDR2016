package com.uni.sd.subastadora.dto.creditCard;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseDTO;

@XmlRootElement(name = "creditCard")
public class CreditCardDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _cardNumber;
	private Integer _userId;
	private Date _expiration;

	@XmlElement
	public String getCardNumber() {
		return _cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		_cardNumber = cardNumber;
	}
	
	
	@XmlElement
	public Integer getUserId() {
		return _userId;
	}

	public void setUserId(Integer userId) {
		_userId = userId;
	}
	
	@XmlElement
	public Date getExpiration() {
		return _expiration;
	}

	public void setExpiration(Date expiration) {
		_expiration = expiration;
	}

	
}
