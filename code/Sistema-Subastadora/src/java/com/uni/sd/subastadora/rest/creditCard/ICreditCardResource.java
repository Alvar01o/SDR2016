package com.uni.sd.subastadora.rest.creditCard;


import com.uni.sd.subastadora.rest.base.IBaseResource;
import com.uni.sd.subastadora.dto.creditCard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditCard.CreditCardResult;

public interface ICreditCardResource extends IBaseResource<CreditCardDTO> {

	public CreditCardResult getAll();
	public CreditCardResult find(String textToFind);

}
