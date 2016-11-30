package com.uni.sd.subastadora.rest.creditCard;

import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.creditCard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditCard.CreditCardResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("creditCardResource")
public class CreditCardResourceImpl extends BaseResourceImpl<CreditCardDTO> implements ICreditCardResource {

	public CreditCardResourceImpl() {
		super(CreditCardDTO.class, "/creditCard");
	}

	@Override
	public CreditCardResult getAll() {
		final CreditCardResult result = getWebResource().get(CreditCardResult.class);
		return result;
	}
	
	@Override
	public CreditCardResult find(String textToFind) {
		final CreditCardResult result = findWR(textToFind).get(CreditCardResult.class);
		return result;
	}

}
