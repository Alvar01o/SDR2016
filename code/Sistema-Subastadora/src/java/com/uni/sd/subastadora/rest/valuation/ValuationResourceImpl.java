package com.uni.sd.subastadora.rest.valuation;

import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.valuation.ValuationDTO;
import com.uni.sd.subastadora.dto.valuation.ValuationResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("valuationResource")
public class ValuationResourceImpl extends BaseResourceImpl<ValuationDTO> implements IValuationResource {

	public ValuationResourceImpl() {
		super(ValuationDTO.class, "/valuation");
	}

	@Override
	public ValuationResult getAll() {
		final ValuationResult result = getWebResource().get(ValuationResult.class);
		return result;
	}
	
	@Override
	public ValuationResult find(String textToFind) {
		final ValuationResult result = findWR(textToFind).get(ValuationResult.class);
		return result;
	}

}
