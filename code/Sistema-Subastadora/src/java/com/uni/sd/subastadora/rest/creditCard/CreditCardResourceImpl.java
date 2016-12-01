package com.uni.sd.subastadora.rest.creditCard;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.creditcard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditcard.CreditCardResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("creditCardResource")
public class CreditCardResourceImpl extends BaseResourceImpl<CreditCardDTO> implements
		ICreditCardResource {

	public CreditCardResourceImpl() {
		super(CreditCardDTO.class, "/creditCard");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'creditCards'")
	//@CachePut(value = CACHE_REGION, key = "'creditCard_' + #creditCard.id", condition = "#creditCard.id!=null")
	public CreditCardDTO save(CreditCardDTO creditCard) {
		CreditCardDTO newDto = super.save(creditCard);
		/*if (null == creditCard.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"creditCard_" + newDto.getId(), newDto);
		}*/
		return newDto;
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'creditCard_' + #id")
	public CreditCardDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'creditCards'")
	public CreditCardResult getAll() {
		
		final CreditCardResult result = getWebResource().get(CreditCardResult.class);
		return result;
	}

	@Override
	public CreditCardResult find(String textToFind, int maxItems, int page) {
		
		final CreditCardResult result = findWR(textToFind, maxItems, page).get(
				CreditCardResult.class);
		return result;
	}
	

	public CreditCardResult find(String textToFind) {
		
		final CreditCardResult result = getWebResource().path("/search/" + textToFind).get(CreditCardResult.class);
		return result;
	}

}

