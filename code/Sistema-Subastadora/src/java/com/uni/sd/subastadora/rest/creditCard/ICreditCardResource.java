package com.uni.sd.subastadora.rest.creditCard;

import com.uni.sd.subastadora.dto.creditcard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditcard.CreditCardResult;
import com.uni.sd.subastadora.rest.base.IBaseResource;

public interface ICreditCardResource extends IBaseResource<CreditCardDTO> {

	public CreditCardResult getAll();
	public CreditCardResult find(String textToFind, int maxItems, int page);
	public CreditCardResult find(String textToFind);
}

