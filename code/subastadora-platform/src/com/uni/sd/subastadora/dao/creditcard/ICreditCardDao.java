package com.uni.sd.subastadora.dao.creditcard;

import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.creditcard.CreditCardDomain;

public interface ICreditCardDao extends IBaseDao<CreditCardDomain>{
	
	public List<CreditCardDomain>find(String textToFind);
	

}
