package com.uni.sd.subastadora.dto.creditcard;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseResult;

@XmlRootElement(name = "creditCardResult")
public class CreditCardResult extends BaseResult<CreditCardDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<CreditCardDTO> getCreditCards() {
		return getList();
	}

	public void setCreditCards(List<CreditCardDTO> dtos) {
		super.setList(dtos);
	}
}
