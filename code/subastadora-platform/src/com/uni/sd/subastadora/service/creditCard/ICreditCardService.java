package com.uni.sd.subastadora.service.creditCard;


import com.uni.sd.subastadora.dao.creditCard.CreditCardDaoImpl;
import com.uni.sd.subastadora.domain.creditCard.CreditCardDomain;
import com.uni.sd.subastadora.dto.creditCard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditCard.CreditCardResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface ICreditCardService extends IBaseService<CreditCardDTO, CreditCardDomain, CreditCardDaoImpl, CreditCardResult> {

	public CreditCardResult find(String textToFind);
}
