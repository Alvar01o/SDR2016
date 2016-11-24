package com.uni.sd.subastadora.service.valuation;

import com.uni.sd.subastadora.dao.valuation.ValuationDaoImpl;
import com.uni.sd.subastadora.domain.valuation.ValuationDomain;
import com.uni.sd.subastadora.dto.valuation.ValuationDTO;
import com.uni.sd.subastadora.dto.valuation.ValuationResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface IValuationService extends IBaseService<ValuationDTO, ValuationDomain, ValuationDaoImpl, ValuationResult> {

	public ValuationResult find(String textToFind);
}
