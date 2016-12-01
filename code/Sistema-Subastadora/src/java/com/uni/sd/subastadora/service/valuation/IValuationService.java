package com.uni.sd.subastadora.service.valuation;

import java.util.List;

import com.uni.sd.subastadora.beans.valuation.ValuationB;
import com.uni.sd.subastadora.dto.valuation.ValuationDTO;
import com.uni.sd.subastadora.services.base.IBaseService;

public interface IValuationService extends IBaseService<ValuationB, ValuationDTO> {
	public List <ValuationB> find(String textToFind);
}
