package com.uni.sd.subastadora.service.creditCard;

import java.util.List;

import com.uni.sd.subastadora.beans.creditCard.CreditCardB;
import com.uni.sd.subastadora.dto.creditcard.CreditCardDTO;
import com.uni.sd.subastadora.services.base.IBaseService;

public interface ICreditCardService extends IBaseService<CreditCardB, CreditCardDTO> {
	public List <CreditCardB> find(String textToFind);
}
