package com.uni.sd.subastadora.service.creditcard;


import com.uni.sd.subastadora.dao.creditcard.CreditCardDaoImpl;
import com.uni.sd.subastadora.domain.creditcard.CreditCardDomain;
import com.uni.sd.subastadora.dto.creditcard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditcard.CreditCardResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface ICreditCardService extends IBaseService<CreditCardDTO, CreditCardDomain, CreditCardDaoImpl, CreditCardResult> {

	public CreditCardResult find(String textToFind);
}
