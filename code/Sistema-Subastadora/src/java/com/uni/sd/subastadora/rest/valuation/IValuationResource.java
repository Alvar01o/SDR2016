package com.uni.sd.subastadora.rest.valuation;

import com.uni.sd.subastadora.dto.valuation.ValuationDTO;
import com.uni.sd.subastadora.dto.valuation.ValuationResult;
import com.uni.sd.subastadora.rest.base.IBaseResource;

public interface IValuationResource extends IBaseResource<ValuationDTO> {

	public ValuationResult getAll();
	public ValuationResult find(String textToFind, int maxItems, int page);
	public ValuationResult find(String textToFind);
}
