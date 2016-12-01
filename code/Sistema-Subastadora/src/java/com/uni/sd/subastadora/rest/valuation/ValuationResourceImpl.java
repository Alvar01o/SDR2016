package com.uni.sd.subastadora.rest.valuation;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.valuation.ValuationDTO;
import com.uni.sd.subastadora.dto.valuation.ValuationResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("valuationResource")
public class ValuationResourceImpl extends BaseResourceImpl<ValuationDTO> implements
		IValuationResource {

	public ValuationResourceImpl() {
		super(ValuationDTO.class, "/valuation");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'valuations'")
	//@CachePut(value = CACHE_REGION, key = "'valuation_' + #valuation.id", condition = "#valuation.id!=null")
	public ValuationDTO save(ValuationDTO valuation) {
		ValuationDTO newDto = super.save(valuation);
		/*if (null == valuation.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"valuation_" + newDto.getId(), newDto);
		}*/
		return newDto;
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'valuation_' + #id")
	public ValuationDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'valuations'")
	public ValuationResult getAll() {
		
		final ValuationResult result = getWebResource().get(ValuationResult.class);
		return result;
	}

	@Override
	public ValuationResult find(String textToFind, int maxItems, int page) {
		
		final ValuationResult result = findWR(textToFind, maxItems, page).get(
				ValuationResult.class);
		return result;
	}
	

	public ValuationResult find(String textToFind) {
		
		final ValuationResult result = getWebResource().path("/search/" + textToFind).get(ValuationResult.class);
		return result;
	}

}
